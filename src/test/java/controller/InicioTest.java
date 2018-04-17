package controller;


import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import pelis.configuration.PelisConfiguration;
import pelis.controller.InicioController;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {PelisConfiguration.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class InicioTest {
    @Test
  
    public void testHandleRequestView() throws Exception{		
        InicioController controller = new InicioController();
        controller.loginPage();
      
	/*	ModelAndView modelAndView = controller.();		
        assertEquals("This is protected page!", modelAndView.getModel().get("message"));*/
    }

}
