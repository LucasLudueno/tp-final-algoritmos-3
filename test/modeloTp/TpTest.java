package modeloTp;

import org.junit.Test;
import org.junit.Assert;

import modeloTp.Ciudad;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.Jugador;

public class TpTest{

	@Test
	public void noDeberiaBajarElTiempoDelJugadorSiViajaALaMismaCiudadQueEsta() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(154,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(149 == jugador.obtenerTiempoRestante());
	}
	
	/*
	 * Faltaria agregarle todos los lugares a las ciudades como parametro.
	 
	@Test
	public void deberianCambiarLasPistasDeLosLugaresSiCambioDeCiudad() throws ExcepcionNoHayMasTiempo{
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAs");
		Pista pistaMediaAeropuertoBsAs = new Pista("pistaMediaBsAs");
		Pista pistaDificilAeropuertoBsAs = new Pista("pistaDificilBsAs");
		Pista pistaFacilAeropuertoLondres = new Pista("pistaFacilLondres");
		Pista pistaMediaAeropuertoLondres = new Pista("pistaMediaLondres");
		Pista pistaDificilAeropuertoLondres = new Pista("pistaDificilLondres");
		
		Lugar AeropuertoBuenosAires = new Aeropuerto(pistaFacilAeropuertoBsAs, pistaMediaAeropuertoBsAs, pistaDificilAeropuertoBsAs);
		Lugar AeropuertoLondres = new Aeropuerto(pistaFacilAeropuertoLondres, pistaMediaAeropuertoLondres, pistaDificilAeropuertoLondres);
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1, AeropuertoBuenosAires);
		Ciudad Londres = new Ciudad("Londres",6,11, AeropuertoLondres);
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		
		Assert.assertTrue( (jugador.obtenerCiudadActual()).obtenerPistaAeropuerto() == pistaFacilAeropuertoBsAs );
		
		jugador.viajar(Londres);
		
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerPistaAeropuerto() == pistaFacilAeropuertoLondres );
		
	}
	
	@Test
		* Faltaria agregarle todos los lugares a las ciudades como parametro.
		
	public void deberianCambiarLasPistasDeLosLugaresDeUnaMismaCiudad(){
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAsAerop");
		Pista pistaMediaAeropuertoBsAs = new Pista("pistaMediaBsAsAerop");
		Pista pistaDificilAeropuertoBsAs = new Pista("pistaDificilBsAsAerop");
		Pista pistaFacilBolsaBsAs = new Pista("pistaFacilBsAsBolsa");
		Pista pistaMediaBolsaBsAs = new Pista("pistaMediaBsAsBolsa");
		Pista pistaDificilBolsaBsAs = new Pista("pistaDificilBsAsBolsa");
		
		Lugar aeropuertoBsAs = new Aeropuerto(pistaFacilAeropuertoBsAs, pistaMediaAeropuertoBsAs, pistaDificilAeropuertoBsAs);
		Lugar bolsaBsAs = new Aeropuerto(pistaFacilBolsaBsAs, pistaMediaBolsaBsAs, pistaDificilBolsaBsAs);
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1, aeropuertoBsAs, bolsaBsAs);
		
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		
		Assert.assertTrue( (jugador.obtenerCiudadActual()).obtenerPistaAeropuerto() == pistaFacilAeropuertoBsAs );
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerPistaBolsa() == pistaFacilBolsaBsAs );
		
		Assert.assertFalse((jugador.obtenerCiudadActual()).obtenerPistaAeropuerto() == (jugador.obtenerCiudadActual()).obtenerPistaBolsa() );
	
	*/
}