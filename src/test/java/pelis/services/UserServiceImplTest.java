package pelis.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pelis.CustomTest;
import pelis.domain.User;


public class UserServiceImplTest extends CustomTest {
	
	
	  
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Test
	public void testFindById() {
	
		User u = userService.findById(1);
		assertNotNull(u);
	}

	@Test
	public void testFindBySso() {
		 User u = userService.findBySso("bill");
		 assertNotNull(u);
	
	}

}
