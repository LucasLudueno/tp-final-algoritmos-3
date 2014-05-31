package testTp;

import org.junit.Test;

import clasesTp.Aeropuerto;
import clasesTp.Ciudad;
import clasesTp.Jugador;

import junit.framework.Assert;

public class TestTp{

	@Test
	public void deberiaNoVajarElTiempoSiViajoALaMismaCiudadQueEstoy(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24,"novato");
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(24,jugador.tiempo());
	}

	@Test
	public void deberiaViajar(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new Jugador(BuenosAires,2,24,"novato");
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(22 == jugador.tiempo());
	}
	
	@Test
	public void deberiaDevolverLaPreguntaFacilSiElPersonajeEsUnNovato(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24,"novato");
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPregunta(jugador) == "a");
	}
	
	@Test
	public void deberiaDevolverLaPreguntaDificilSiElPersonajeEsDetective(){
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24,"detective");
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPregunta(jugador) == "c");
	}

}
