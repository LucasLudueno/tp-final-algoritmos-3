package modeloTp;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

import modeloTp.Ciudad;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.Jugador;

public class TpTest{

	@Test
	public void noDeberiaBajarElTiempoDelJugadorSiViajaALaMismaCiudadQueEsta() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(154,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad Paris = new Ciudad("Paris",5,5,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(149 == jugador.obtenerTiempoRestante());
	}
	
	@Test
	public void deberiaDevolverLaPreguntaDelAeropuerto(){
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAs");
		Pista pistaMediaAeropuertoBsAs = new Pista("pistaMediaBsAs");
		Pista pistaDificilAeropuertoBsAs = new Pista("pistaDificilBsAs");
		Lugar aeropuertoBuenosAires = new Lugar("Aeropuerto",pistaFacilAeropuertoBsAs, pistaMediaAeropuertoBsAs, pistaDificilAeropuertoBsAs);
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1, aeropuertoBuenosAires,null,null, new ArrayList<Ciudad>());
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		
		Assert.assertTrue( (jugador.obtenerCiudadActual()).obtenerPista(jugador,aeropuertoBuenosAires) == pistaFacilAeropuertoBsAs );
		
	}	
	
	 
	@Test
	public void deberianCambiarLasPistasDeLosLugaresSiCambioDeCiudad() throws ExcepcionNoHayMasTiempo{
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAs");
		Pista pistaMediaAeropuertoBsAs = new Pista("pistaMediaBsAs");
		Pista pistaDificilAeropuertoBsAs = new Pista("pistaDificilBsAs");
		Pista pistaFacilAeropuertoLondres = new Pista("pistaFacilLondres");
		Pista pistaMediaAeropuertoLondres = new Pista("pistaMediaLondres");
		Pista pistaDificilAeropuertoLondres = new Pista("pistaDificilLondres");
		
		Lugar aeropuertoBuenosAires = new Lugar("Aeropuerto", pistaFacilAeropuertoBsAs, pistaMediaAeropuertoBsAs, pistaDificilAeropuertoBsAs);
		Lugar aeropuertoLondres = new Lugar("Aeropuerto", pistaFacilAeropuertoLondres, pistaMediaAeropuertoLondres, pistaDificilAeropuertoLondres);
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1, aeropuertoBuenosAires,null,null, new ArrayList<Ciudad>());
		Ciudad Londres = new Ciudad("Londres",6,11, aeropuertoLondres,null,null, new ArrayList<Ciudad>());
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		
		Assert.assertTrue( (jugador.obtenerCiudadActual()).obtenerPista(jugador,aeropuertoBuenosAires) == pistaFacilAeropuertoBsAs );
		
		jugador.viajar(Londres);
		
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerPista(jugador,aeropuertoLondres) == pistaFacilAeropuertoLondres );
		
	}
	
	
	@Test		
	public void deberianCambiarLasPistasDeLosLugaresDeUnaMismaCiudad(){
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAsAerop");
		Pista pistaMediaAeropuertoBsAs = new Pista("pistaMediaBsAsAerop");
		Pista pistaDificilAeropuertoBsAs = new Pista("pistaDificilBsAsAerop");
		Pista pistaFacilBolsaBsAs = new Pista("pistaFacilBsAsBolsa");
		Pista pistaMediaBolsaBsAs = new Pista("pistaMediaBsAsBolsa");
		Pista pistaDificilBolsaBsAs = new Pista("pistaDificilBsAsBolsa");
		
		Lugar aeropuertoBsAs = new Lugar("Aeropuerto", pistaFacilAeropuertoBsAs, pistaMediaAeropuertoBsAs, pistaDificilAeropuertoBsAs);
		Lugar bolsaBsAs = new Lugar("Bolsa", pistaFacilBolsaBsAs, pistaMediaBolsaBsAs, pistaDificilBolsaBsAs);
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1, aeropuertoBsAs, bolsaBsAs,null, new ArrayList<Ciudad>());
		
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerPista(jugador,aeropuertoBsAs) == pistaFacilAeropuertoBsAs);
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerPista(jugador,bolsaBsAs) == pistaFacilBolsaBsAs );
		
		Assert.assertFalse((jugador.obtenerCiudadActual()).obtenerPista(jugador,aeropuertoBsAs) == (jugador.obtenerCiudadActual()).obtenerPista(jugador,bolsaBsAs) );
	
	}
	
	@Test
	public void obtenerPistaDeberiaBajarElTiempoDelJugadorIncrementandoseDeA1HoraCadaVezQueVuelveAEntrar(){
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAsAerop");
		Pista pistaFacilBolsaBsAs = new Pista("pistaFacilBsAsBolsa");;
		Pista pistaFacilBibliotecaBsAs = new Pista("pistaFacilBsAsBolsa");
		
		Lugar aeropuertoBsAs = new Lugar("Aeropuerto", pistaFacilAeropuertoBsAs, null, null);
		Lugar bolsaBsAs = new Lugar("Bolsa",pistaFacilBolsaBsAs, null, null);
		Lugar bibliotecaBsAs = new Lugar("Biblioteca",pistaFacilBibliotecaBsAs, null, null);
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1, aeropuertoBsAs, bolsaBsAs,bibliotecaBsAs, new ArrayList<Ciudad>());
		JugadorNovato jugador = new JugadorNovato(buenosAires);
		
		Integer tiempoActualJugador = jugador.obtenerTiempoRestante();
		buenosAires.obtenerPista(jugador,aeropuertoBsAs); // El jugador entra a un lugar por primera vez
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoActualJugador - 1) );
		
		tiempoActualJugador = jugador.obtenerTiempoRestante();
		buenosAires.obtenerPista(jugador,bolsaBsAs); // El jugador entra a un lugar por segunda vez
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoActualJugador - 2) );
		
		tiempoActualJugador = jugador.obtenerTiempoRestante();
		buenosAires.obtenerPista(jugador,bibliotecaBsAs); // El jugador entra a un lugar por tercera vez
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoActualJugador - 3) );
		
	}
	
	/*
	@Test
	public void jugadorNovatoNoAtrapaAlLadronCasoGrupo2(){
		Pista pistaFacilBibliotecaBsAs = new Pista( "Fue a un país asiático. Tenía una horrible cicatriz");
		Pista pistaFacilBancoHongKong = new Pista( "Consulto por el tipo de cambio del yen" );
		Pista pistaFacilPuertoHongKong = new Pista( "Fue a un país con bandera blanca y roja. Llevaba una raqueta" );
		Pista pistaFacilBancoTokio = new Pista("Pregunto por el tipo de cambio de la libra. Tenía pelo rubio");
		
		Lugar bibliotecaBsAs = new Lugar( "biblioteca", pistaFacilBibliotecaBsAs, null, null);
		Lugar bancoHongKong = new Lugar( "banco", pistaFacilBancoHongKong, null, null);
		Lugar puertoHongKong = new Lugar( "puerto", pistaFacilPuertoHongKong, null, null);
		Lugar bancoTokio = new Lugar( "banco", pistaFacilBancoTokio, null, null);
		
		Ciudad hongKong = new Ciudad( "Hong Kong", 3, 3, bancoHongKong, puertoHongKong, null, new ArrayList<Ciudad>());
		Ciudad buenosAires = new Ciudad( "Buenos Aires", 1, 1, bibliotecaBsAs, null, null,);
		Ciudad tokio = new Ciudad( "Tokio", 5, 5, bancoTokio, null, null);
		
		//Aca comienza lo que seria la prueba, lo demas se deberia cargar del XML
		JugadorNovato jugador = new JugadorNovato(buenosAires);
		
		ArrayList<Lugar> lugaresBsAs = ( (Ciudad)jugador.obtenerCiudadActual() ).obtenerLugares();
		Assert.assertTrue( buenosAires.obtenerPista(jugador, lugaresBsAs.get(0)) == pistaFacilBibliotecaBsAs);
		
		
		
		
		
	}
	*/
}