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
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(154,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad Paris = new Ciudad("Paris",5,5,null,null,null, new ArrayList<Ciudad>());
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
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
		JugadorNovato jugador = new JugadorNovato(BuenosAires, null);
		
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
		JugadorNovato jugador = new JugadorNovato(BuenosAires, null);
		
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
		
		JugadorNovato jugador = new JugadorNovato(BuenosAires, null);
		
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
		JugadorNovato jugador = new JugadorNovato(buenosAires, null);
		
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
	
	
	@Test
	public void jugadorNovatoNoAtrapaAlLadronCasoGrupo2() throws ExcepcionNoHayMasTiempo{
		Ladron ladron = new Ladron("Carmen San Diego", "femenino", "tennis", "rubio", "cicatriz", "ninguno");
		Ladron sospechoso = new Ladron("John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "ninguno");
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(ladron);
		sospechosos.add(sospechoso);
		ComputadoraPolicial computadora = new ComputadoraPolicial(sospechosos);
		
		Pista pistaFacilBibliotecaBsAs = new Pista( "Fue a un pais asiatico. Tenia una horrible cicatriz");
		Pista pistaFacilBancoHongKong = new Pista( "Consulto por el tipo de cambio del yen" );
		Pista pistaFacilPuertoHongKong = new Pista( "Fue a un pais con bandera blanca y roja. Llevaba una raqueta" );
		Pista pistaFacilBancoTokio = new Pista("Pregunto por el tipo de cambio de la libra. Tenia pelo rubio");
		
		Lugar bibliotecaBsAs = new Lugar( "biblioteca", pistaFacilBibliotecaBsAs, null, null);
		Lugar bancoHongKong = new Lugar( "banco", pistaFacilBancoHongKong, null, null);
		Lugar puertoHongKong = new Lugar( "puerto", pistaFacilPuertoHongKong, null, null);
		Lugar bancoTokio = new Lugar( "banco", pistaFacilBancoTokio, null, null);
		
		Pista ordenDeArrestoIncorrecta = new Pista("Orden de arresto incorrecta");
		LugarConLadron bancoLondres = new LugarConLadron( null , ladron, null, ordenDeArrestoIncorrecta, null );
		
		Ciudad londres = new Ciudad( "Londes", 7, 7, bancoLondres, null, null, new ArrayList<Ciudad>() );
		ArrayList<Ciudad> ciudadesAViajarTokio = new ArrayList<Ciudad>();
		ciudadesAViajarTokio.add(londres);
		Ciudad tokio = new Ciudad( "Tokio", 5, 5, bancoTokio, null, null, ciudadesAViajarTokio );
		ArrayList<Ciudad> ciudadesAViajarHongKong = new ArrayList<Ciudad>();
		ciudadesAViajarHongKong.add(tokio);
		Ciudad hongKong = new Ciudad( "Hong Kong", 3, 3, bancoHongKong, puertoHongKong, null, ciudadesAViajarHongKong );
		ArrayList<Ciudad> ciudadesAViajarBsAs = new ArrayList<Ciudad>();
		ciudadesAViajarBsAs.add(hongKong);
		Ciudad buenosAires = new Ciudad( "Buenos Aires", 1, 1, bibliotecaBsAs, null, null, ciudadesAViajarBsAs);
				
		
		//Aca comienza lo que seria la prueba, lo demas se deberia cargar del XML
		JugadorNovato jugador = new JugadorNovato(buenosAires, computadora);
		
		Ciudad ciudadActual = jugador.obtenerCiudadActual();
		ArrayList<ILugar> lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(0)) == pistaFacilBibliotecaBsAs);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Hong Kong
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(0)) == pistaFacilBancoHongKong);
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(1)) == pistaFacilPuertoHongKong);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Tokio
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(0)) == pistaFacilBancoTokio);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Londres
		jugador.emitirOrdenDeArresto( null, "alpinismo", "rubio", "cicatriz", null );
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		
		Assert.assertTrue( ( (ILugar)lugaresCiudadActual.get(0) ).devolverPista(jugador) == ordenDeArrestoIncorrecta );
			
	}
	
	@Test
	public void jugadorDetectiveNoAtrapaAlLadronCasoGrupo1SeQuedaSinTiempo() throws ExcepcionNoHayMasTiempo{
		
		Pista pistaFacilMuseoVeracruz = new Pista( "Era alto y de contextura delgada");
		Pista pistaFacilAeropuertoVeracruz = new Pista( "Se movia en auto con bandera roja y blanca" );
		Pista pistaFacilBancoMilan = new Pista( "Nunca vi a esa persona" );
		Pista pistaFacilMuelleMilan = new Pista("Por aca pasa mucha gente");
		
		Lugar museoVeracruz = new Lugar( "museo", pistaFacilMuseoVeracruz, null, null);
		Lugar aeropuertoVeracruz = new Lugar( "aeropuerto", pistaFacilAeropuertoVeracruz, null, null);
		Lugar bancoMilan = new Lugar( "banco", pistaFacilBancoMilan, null, null);
		Lugar muelleMilan= new Lugar( "muelle", pistaFacilMuelleMilan, null, null);
		
		Ciudad newYork = new Ciudad( "NewYork", 125, 130, null, null, null, new ArrayList<Ciudad>() );
		ArrayList<Ciudad> ciudadesAViajarMilan = new ArrayList<Ciudad>();
		ciudadesAViajarMilan.add(newYork);
		Ciudad milan = new Ciudad( "Milan", 25, 55, muelleMilan, bancoMilan, null, ciudadesAViajarMilan );
		ArrayList<Ciudad> ciudadesAViajarVeracruz = new ArrayList<Ciudad>();
		ciudadesAViajarVeracruz.add(milan);
		Ciudad veracruz = new Ciudad( "Veracruz", 34, 34, museoVeracruz, aeropuertoVeracruz, null, ciudadesAViajarVeracruz );
				
		
		//Aca comienza lo que seria la prueba, lo demas se deberia cargar del XML
		JugadorNovato jugador = new JugadorNovato(veracruz, null);
		
		Ciudad ciudadActual = jugador.obtenerCiudadActual();
		ArrayList<ILugar> lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(0)) == pistaFacilMuseoVeracruz);
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(1)) == pistaFacilAeropuertoVeracruz);

		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Milan
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(0)) == pistaFacilMuelleMilan);
		Assert.assertTrue( ciudadActual.obtenerPista(jugador, lugaresCiudadActual.get(1)) ==  pistaFacilBancoMilan);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a newYork
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Integer tiempoRestante = jugador.obtenerTiempoRestante();
		
		Assert.assertTrue(tiempoRestante < 2); //Tiene menos de 2 horas par jugar, perdio. Retocar la prueba.
		
	}
}