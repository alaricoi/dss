package pelis.services;

import static org.junit.Assert.*;

import java.util.List;

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
import pelis.domain.Genero;
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = {PelisConfiguration.class, HibernateConfiguration.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
@WebAppConfiguration
public class GeneroServiceImplTest {

	
	@Autowired
	GeneroService generoService;
	
	@Test
	public void testSaveOrUpdate() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		generoService.saveOrUpdate(g);
	}

	@Test
	public void testGetAll() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		generoService.save(g);
		List<Genero> l = generoService.getAll();
	}

	@Test
	public void testUpdate() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		Integer pk= generoService.save(g);
		
		g.setIdGenero(pk);
		g.setDsGenero("Otra prueba");
		generoService.update(g);
		
	}

	@Test
	public void testGetByKey() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		Integer pk = generoService.save(g);
		g = generoService.getByKey(pk);
	}

	@Test
	public void testSave() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		Integer pk= generoService.save(g);
	}

	@Test
	public void testDelete() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		Integer pk = generoService.save(g);
		g.setIdGenero(pk);
		generoService.delete(g);
		
	}

}
