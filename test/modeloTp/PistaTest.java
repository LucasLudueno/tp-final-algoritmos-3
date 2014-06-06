package modeloTp;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Pista;

public class PistaTest {
	
	@Test
	public void obtenerContenidoDePistaDeberiaDevolverElTextoIngresado() {
		
		Pista pista = new Pista("unTexto");
		
		Assert.assertTrue(pista.obtenerContenido() == "unTexto");
		
	}

}
