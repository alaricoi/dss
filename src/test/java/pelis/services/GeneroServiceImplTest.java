package pelis.services;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pelis.CustomTest;
import pelis.domain.Genero;

public class GeneroServiceImplTest extends CustomTest{

	
	@Autowired
	@Qualifier("generoService")
	GeneroService generoService;

	
	@Before
	 public void isnull () {
		if ( generoService == null)
		 fail("nulo");
	}
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
		assertNotNull("Objeto Nulo", l);
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
		assertNotNull("No encontrado", pk);
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
