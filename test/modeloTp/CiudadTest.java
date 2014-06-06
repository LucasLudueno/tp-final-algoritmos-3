package modeloTp;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Ciudad;

public class CiudadTest {
	
	@Test
	public void deberiaCrearseLaCiudadConBuenosAiresComoNombreYPosicionYLugaresIngresados(){
	
		
		Ciudad ciudad = new Ciudad("Buenos Aires",1,1,null,null,null);
		
		Assert.assertTrue(ciudad.obtenerNombre() == "Buenos Aires");
		Assert.assertTrue(ciudad.obtenerPosicion_x() == 1);
		Assert.assertTrue(ciudad.obtenerPosicion_y() == 1);
		Assert.assertTrue(ciudad.cantidadLugares() == 3);
		
		
	}
	
	@Test
	public void obtenerDistanciaDeberiaDevolverLaDistanciaEntreLasCiudades(){
		
		Ciudad ciudad1 = new Ciudad("Buenos Aires",1,1,null,null,null);
		Ciudad ciudad2 = new Ciudad("Londres",4,5,null,null,null);
		
		Assert.assertEquals(5, ciudad1.obtenerDistancia(ciudad2));
	}
	
}