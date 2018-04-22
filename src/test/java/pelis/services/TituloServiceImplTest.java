package pelis.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pelis.CustomTest;
import pelis.domain.Genero;
import pelis.domain.Opinion;
import pelis.domain.Titulo;

public class TituloServiceImplTest extends CustomTest{
	
	
	 
	@Autowired
	@Qualifier("generoService")
	GeneroService generoService;

	
	@Autowired 
	@Qualifier("tituloService")
	TituloService tituloService;
	
	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Autowired 
	@Qualifier("opinionService")
	OpinionService opinionService;
	

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
		
		Titulo t1 = creaTitulo();
		Titulo t = tituloService.getByKey(t1.getIdTitulo());
		log.info(t.toString());
		assertEquals("titulo no encontrado", t, t1);
		
	}

	@Test
	public void testSave() {
		creaTitulo();
	}

	private Titulo creaTitulo() {
		Titulo t = new Titulo();
		t.setGenero( crearGenero());
		t.setDsTitulo("Prueba1");
		t.setDsDirector("Director");
		t.setNmAnyo(2017);
		t.setTlReparto("Prueba de reparto");
		t.setTlSinopsis("Prueba de sinopsis");
		
		
		
		Integer pk= tituloService.save(t);
		t.setIdTitulo(pk);
		Opinion o = crearOpinion(t);
		
				
		return t;
	}

	@Test
	public void testDelete() {

		Titulo t = creaTitulo();
		tituloService.delete(t);
		
	}
	
	
	@Test
	public void testFind() {
		List<Criterion> l = new ArrayList<Criterion>();
		Criterion c = Restrictions.eq("dsTitulo", "Otra prueba");
	    l.add(c);
		List<Titulo> lt = tituloService.find(l, new ArrayList<Order>() );
		assertNotNull("lista vacia", lt);
		log.info("Encontrados " + lt.size());
		log.info("El contador es:" + tituloService.count(l));
		
		
	}
	
	@Test
	public void testFindPaginado() {
		List<Criterion> l = new ArrayList<Criterion>();
		Criterion c = Restrictions.eq("dsTitulo", "Prueba1");
	    l.add(c);
		List<Titulo> lt = tituloService.find(l, new ArrayList<Order>(),1,3 );
		assertNotNull("lista vacia", lt);
		Long count = tituloService.count(l);
		log.info("Encontrados " + lt.size());
		log.info("El contador es:" + count);
		
		
	}
	
	
	private Genero crearGenero() {
		Genero g = new Genero();
		g.setDsGenero("Prueba1");
		g.setIdGenero(generoService.save(g));
		return g;
		
	}
	
	private Opinion crearOpinion(Titulo titulo) {
		Opinion o = new Opinion();
		o.setNmOpinion(1);
		o.setTitulo(titulo);
		o.setTlOpinion("Prueba de opnion");
		o.setUser(userService.findById(1));
		o.setIdOpinion(opinionService.save(o));
		log.info(o.toString());
		return o;
		
	}

}
