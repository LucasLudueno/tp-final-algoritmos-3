package modeloTp;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Ciudad;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.Jugador;
import modeloTp.JugadorNovato;

public class JugadorTest {

	@Test
	public void deberiaCrearseElJugadorConLosParametrosIntroducidos() {

		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null);
		Jugador jugador = new Jugador(BuenosAires);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		Assert.assertTrue(jugador.obtenerTiempoRestante() == 154);
				
	} 
	
	@Test
	public void deberiaCambiarseLaCiudadEnDondeEstaElJugador() throws ExcepcionNoHayMasTiempo {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null);
		Ciudad Paris = new Ciudad("Paris",5,5,null,null,null);
		Jugador jugador = new JugadorNovato(BuenosAires);
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == Paris);
		
	}
	
	@Test(expected=ExcepcionNoHayMasTiempo.class)
	public void deberiaLanzarLaExcepcionCuandoNoHayMasTiempoParaViajarYNoCambiarDeCiudad() throws ExcepcionNoHayMasTiempo {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null);
		Ciudad Paris = new Ciudad("Paris",5000,5000,null,null,null);
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
						
	}
}