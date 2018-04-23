package pelis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pelis.domain.Titulo;
import pelis.services.TituloService;

@Controller
public class InicioController {
	private final Log log = LogFactory.getLog(getClass());

	@Autowired
	@Qualifier("tituloService")
	TituloService tituloService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String sayHello(@RequestParam(value = "page", required = false) String parampage, Model model) {

		model.addAttribute("message", "Nuestras peliculas favoritas " +  getPrincipal()); 
		
		 getPrincipal();
		List<Criterion> l = new ArrayList<Criterion>();
		Criterion c = Restrictions.eq("dsTitulo", "Prueba1");
	    l.add(c);
		int page = 1;
        int recordsPerPage = 10;
		Long total = tituloService.count(l);
        if(parampage != null)
            page = Integer.parseInt(parampage);
     
        Long noOfRecords = total;
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        // comienzo de la pagina
        int comienzo = (page-1) * recordsPerPage;
        		
		List <Titulo> titulos = tituloService.find(l, new ArrayList<Order>(),comienzo,recordsPerPage);

        model.addAttribute("listaPelis", titulos);
      
     
        model.addAttribute("noOfPages", noOfPages);
        model.addAttribute("currentPage", page);
		return "inicio";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
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
		return "redirect:/login?logout";
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
