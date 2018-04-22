package pelis.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import pelis.CustomTest;


public class CustomUserDetailsServiceTest extends CustomTest{
	
	@Autowired
    @Qualifier("miUserDetailsService")
    UserDetailsService userDetailsService;
	
	@Test
	public void testLoadUserByUsername() {
		UserDetails u = userDetailsService.loadUserByUsername("isma");
		assertNotNull("Usuario no encontrado", u);
	}

}
