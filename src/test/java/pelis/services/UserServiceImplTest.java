package pelis.services;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import pelis.configuration.HibernateConfiguration;
import pelis.configuration.PelisConfiguration;
import pelis.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {PelisConfiguration.class, HibernateConfiguration.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class UserServiceImplTest {
	
	
	  
	@Autowired
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
