package pelis.services;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import pelis.configuration.HibernateConfiguration;
import pelis.configuration.PelisConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PelisConfiguration.class, HibernateConfiguration.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class CustomUserDetailsServiceTest {
	
	@Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
	
	@Test
	public void testLoadUserByUsername() {
		UserDetails u = userDetailsService.loadUserByUsername("isma");
		assertNotNull("Usuario no encontrado", u);
	}

}
