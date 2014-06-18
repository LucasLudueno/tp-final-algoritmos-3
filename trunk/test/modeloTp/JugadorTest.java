package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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
	
	@Test
	public void unJugadorDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Lugar biblioteca = new Lugar("Biblioteca",new Pista("BiblioFacil"),new Pista("BiblioMedia"),new Pista("BiblioDificil"),null);
		Lugar aeropuerto = new Lugar("Aeropuerto",new Pista("AeroFacil"),new Pista("AeroMedia"),new Pista("AeroDificil"),null);
		Lugar banco = new Lugar("Banco",new Pista("BancFacil"),new Pista("BancMedia"),new Pista("BancDificil"),null);
		
		Ciudad unaCiudad = new Ciudad("Buenos Aires",1,1,biblioteca,aeropuerto,banco,null);
		
		Ladron ladronUno = new Ladron("John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "ninguno");
		Ladron ladronDos = new Ladron("Gracie Kai", "femenino", "paracaidismo", "rojo", "anillo", "ninguno");
		Ladron ladronTres = new Ladron("Jack Norris", "masculino", "ninguno", "negro", "tatuaje", "Limusina");
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(ladronUno);
		sospechosos.add(ladronDos);
		sospechosos.add(ladronTres);
		
		ComputadoraPolicial unaComputadora = new ComputadoraPolicial(sospechosos);
		
		Jugador unJugador = new Jugador(unaCiudad,unaComputadora);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node jugadorSerializado = unJugador.serializar(doc);
		
		assertNotNull(jugadorSerializado);
		
		//Guardo el XML en el disco
		doc.appendChild(jugadorSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("jugadorTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
						
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de jugador en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
							
		Jugador otroJugador = Jugador.cargarEstado(doc);
		
		assertNotNull(otroJugador);
		assertEquals(unJugador.velocidad, otroJugador.velocidad);
		assertNotNull(otroJugador.obtenerCiudadActual());
		assertEquals(unJugador.obtenerCiudadActual().obtenerNombre(), otroJugador.obtenerCiudadActual().obtenerNombre());
		
		//archivo.delete();
	}
	
}