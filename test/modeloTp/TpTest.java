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
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
		jugador.viajar(BuenosAires);
		
		Assert.assertEquals(154,jugador.obtenerTiempoRestante());
	}

	@Test
	public void deberiaBajarElTiempoDelJugadorSiViajaAOtraCiudad() throws ExcepcionNoHayMasTiempo{
	
		Ciudad BuenosAires = new Ciudad("Buenos Aires",340,990);
		Ciudad Paris = new Ciudad("Paris",330, 1910 );
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
		int tiempoInicial = jugador.obtenerTiempoRestante();
		jugador.viajar(Paris);
		
		Assert.assertTrue(tiempoInicial > jugador.obtenerTiempoRestante());
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
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad londres = new Ciudad("Londres",6,11);
		JugadorNovato jugador = new JugadorNovato(buenosAires, null);
		
		buenosAires.agregarLugar(aeropuertoBuenosAires);
		londres.agregarLugar(aeropuertoLondres);
		
		Assert.assertTrue( (jugador.obtenerCiudadActual()).obtenerLugares().get(0).devolverPista(jugador) == pistaFacilAeropuertoBsAs );
		
		jugador.viajar(londres);
		
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerLugares().get(0).devolverPista(jugador) == pistaFacilAeropuertoLondres );
		
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
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1);
		buenosAires.agregarLugar(aeropuertoBsAs);
		buenosAires.agregarLugar(bolsaBsAs);
		JugadorNovato jugador = new JugadorNovato(buenosAires, null);
		
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerLugares().get(0).devolverPista(jugador) == pistaFacilAeropuertoBsAs);
		Assert.assertTrue((jugador.obtenerCiudadActual()).obtenerLugares().get(1).devolverPista(jugador) == pistaFacilBolsaBsAs );
		
		Assert.assertFalse((jugador.obtenerCiudadActual()).obtenerLugares().get(0).devolverPista(jugador) == jugador.obtenerCiudadActual().obtenerLugares().get(1).devolverPista(jugador) );
	
	}
	
	@Test
	public void obtenerPistaDeberiaBajarElTiempoDelJugadorIncrementandoseDeA1HoraCadaVezQueVuelveAEntrar(){
		Pista pistaFacilAeropuertoBsAs = new Pista("pistaFacilBsAsAerop");
		Pista pistaFacilBolsaBsAs = new Pista("pistaFacilBsAsBolsa");;
		Pista pistaFacilBibliotecaBsAs = new Pista("pistaFacilBsAsBolsa");
		
		Lugar aeropuertoBsAs = new Lugar("Aeropuerto", pistaFacilAeropuertoBsAs, null, null);
		Lugar bolsaBsAs = new Lugar("Bolsa",pistaFacilBolsaBsAs, null, null);
		Lugar bibliotecaBsAs = new Lugar("Biblioteca",pistaFacilBibliotecaBsAs, null, null);

		JugadorNovato jugador = new JugadorNovato(null, null);
		
		Integer tiempoActualJugador = jugador.obtenerTiempoRestante();
		aeropuertoBsAs.devolverPista(jugador); // El jugador entra a un lugar por primera vez
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoActualJugador - 1) );
		
		tiempoActualJugador = jugador.obtenerTiempoRestante();
		bolsaBsAs.devolverPista(jugador); // El jugador entra a un lugar por segunda vez
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoActualJugador - 2) );
		
		tiempoActualJugador = jugador.obtenerTiempoRestante();
		bibliotecaBsAs.devolverPista(jugador); // El jugador entra a un lugar por tercera vez
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
		Pista pistaFacilBancoTokio = new Pista("Pregunto por el tipo de cambio de la libra. Tenia pelo rubio");
		
		Lugar bibliotecaBsAs = new Lugar( "biblioteca", pistaFacilBibliotecaBsAs, null, null);
		Lugar bancoHongKong = new Lugar( "banco", pistaFacilBancoHongKong, null, null);
		Lugar bancoTokio = new Lugar( "banco", pistaFacilBancoTokio, null, null);
		
		Pista ordenDeArrestoIncorrecta = new Pista("Orden de arresto incorrecta");
		LugarConLadron bancoLondres = new LugarConLadron( null , ladron, null, ordenDeArrestoIncorrecta, null );
		
		Ciudad londres = new Ciudad( "Londes", 7, 7);
		londres.agregarLugar(bancoLondres);
		
		Ciudad tokio = new Ciudad( "Tokio", 5, 5 );
		tokio.agregarLugar(bancoTokio);
		tokio.agregarCiudadAViajar(londres);
		
		Ciudad hongKong = new Ciudad( "Hong Kong", 3, 3);
		hongKong.agregarLugar(bancoHongKong);
		hongKong.agregarCiudadAViajar(tokio);
		
		Ciudad buenosAires = new Ciudad( "Buenos Aires", 1, 1);
		buenosAires.agregarLugar(bibliotecaBsAs);
		buenosAires.agregarCiudadAViajar(hongKong);
				
		
		//Aca comienza lo que seria la prueba, lo demas se deberia cargar del XML
		JugadorNovato jugador = new JugadorNovato(buenosAires, computadora);
		
		Ciudad ciudadActual = jugador.obtenerCiudadActual();
		ArrayList<ILugar> lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( jugador.obtenerCiudadActual().obtenerLugares().get(0).devolverPista(jugador) == pistaFacilBibliotecaBsAs);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Hong Kong
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( jugador.obtenerCiudadActual().obtenerLugares().get(0).devolverPista(jugador) == pistaFacilBancoHongKong);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Tokio
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		Assert.assertTrue( jugador.obtenerCiudadActual().obtenerLugares().get(0).devolverPista(jugador) == pistaFacilBancoTokio);
		
		jugador.viajar( ( (ArrayList<Ciudad>)ciudadActual.obtenerCiudadesAViajar()).get(0) ); //Viajo a Londres
		jugador.emitirOrdenDeArresto( null, "alpinismo", "rubio", "cicatriz", null );
		ciudadActual = jugador.obtenerCiudadActual();
		lugaresCiudadActual = ciudadActual.obtenerLugares();
		
		Assert.assertTrue( ( (ILugar)lugaresCiudadActual.get(0) ).devolverPista(jugador) == ordenDeArrestoIncorrecta );
			
	}
	
	@Test
	public void jugadorDetectiveNoAtrapaAlLadronCasoGrupo1SeQuedaSinTiempo() throws ExcepcionNoHayMasTiempo{
		
		Pista pistaFacilMuseoVeracruz = new Pista( "Era alto y de contextura delgada");		
		Lugar museoVeracruz = new Lugar( "museo", pistaFacilMuseoVeracruz, null, null);
		Ciudad veracruz = new Ciudad( "Veracruz", 34, 34);
		veracruz.agregarLugar(museoVeracruz);	
		
		//Aca comienza lo que seria la prueba, lo demas se deberia cargar del XML
		JugadorNovato jugador = new JugadorNovato(veracruz, null);
		
		Ciudad ciudadActual = jugador.obtenerCiudadActual();
		ArrayList<ILugar> lugaresCiudadActual = ciudadActual.obtenerLugares();
		
		while( jugador.obtenerTiempoRestante() > 1){
			lugaresCiudadActual.get(0).devolverPista(jugador);
		}
		
		Assert.assertTrue(jugador.obtenerTiempoRestante() <= 1); //Tiene menos de 1 horas par jugar, Perdio, no puede jugar mas.
		
	}
}