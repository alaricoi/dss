package pelis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {
	private final Log log = LogFactory.getLog(getClass());

	  
	      @RequestMapping(value="/")
	       public String sayHello(Model model) {
	    	
	    	 model.addAttribute("message", "Spring 3.0 MVC Framework Hello World Example!");
	       
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
	   
	      @RequestMapping(value="/logout", method = RequestMethod.GET)
	      public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	          if (auth != null){    
	              new SecurityContextLogoutHandler().logout(request, response, auth);
	          }
	          return "redirect:/login?logout";
	      }
	   


	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
}
