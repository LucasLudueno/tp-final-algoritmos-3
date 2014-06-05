package modeloTpTest;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Ciudad;
import modeloTp.Jugador;

public class JugadorTest {

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
}