package modeloTpTest;

import org.junit.Test;
import org.junit.Assert;

import modeloTp.Aeropuerto;
import modeloTp.Ciudad;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.Jugador;
import modeloTp.JugadorDetective;
import modeloTp.JugadorNovato;

public class TpTest{

	@Test
	public void noDeberiaBajarElTiempoDelJugadorSiViajaALaMismaCiudadQueEsta() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(24,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(19 == jugador.obtenerTiempoRestante());
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaFacilSiElPersonajeEsUnNovato(){
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == "a");
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorDetective jugador = new JugadorDetective(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == "b");
	}

}