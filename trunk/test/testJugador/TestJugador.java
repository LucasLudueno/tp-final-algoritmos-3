package testJugador;

import junit.framework.Assert;
import org.junit.Test;
import clasesTp.Ciudad;
import clasesTp.Jugador;

public class TestJugador {

	@Test
	public void deberiaCrearseElJugadorConLosParametrosIntroducidos() {

		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(BuenosAires,2,24,"novato");
		
		Assert.assertTrue(jugador.ciudad() == BuenosAires);
		Assert.assertTrue(jugador.velocidad() == 2);
		Assert.assertTrue(jugador.tiempo() == 24);
		Assert.assertTrue(jugador.cargo() == "novato");
				
	}
	
	@Test
	public void deberiaCambiarseLaCiudadEnDondeEstaElJugador() {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new Jugador(BuenosAires,2,24,"novato");
		Assert.assertTrue(jugador.ciudad() == BuenosAires);
		
		jugador.cambiarDeCiudad(Paris);
		
		Assert.assertTrue(jugador.ciudad() == Paris);
		
	}	

}