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

import org.junit.Test;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class LugarTest {

	@Test 
	public void elLugarDeberiaDevolverElNombreIngresado(){
		
		Lugar bolsa = new Lugar("bolsa", null, null, null, null);
		
		Assert.assertTrue( bolsa.obtenerNombre() == "bolsa" );
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaFacilSiElPersonajeEsNovato(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorNovato jugador = new JugadorNovato(BuenosAires, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil, null);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaFacil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorDetective jugador = new JugadorDetective(BuenosAires, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil, null);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaDificilSiElPersonajeEsSargento(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorSargento jugador = new JugadorSargento(BuenosAires, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil, null);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaDificil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMediaSiElPersonajeEsInvestigador(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorInvestigador jugador = new JugadorInvestigador(BuenosAires, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil, null);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}
	
	@Test
	public void unLugarDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Pista pistaFacil = new Pista("Una pista facil de Biblioteca");
		Pista pistaMedia = new Pista("Una pista media de Biblioteca");
		Pista pistaDificil = new Pista("Una pista dificil de Biblioteca");
		
		Lugar unLugar = new Lugar("Biblioteca",pistaFacil,pistaMedia,pistaDificil,null);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node lugarSerializado = unLugar.serializar(doc);
		
		assertNotNull(lugarSerializado);
		
		//Guardo el XML en el disco
		doc.appendChild(lugarSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("lugarTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
		
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de pista en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
			
		Lugar otroLugar = Lugar.cargarEstado(doc);
		
		assertNotNull(otroLugar);
		assertEquals(unLugar.obtenerNombre(), otroLugar.obtenerNombre());
		
		assertEquals(unLugar.devolverPista(new JugadorNovato(null,null)).obtenerContenido(), otroLugar.devolverPista(new JugadorNovato(null,null)).obtenerContenido());
		assertEquals(unLugar.devolverPista(new JugadorDetective(null,null)).obtenerContenido(), otroLugar.devolverPista(new JugadorDetective(null,null)).obtenerContenido());
		assertEquals(unLugar.devolverPista(new JugadorInvestigador(null,null)).obtenerContenido(), otroLugar.devolverPista(new JugadorInvestigador(null,null)).obtenerContenido());
		assertEquals(unLugar.devolverPista(new JugadorSargento(null,null)).obtenerContenido(), otroLugar.devolverPista(new JugadorSargento(null,null)).obtenerContenido());
		
		archivo.delete();
	}

}
