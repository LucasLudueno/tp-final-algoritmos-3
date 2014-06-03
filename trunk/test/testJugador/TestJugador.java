package testJugador;

import org.junit.Assert;
import org.junit.Test;

import clasesTp.Aeropuerto;
import clasesTp.Ciudad;
import clasesTp.Jugador;
import clasesTp.JugadorDetective;
import clasesTp.JugadorNovato;

public class TestJugador {

	@Test
	public void deberiaCrearseElJugadorConLosParametrosIntroducidos() {

		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		Assert.assertTrue(jugador.obtenerTiempoRestante() == 24);
				
	} 
	
	@Test
	public void deberiaCambiarseLaCiudadEnDondeEstaElJugador() {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new Jugador(BuenosAires,2,24);
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		
		jugador.cambiarDeCiudad(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == Paris);
		
	}
	
	@Test
	public void jugadorNovatoDebeObtenerUnaPistaFacilAlAccederAlAeropuerto() {
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorNovato jugador = new JugadorNovato(BuenosAires,1,1);
		
		Assert.assertTrue(jugador.obtenerPistaDe(new Aeropuerto()) == "a");		
	}
	
	@Test
	public void jugadorDetectiveDebeObtenerUnaPistaMediaAlAccederAlAeropuerto() {
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorDetective jugador = new JugadorDetective(BuenosAires,1,1);
		
		Assert.assertTrue(jugador.obtenerPistaDe(new Aeropuerto()) == "b");		
	}

}