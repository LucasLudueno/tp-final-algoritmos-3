package testPista;

import modeloTp.Pista;

import org.junit.Assert;
import org.junit.Test;

public class PistaTest {
	
	@Test
	public void obtenerContenidoDePistaDeberiaDevolverUnTexto() {
		
		Pista pista = new Pista("unTexto");
		
		Assert.assertTrue(pista.obtenerContenido() == "unTexto");
		
	}

}
