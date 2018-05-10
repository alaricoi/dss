package pelis.controller;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import pelis.CustomTest;

public class TituloControllerTest extends CustomTest {
    @Inject
	private TituloController controller;

 private  Model model = new ExtendedModelMap();
	@Test
	public void testDetalleTitulo() {
		assertNotNull("correcto", controller.detalleTitulo(280, model));
	}

}
