package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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

import modeloTp.Ciudad;

public class CiudadTest {
	
	@Test
	public void deberiaCrearseLaCiudadConBuenosAiresComoNombreYPosicionYLugaresIngresados(){
	
		Ciudad ciudad = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>() );
		
		Assert.assertTrue(ciudad.obtenerNombre() == "Buenos Aires");
		Assert.assertTrue(ciudad.obtenerPosicion_x() == 1);
		Assert.assertTrue(ciudad.obtenerPosicion_y() == 1);
		Assert.assertTrue(ciudad.cantidadLugares() == 3);
		
	}
	
	@Test
	public void obtenerDistanciaDeberiaDevolverLaDistanciaEntreLasCiudades(){
		
		Ciudad ciudad1 = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		Ciudad ciudad2 = new Ciudad("Londres",4,5,null,null,null, new ArrayList<Ciudad>());
		
		Assert.assertEquals(5, ciudad1.obtenerDistancia(ciudad2));
	}
	
	@Test
	public void obtenerLugaresDeberiaDevolverLosLugaresIngresados(){
		Lugar aeropuerto = new Lugar("Aeropuerto",null, null, null, null);
		Lugar bolsa = new Lugar("Bolsa",null, null, null, null);
		Lugar biblioteca = new Lugar("Biblioteca",null, null, null, null);
		Ciudad buenosAires = new Ciudad("Buenos Aires", 1, 1, aeropuerto, bolsa, biblioteca, new ArrayList<Ciudad>());
		
		ArrayList<Lugar> lugaresCiudad = buenosAires.obtenerLugares();
		
		Assert.assertTrue( lugaresCiudad.contains(aeropuerto) );
		Assert.assertTrue( lugaresCiudad.contains(bolsa) );
		Assert.assertTrue( lugaresCiudad.contains(biblioteca) );
		
	}
	
	@Test 
	public void obtenerCiudadesAViajarDeberiaDevolverLasCiudadesIngresadas(){
		Ciudad tokio = new Ciudad("Tokio", 12, 1, null, null, null, new ArrayList<Ciudad>());
		Ciudad mexico = new Ciudad("Mexico", 13, 1, null, null, null, new ArrayList<Ciudad>());
		ArrayList<Ciudad> ciudadesAViajarDesdeBsAs = new ArrayList<Ciudad>();
		ciudadesAViajarDesdeBsAs.add(tokio);
		ciudadesAViajarDesdeBsAs.add(mexico);
		
		Ciudad buenosAires = new Ciudad("Buenos Aires", 1, 1, null, null, null, ciudadesAViajarDesdeBsAs);

		Assert.assertTrue( buenosAires.obtenerCiudadesAViajar() == ciudadesAViajarDesdeBsAs );
		
	}
	
	@Test
	public void unaCiudadDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Lugar biblioteca = new Lugar("Biblioteca",new Pista("BiblioFacil"),new Pista("BiblioMedia"),new Pista("BiblioDificil"),null);
		Lugar aeropuerto = new Lugar("Aeropuerto",new Pista("AeroFacil"),new Pista("AeroMedia"),new Pista("AeroDificil"),null);
		Lugar banco = new Lugar("Banco",new Pista("BancFacil"),new Pista("BancMedia"),new Pista("BancDificil"),null);
		
		Ciudad unaCiudad = new Ciudad("Buenos Aires",1,1,biblioteca,aeropuerto,banco,null);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node ciudadSerializada = unaCiudad.serializar(doc);
		
		assertNotNull(ciudadSerializada);
		
		//Guardo el XML en el disco
		doc.appendChild(ciudadSerializada);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("ciudadTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
				
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de ciudad en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
					
		Ciudad otraCiudad = Ciudad.cargarEstado(doc);
		
		assertNotNull(otraCiudad);
		assertEquals(unaCiudad.obtenerNombre(), otraCiudad.obtenerNombre());
		assertEquals(unaCiudad.obtenerPosicion_x(), otraCiudad.obtenerPosicion_x());
		assertEquals(unaCiudad.obtenerPosicion_y(), otraCiudad.obtenerPosicion_y());
		assertEquals(unaCiudad.cantidadLugares(), otraCiudad.cantidadLugares());
		
		archivo.delete();
	}
	
}