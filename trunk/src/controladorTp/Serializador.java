package controladorTp;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;
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

//import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
//import modeloTp.Ciudad;
import modeloTp.Ladron;


public class Serializador {

	@Test
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
			
	}
	
}