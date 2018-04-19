package pelis.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pelis.CustomTest;
import pelis.domain.Genero;
import pelis.domain.Titulo;

public class TituloServiceImplTest extends CustomTest{

	@Autowired
	@Qualifier("generoService")
	GeneroService generoService;

	
	@Autowired 
	@Qualifier("tituloService")
	TituloService tituloService;
	
	

	@Before
	 public void isnull () {
		if ( tituloService == null)
		 fail("nulo");
	}
	
	@Test
	public void testSaveOrUpdate() {
		Titulo t = new Titulo();
		t.setDsTitulo("Prueba1");
		t.setGenero( crearGenero());
		tituloService.saveOrUpdate(t);
	}

	@Test
	public void testGetAll() {
		testSaveOrUpdate();
		List<Titulo> l = tituloService.getAll();
	}

	@Test
	public void testUpdate() {
		Titulo t = new Titulo();
		t.setDsTitulo("Prueba1");
		t.setGenero( crearGenero());
		Integer pk= tituloService.save(t);
		
		t.setIdTitulo(pk);
		t.setDsTitulo("Otra prueba");
		tituloService.update(t);
		
	}

	@Test
	public void testGetByKey() {
		
		Integer pk = creaTitulo();
		Titulo t = tituloService.getByKey(pk);
		assertNotNull("titulo no encontrado", t);
	}

	@Test
	public void testSave() {
		creaTitulo();
	}

	private Integer creaTitulo() {
		Titulo t = new Titulo();
		t.setGenero( crearGenero());
		t.setDsTitulo("Prueba1");
		Integer pk= tituloService.save(t);
		return pk;
	}

	@Test
	public void testDelete() {

		Integer pk = creaTitulo();
		Titulo t = tituloService.getByKey(pk);
	
		tituloService.delete(t);
		
	}
	
	private Genero crearGenero() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		g.setIdGenero(generoService.save(g));
		return g;
		
	}

}
