package modeloTpTest;

import org.junit.Test;
import org.junit.Assert;

import modeloTp.Aeropuerto;
import modeloTp.Ciudad;
import modeloTp.Jugador;
import modeloTp.JugadorDetective;
import modeloTp.JugadorNovato;

public class TpTest{

	@Test
	public void noDeberiaBajarElTiempoDelJugadorSiViajaALaMismaCiudadQueEsta(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new JugadorNovato(BuenosAires,2,24);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(24,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new JugadorNovato(BuenosAires,2,24);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(22 == jugador.obtenerTiempoRestante());
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaFacilSiElPersonajeEsUnNovato(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorNovato jugador = new JugadorNovato(BuenosAires,2,24);
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == "a");
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorDetective jugador = new JugadorDetective(BuenosAires,2,24);
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == "b");
	}

}