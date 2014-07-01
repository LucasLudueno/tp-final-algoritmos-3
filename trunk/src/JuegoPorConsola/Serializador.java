package JuegoPorConsola;

//import org.junit.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import modeloTp.Ciudad;
import modeloTp.Ladron;
import modeloTp.Lugar;
import modeloTp.Pista;


public class Serializador {

	//@Test
	public void serializadorDeListaDeLadrones() throws ParserConfigurationException, TransformerException, SAXException, IOException{

	
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

			
		Ladron ladron1 = new Ladron( "John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "moto"); 
		Ladron ladron2 = new Ladron( "Gracie Kai", "femenino", "paracaidismo", "rojo", "anillo","descapotable");
		Ladron ladron3 = new Ladron( "Jack Norris", "masculino", "tenis", "negro", "tatuaje", "limusina"); 
		Ladron ladron4 = new Ladron( "Nick Brunch", "masculino", "tenis", "negro", "anillo","moto"); 
		Ladron ladron5 = new Ladron( "Len Bulk", "masculino","alpinismo", "rojo", "tatuaje","descapotable"); 
		Ladron ladron6 = new Ladron( "Ihor Ihorovitch", "masculino", "croquet", "castanio", "tatuaje", "descapotable"); 
		Ladron ladron7 = new Ladron( "Fast Eddie B.", "masculino", "croquet", "negro", "joyas", "descapotable"); 
		Ladron ladron8 = new Ladron( "Scar Graynolt", "masculino", "croquet","rojo", "anillo", "limusina");
		Ladron ladron9 = new Ladron( "Merey Laroc", "femenino", "alpinismo", "rubio", "joyas", "limusina"); 
		Ladron ladron10 = new Ladron( "Lady Agatha", "femenino", "tenis" , "rojo", "anillo", "descapotable");
		Ladron ladron11 = new Ladron( "Katherine Drib", "femenino", "alpinismo", "rubio", "tatuaje","moto"); 
		Ladron ladron12 = new Ladron( "Dazzle Annie", "femenino", "tenis", "castanio", "tatuaje", "deportivo");
		Ladron ladron13 = new Ladron( "Carmen SanDiego", "femenino", "tenis", "rubio", "joyas", "descapotable"); 
		Ladron ladron14 = new Ladron( "Charles Fontella", "masculino", "musica", "negro", "cicatriz","moto"); 
		Ladron ladron15 = new Ladron( "Mike August", "masculino","paracaidismo", "rubio", "anillo", "deportivo");
			
		ArrayList<Ladron> lista = new ArrayList<Ladron>();
			
		lista.add(ladron1);
		lista.add(ladron2);
		lista.add(ladron3);
		lista.add(ladron4);
		lista.add(ladron5);
		lista.add(ladron6);
		lista.add(ladron7);
		lista.add(ladron8);
		lista.add(ladron9);
		lista.add(ladron10);
		lista.add(ladron11);
		lista.add(ladron12);
		lista.add(ladron13);
		lista.add(ladron14);
		lista.add(ladron15);
			
			
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Element elementoLadrones = doc.createElement("Ladrones");
		for (int i = 0 ; i < lista.size() ; i++){
			elementoLadrones.appendChild(lista.get(i).serializar(doc));
		}
			
		//Guardo el XML en el disco
		doc.appendChild(elementoLadrones);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("ListaDeLadrones.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
						
	}
	
	//@Test
	public void serializarListaDeCiudades() throws ParserConfigurationException, TransformerException, SAXException, IOException{

		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		ciudades.add(new Ciudad("Buenos Aires",3400, 3900));
		ciudades.add(new Ciudad("Madrid",5000, 300));
	    ciudades.add(new Ciudad("Londres",6100, 300));
	    ciudades.add(new Ciudad("Atenas",450, 2400));
	    ciudades.add(new Ciudad("Sidney", 3300, 161 ));
	    ciudades.add(new Ciudad("Moscu", 5500, 650));
	    ciudades.add(new Ciudad("Paris", 5800, 200));
	    ciudades.add(new Ciudad("Tokio", 350, 1490));
	    ciudades.add(new Ciudad("El Cairo",290 ,4100));
	    ciudades.add(new Ciudad("Rio De Janeiro",2100, 510));
	    ciudades.add(new Ciudad("Roma",510, 1200));
	    ciudades.add(new Ciudad("Oslo",690, 1000));
	    ciudades.add(new Ciudad("Montreal", 450, 8300));
	    ciudades.add(new Ciudad("Nueva York",4200, 830));
	    ciudades.add(new Ciudad("Singapur",132, 1030));
	    ciudades.add(new Ciudad("Bagdad", 3300, 4400));
	    ciudades.add(new Ciudad("Estambul", 5100, 4000));
	    ciudades.add(new Ciudad("Katmandu", 2700, 115));
	    ciudades.add(new Ciudad("Dubai",1700, 530));
	    ciudades.add(new Ciudad("San Marino", 530, 1200));
	    ciudades.add(new Ciudad("Nueva Delhi",2800, 870));
	    ciudades.add(new Ciudad("Ciudad de Mexico",2100, 113));
	    ciudades.add(new Ciudad("Lima",1200, 860));
	    ciudades.add(new Ciudad("Kigali",4200, 300));
	    ciudades.add(new Ciudad("Reykjavik", 704, 2100));
	    ciudades.add(new Ciudad("Budapest",579,1900));
	    ciudades.add(new Ciudad("Bamako",2200, 700));
	    ciudades.add(new Ciudad("Bangkok",1300,110));
	    ciudades.add(new Ciudad("Moroni",1100, 530));
	    ciudades.add(new Ciudad("Puerto Moresby",900,167));				
					
	    //Asigno el elemento XML de la instancia al documento generado anteriormente
	                
	    Element elementoCiudades = doc.createElement("Ciudades");
	    for (int i = 0 ; i < ciudades.size() ; i++){
	    	elementoCiudades.appendChild(ciudades.get(i).serializar(doc));
	    }
					
	    //assertNotNull(elementoLadrones);
					
	    //Guardo el XML en el disco
	    doc.appendChild(elementoCiudades);
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    File archivo = new File("ListaDeCiudades.xml");
	    StreamResult streamResult = new StreamResult(archivo);
	    transformer.transform(source, streamResult);
							
	    //assertTrue(archivo.exists()); 
	}
	
	
	//@Test
	public void ejemploSerializarLugaresDeCiudades() throws ParserConfigurationException, TransformerException, SAXException, IOException{

		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
									
		lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que pensaba visitar Nueva-Irlanda."),new Pista(""),new Pista("")));
		lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y negra."),new Pista(""),new Pista("")));
		lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a kinas."),new Pista(""),new Pista("")));
		lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a una barbacoa con el primer ministro."),new Pista(""),new Pista("")));
		lugares.add(new Lugar("Biblioteca",new Pista("Hizo preguntas sobre la colonizacion europea."),new Pista(""),new Pista("")));
	
		Element elementoLugares = doc.createElement("Lugares");
		for (int i = 0 ; i < lugares.size() ; i++){
			elementoLugares.appendChild(lugares.get(i).serializar(doc));
		}
				
		//Guardo el XML en el disco
		doc.appendChild(elementoLugares);
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    File archivo = new File("Puerto Moresby.xml");
	    StreamResult streamResult = new StreamResult(archivo);
	    transformer.transform(source, streamResult);
							

	}
	
}