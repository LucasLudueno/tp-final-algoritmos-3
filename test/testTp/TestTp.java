package testTp;

import org.junit.Test;

import clasesTp.Ciudad;
import clasesTp.Jugador;

import junit.framework.Assert;


public class TestTp{

	@Test
	public void deberiaNoVajarElTiempoSiViajoALaMismaCiudadQueEstoy(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(24,jugador.tiempo());
	}

	@Test
	public void deberiaViajar(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new Jugador(BuenosAires,2,24);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(22 == jugador.tiempo());
	}

}
