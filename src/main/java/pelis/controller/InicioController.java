package pelis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Encoder;
import org.owasp.esapi.codecs.Codec;
import org.owasp.esapi.codecs.HTMLEntityCodec;
import org.owasp.esapi.codecs.JavaScriptCodec;
import org.owasp.esapi.codecs.MySQLCodec;
import org.owasp.esapi.reference.DefaultEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pelis.domain.Titulo;
import pelis.dto.TituloFilter;
import pelis.services.TituloService;
import pelis.util.Util;

@Controller
public class InicioController {
	private static final Log log = LogFactory.getLog(InicioController.class);

	@Autowired
	@Qualifier("tituloService")
	private TituloService tituloService;

	/**
	 * Carga inicialmente la lista de titulos. Si se llama a la uri admin/titulos
	 * mostrará la lista de titulos para el mantenimiento por configuración de
	 * springSecurity delegamos el control de acceso a dicha uri
	 * 
	 * @param filtro
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "admin", }, method = { RequestMethod.GET, RequestMethod.POST })
	public String inicio(@ModelAttribute("tituloFilter") TituloFilter filtro, HttpServletRequest request, Model model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("message", "Nuestras películas favoritas ");

		
		

		List<Criterion> l = new ArrayList<Criterion>();
		Criterion c;
		int page = 1;
		if (filtro != null) {
			if (filtro.getCurrentPage() != null)
				page = filtro.getCurrentPage();
			
			String tituloSaneado = Util.escapeESAPI(filtro.getTitulo());
			String directorSaneado = Util.escapeESAPI(filtro.getDirector());
			if (filtro.getTitulo() != null && !filtro.getTitulo().equals("")) {
				c = Restrictions.ilike("dsTitulo", 
						tituloSaneado, MatchMode.ANYWHERE);
				l.add(c);

			}
			if (filtro.getDirector() != null && !filtro.getDirector().equals("")) {
				c = Restrictions.ilike("dsDirector", directorSaneado, MatchMode.ANYWHERE);
				l.add(c);
			}

		}

		model.addAttribute("filtro", filtro);
		int recordsPerPage = 10;
		Long total = tituloService.count(l);

		Long noOfRecords = total;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		// Si hay nuevo filtro y el numero de pagina es menor del actual reseteamos las
		// paginas
		if (noOfPages < page)
			page = 1;

		// comienzo de la pagina
		int comienzo = (page - 1) * recordsPerPage;

		List<Titulo> titulos = tituloService.find(l, new ArrayList<Order>(), comienzo, recordsPerPage);

		model.addAttribute("listaPelis", titulos);

		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		return "inicio";

	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("listaPelis", tituloService.getAll());

		return "dba";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		log.error("acceso denegado");
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/?logout";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
