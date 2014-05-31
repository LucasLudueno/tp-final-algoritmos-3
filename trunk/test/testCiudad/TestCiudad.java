package testCiudad;

import junit.framework.Assert;
import org.junit.Test;
import clasesTp.Ciudad;

public class TestCiudad {
	
	@Test
	public void deberiaCrearseLaCiudadConBuenosAiresComoNombreYPosicionIngresada(){
	
		Ciudad ciudad = new Ciudad("Buenos Aires",1,1);
		
		Assert.assertTrue(ciudad.nombre() == "Buenos Aires");
		Assert.assertTrue(ciudad.posicion_x() == 1);
		Assert.assertTrue(ciudad.posicion_y() == 1);
		
	}
	
}
