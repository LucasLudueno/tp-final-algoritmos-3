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

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class SerializadorTest {
	
	@Test
	public void serializadorDeberiaGuardarYRecuperarLaListaDeLadronesATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Ladron ladron1 = new Ladron( "John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "moto"); 
		Ladron ladron2 = new Ladron( "Gracie Kai", "femenino", "paracaidismo", "rojo", "anillo","descapotable");
		Ladron ladron3 = new Ladron( "Jack Norris", "masculino", "tenis", "negro", "tatuaje", "limusina");
		
		ArrayList<Ladron> lista = new ArrayList<Ladron>();
		lista.add(ladron1);
		lista.add(ladron2);
		lista.add(ladron3);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Element elementoLadrones = doc.createElement("Ladrones");
		for (int i = 0 ; i < lista.size() ; i++){
			elementoLadrones.appendChild(lista.get(i).serializar(doc));
		}
		
		
		assertNotNull(elementoLadrones);
		
		//Guardo el XML en el disco
		doc.appendChild(elementoLadrones);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("ListaDeLadrones.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
							
		assertTrue(archivo.exists());
		
		//Recupero el estado de la lista en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
		
		int i = 0;
		while (elementoLadrones.getChildNodes().item(i) != null){
			Ladron ladron = Ladron.cargarEstado((Element) elementoLadrones.getChildNodes().item(i));
			ladrones.add( ladron );
			i = i + 1;
		}
		
		assertEquals(ladrones.size(),3);
		assertEquals(ladrones.get(0).obtenerNombre(),"John Wayne");
		assertEquals(ladrones.get(1).obtenerNombre(),"Gracie Kai");
		assertEquals(ladrones.get(2).obtenerNombre(),"Jack Norris");
		
		archivo.delete();
	}
	
	//@Test
	public void ejemploSerializarLugaresDeCiudadesDebeDevolverUnaListaDeLugaresConPistas() throws ParserConfigurationException, SAXException, IOException{
		
		File archivo = new File("Buenos Aires.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Element elementoCiudades = (Element)doc.getElementsByTagName("Lugares").item(0);						
		
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		
		int i = 0;
		while (elementoCiudades.getChildNodes().item(i) != null){
			Lugar lugar = Lugar.cargarEstado((Element) elementoCiudades.getChildNodes().item(i));
			lugares.add( lugar );
			i = i + 1;
		}
		
		JugadorNovato jugador = new JugadorNovato(null, null);
		for(int j=0; j < lugares.size(); j++){
			Assert.assertTrue(lugares.get(j).devolverPista(jugador) != null );
		}
	}

}
