package modeloTp;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Ciudad;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.Jugador;
import modeloTp.JugadorNovato;

public class JugadorTest {

	@Test
	public void deberiaCrearseElJugadorConLosParametrosIntroducidos() {

		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new Jugador(BuenosAires, null);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		Assert.assertTrue(jugador.obtenerTiempoRestante() == 154);
				
	} 
	
	@Test
	public void deberiaCambiarseLaCiudadEnDondeEstaElJugador() throws ExcepcionNoHayMasTiempo {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad Paris = new Ciudad("Paris",5,5,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == Paris);
		
	}
	
	@Test(expected=ExcepcionNoHayMasTiempo.class)
	public void deberiaLanzarLaExcepcionCuandoNoHayMasTiempoParaViajarYNoCambiarDeCiudad() throws ExcepcionNoHayMasTiempo {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad Paris = new Ciudad("Paris",5000,5000,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
						
	}
	
	@Test
	public void herirAJugadorConCuchilloDeberiaReducirElTiempoDelJugador2Horas(){
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(buenosAires, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.recibirCuchillazo();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 2) );		
		
	}
	
	@Test
	public void herirAJugadorConArmaDeFuegoDeberiaReducirElTiempoDelJugador4Horas(){
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(buenosAires, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.recibirBalazo();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 4) );		
		
	}
	
	@Test
	public void deberiaReducirElTiempoDelJugador8HorasSiEsteDuerme(){
		
		Jugador jugador = new JugadorNovato(null, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.dormir();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 8) );		
		
	}
	
	@Test
	public void deberiaReducirEltiempoDelJugador3HorasSiSeEmiteOrdenDeArresto(){
		
		Jugador jugador = new JugadorNovato(null, new ComputadoraPolicial( new ArrayList<Ladron>() ));
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.emitirOrdenDeArresto(null, null, null, null, null);
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 3) );
	}
	
	
}