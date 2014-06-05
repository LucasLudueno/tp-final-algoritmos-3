package testPista;

import org.junit.Assert;
import org.junit.Test;

import clasesTp.Pista;

public class PistaTest {
	
	@Test
	public void obtenerContenidoDePistaDeberiaDevolverUnTexto() {
		
		Pista pista = new Pista("unTexto");
		
		Assert.assertTrue(pista.obtenerContenido() == "unTexto");
		
	}

}
