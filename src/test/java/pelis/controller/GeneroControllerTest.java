package pelis.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import pelis.CustomTest;
import pelis.domain.Genero;

public class GeneroControllerTest extends CustomTest {
	@Inject
	private GeneroController controller;

 private  Model model = new ExtendedModelMap();

	@Test
	public void testInicio() {
		
		assertNotNull("correcto", controller.inicio(model));
	}

	@Test
	public void testDetalleGenero() {
		assertNotNull("correcto", controller.detalleGenero(1, model));
	}

	

	@Test
	public void testAltaGenero() {
		assertNotNull("correcto", controller.altaGenero("prubea", model));
	
		
	}

	@Test
	public void testActualizaGenero() {
	
		Genero g = new Genero();
		g.setDsGenero("prubea");
		g.setIdGenero(345);
		assertNotNull("correcto", controller.actualizaGenero(g, model));
	}

	@Test
	public void testBajaGenero() {
		assertNotNull("correcto", controller.altaGenero("1", model));
	}

}
