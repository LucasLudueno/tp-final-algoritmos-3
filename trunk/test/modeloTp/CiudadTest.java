package modeloTp;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import modeloTp.Ciudad;

public class CiudadTest {
	
	@Test
	public void deberiaCrearseLaCiudadConBuenosAiresComoNombreYPosicionYLugaresIngresados(){
	
		Ciudad ciudad = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>() );
		
		Assert.assertTrue(ciudad.obtenerNombre() == "Buenos Aires");
		Assert.assertTrue(ciudad.obtenerPosicion_x() == 1);
		Assert.assertTrue(ciudad.obtenerPosicion_y() == 1);
		Assert.assertTrue(ciudad.cantidadLugares() == 3);
		
	}
	
	@Test
	public void obtenerDistanciaDeberiaDevolverLaDistanciaEntreLasCiudades(){
		
		Ciudad ciudad1 = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad ciudad2 = new Ciudad("Londres",4,5,null,null,null, new ArrayList<Ciudad>());
		
		Assert.assertEquals(5, ciudad1.obtenerDistancia(ciudad2));
	}
	
	@Test
	public void obtenerLugaresDeberiaDevolverLosLugaresIngresados(){
		Lugar aeropuerto = new Lugar("Aeropuerto",null, null, null, null);
		Lugar bolsa = new Lugar("Bolsa",null, null, null, null);
		Lugar biblioteca = new Lugar("Biblioteca",null, null, null, null);
		Ciudad buenosAires = new Ciudad("Buenos Aires", 1, 1, aeropuerto, bolsa, biblioteca, new ArrayList<Ciudad>());
		
		ArrayList<Lugar> lugaresCiudad = buenosAires.obtenerLugares();
		
		Assert.assertTrue( lugaresCiudad.contains(aeropuerto) );
		Assert.assertTrue( lugaresCiudad.contains(bolsa) );
		Assert.assertTrue( lugaresCiudad.contains(biblioteca) );
		
	}
	
	@Test 
	public void obtenerCiudadesAViajarDeberiaDevolverLasCiudadesIngresadas(){
		Ciudad tokio = new Ciudad("Tokio", 12, 1, null, null, null, new ArrayList<Ciudad>());
		Ciudad mexico = new Ciudad("Mexico", 13, 1, null, null, null, new ArrayList<Ciudad>());
		ArrayList<Ciudad> ciudadesAViajarDesdeBsAs = new ArrayList<Ciudad>();
		ciudadesAViajarDesdeBsAs.add(tokio);
		ciudadesAViajarDesdeBsAs.add(mexico);
		
		Ciudad buenosAires = new Ciudad("Buenos Aires", 1, 1, null, null, null, ciudadesAViajarDesdeBsAs);

		Assert.assertTrue( buenosAires.obtenerCiudadesAViajar() == ciudadesAViajarDesdeBsAs );
		
	}
	
}