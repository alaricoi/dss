package pelis.controller;


import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import pelis.CustomTest;
import pelis.dto.TituloFilter;

public class InicioTest  extends CustomTest{
	@Inject
	 private InicioController controller;
	 private ModelMap model = new ExtendedModelMap();

	@Test
	  @WithMockUser(username = "isma")
    public void testHandleRequestView() throws Exception{		
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        assertNotNull("principal nulo", principal);
        
        controller.loginPage();
      
        controller.accessDeniedPage(model);
        
       
    }
	
	@Test
	  @WithMockUser(username = "isma")
	 public void testInicio() throws Exception{	
		TituloFilter f = new TituloFilter();
		f.setTitulo("Prueba");
		f.setDirector("direc");
		f.setCurrentPage(1);
		assertNotNull("principal nulo",controller.inicio(f, (Model) model));
		 
	 }
	 
}
