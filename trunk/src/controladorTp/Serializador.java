package controladorTp;

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


public class Serializador {

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
					
		ciudades.add(new Ciudad("Buenos Aires",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Madrid",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Londres",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Atenas",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Sidney",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Moscu",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Paris",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Tokio",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("El Cairo",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Rio De Janeiro",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Roma",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Oslo",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Montreal",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Nueva York",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Singapur",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Bagdad",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Estambul",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Katmandu",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Dubai",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("San Marino",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Nueva Delhi",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Ciudad de Mexico",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Lima",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Kigali",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Reykjavik",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Budapest",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Bamako",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Bangkok",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Moroni",1,1,null,null,null,null));
	    ciudades.add(new Ciudad("Puerto Moresby",1,1,null,null,null,null));				
					
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
	
	/*
	@Test
	public void serializarLugaresDeCiudades() throws ParserConfigurationException, TransformerException, SAXException, IOException{

		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		ArrayList<Lugar> lugaresBsAs = new ArrayList<Lugar>();
		ArrayList<Lugar> lugaresMadrid = new ArrayList<Lugar>();
									
	
		lugaresBsAs.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion pintado de azul y blanco."),new Pista("Ha tomado un avion que llevaba un sol dorado."),new Pista("")));
		lugaresBsAs.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras espaniolas."),new Pista("Pregunto donde se encontraba el rio Parana."),new Pista("")));
		lugaresBsAs.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos."),new Pista("Ha invertido todo su dinero en soja."),new Pista("")));
		lugaresBsAs.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja."),new Pista(""),new Pista("")));
		lugaresBsAs.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico mas alto de America."),new Pista("Era beneficiario de una beca para estudiar el nivel de colesterol de los gauchos."),new Pista("Ha hecho preguntas sobre la epoca de las conquistas espaniolas.")));
                    
		Element elementoCiudades = doc.createElement("BuenosAires");
		for (int i = 0 ; i < lugaresBsAs.size() ; i++){
			elementoCiudades.appendChild(lugaresBsAs.get(i).serializar(doc));
		}
		elementos.add(elementoCiudades);
					
		lugaresMadrid.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
		lugaresMadrid.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba la bandera roja y amarilla."),new Pista("Dijo que queria asistir a la fiesta del tomate."),new Pista("")));
		lugaresMadrid.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por euros."),new Pista(""),new Pista("")));
		lugaresMadrid.add(new Lugar("Bolsa",new Pista("Dijo que queria invertir en Paella."),new Pista(""),new Pista("")));
		lugaresMadrid.add(new Lugar("Biblioteca",new Pista("Pidio un libro acerca de los toros."),new Pista(""),new Pista("")));
                     
    				
		lugaresLondres.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y azul."),new Pista("Se informo sobre los vuelos nocturnos hacia la isla de Wight."),new Pista("")));
		lugaresLondres.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y azul."),new Pista("Pensaba navegar en un barco velero por el Severn."),new Pista("")));
		lugaresLondres.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a libras esterlinas."),new Pista(""),new Pista("")));
		lugaresLondres.add(new Lugar("Bolsa",new Pista("Dijo que tenia la intencion de invertir en Whisky."),new Pista(""),new Pista("")));
		lugaresLondres.add(new Lugar("Biblioteca",new Pista("Dijo que queria saber si el Big Ben hacia tic."),new Pista("Buscaba sellos para aniadirlos a su coleccion."),new Pista("")));
                   
		lugaresAtenas.add(new Lugar("Aeropuerto",new Pista("Pidio el asiento de al lado de la ventana para poder ver los montes del Pindo."),new Pista(""),new Pista("")));
		lugaresAtenas.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y blanca."),new Pista(""),new Pista("")));
		lugaresAtenas.add(new Lugar("Banco",new Pista("Llevaba un diccionario de griego en el bolsillo."),new Pista("Menciono que se estaba preparando para jugar al golf con el primer ministro."),new Pista("")));
		lugaresAtenas.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a euros."),new Pista(""),new Pista("")));
		lugaresAtenas.add(new Lugar("Biblioteca",new Pista("No dejaba de hacer preguntas sobre la antigua Esparta."),new Pista(""),new Pista("")));
      
		lugaresSidney.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista("Dijo que queria visitar el Opera House."),new Pista("")));
		lugaresSidney.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("Se fue en un barco que llevaba una bandera que contiene otra bandera por dentro.")));
		lugaresSidney.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista("Queria invertir en la cria de ovejas."),new Pista("")));
		lugaresSidney.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
		lugaresSidney.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Pensaba hacer un censo de las diversas especies de canguros."),new Pista("Solicito una biografia del capitan Cook.")));
 
		lugaresMoscu.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
		lugaresMoscu.add(new Lugar("Puerto",new Pista("Se ha informado sobre las condiciones de la navegacion en el lago Baikal."),new Pista(""),new Pista("")));
		lugaresMoscu.add(new Lugar("Banco",new Pista("Queria comprar una reliquia que hubiera pertenecido a un zar."),new Pista(""),new Pista("")));
		lugaresMoscu.add(new Lugar("Bolsa",new Pista("Cambio su dinero a rublos."),new Pista(""),new Pista("")));
		lugaresMoscu.add(new Lugar("Biblioteca",new Pista("Ha pedido un libro de recetas eslavas."),new Pista(""),new Pista("")));
         
		lugaresParis.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
		lugaresParis.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
		lugaresParis.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el euro."),new Pista(""),new Pista("")));
		lugaresParis.add(new Lugar("Bolsa",new Pista("Intentaba comprender si habia alguna relacion entre la Bolsa y la moda."),new Pista(""),new Pista("")));
		lugaresParis.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre la construccion de la torre Eiffel."),new Pista("Estaba haciendo estudio sobre la cultura franca."),new Pista("")));
 
		lugaresTokio.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Se fue en un avion blanco que contiene un circulo rojo."),new Pista("")));
		lugaresTokio.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Fuji."),new Pista("Pensaba partir con la mochila al hombro para explorar un archipielago."),new Pista("")));
		lugaresTokio.add(new Lugar("Banco",new Pista("Cambio su dinero a yens."),new Pista(""),new Pista("")));
		lugaresTokio.add(new Lugar("Bolsa",new Pista("Dijo que queria visitar un pais en el que el precio del arroz fuera alto."),new Pista("Comento que habia invertido mucho en electronica."),new Pista("Dijo que estaba interesado en la industria automotriz.")));
		lugaresTokio.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre los samurais."),new Pista("Deseaba visitar los lugares santos sintoistas."),new Pista("Comento que tenia ganas de leer una novela sobre los shoguns.")));

		lugaresElCairo.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
		lugaresElCairo.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
		lugaresElCairo.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero en libras."),new Pista(""),new Pista("")));
		lugaresElCairo.add(new Lugar("Bolsa",new Pista("Dijo que iba a adquirir el monopolio del mercado del algodon."),new Pista(""),new Pista("")));
		lugaresElCairo.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la piramide de Keops."),new Pista("Estudiaba la historia antigua de Alejandria."),new Pista("")));

		lugaresRioDeJaneiro.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, azul y amarilla."),new Pista(""),new Pista("")));
		lugaresRioDeJaneiro.add(new Lugar("Puerto",new Pista("Se preparaba para bajar por las cataratas del Iguazu."),new Pista(""),new Pista("")));
		lugaresRioDeJaneiro.add(new Lugar("Banco",new Pista("Cambio su dinero a cruzados."),new Pista(""),new Pista("")));
		lugaresRioDeJaneiro.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
		lugaresRioDeJaneiro.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
  
		lugaresRoma.add(new Lugar("Aeropuerto",new Pista("Dijo que queria visitar el Coliseo."),new Pista(""),new Pista("")));
		lugaresRoma.add(new Lugar("Puerto",new Pista("Se ha marchado en un bote hinchable que llevaba una bandera verde, blanca y roja."),new Pista("El queria aprender a hablar con las manos."),new Pista("Deseaba observar una erupcion volcanica.")));
		lugaresRoma.add(new Lugar("Banco",new Pista("Se ha ido en un vehiculo que llevaba una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
		lugaresRoma.add(new Lugar("Bolsa",new Pista("Cambio su dinero a liras."),new Pista("Dijo que iba a hacer un negocio en la industria textil."),new Pista("")));
		lugaresRoma.add(new Lugar("Biblioteca",new Pista("Dijo que debia ir a la opera con el presidente."),new Pista("Dijo que queria visitar el Parlamento."),new Pista("Estaba interesado en la industria textil.")));                         
 
		lugaresOslo.add(new Lugar("Aeropuerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y azul."),new Pista("Estaba buscando un guia que le enseniara los fiordos."),new Pista("")));
		lugaresOslo.add(new Lugar("Puerto",new Pista("Se marcho en un fuera borda que llevaba una bandera con una cruz azul."),new Pista("Dijo que queria navegar en kayak por los fiordos."),new Pista("")));
		lugaresOslo.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por coronas."),new Pista(""),new Pista("")));
		lugaresOslo.add(new Lugar("Bolsa",new Pista("Dijo que se iba de pesca con el rey."),new Pista("Tenia la intencion de invertir en la electrometalurgia."),new Pista("Comento que iba a adquirir el monopolio del mercado del aluminio.")));
		lugaresOslo.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la region escandinava."),new Pista("Comento que tenia ganas de estudiar la construccion de las naves vikingas."),new Pista("Estaba estudiando la influencia de Ibsen en Ingmar Bergman.")));

		lugaresMontreal.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera con una hoja de arce."),new Pista(""),new Pista("Dijo que proponia visiar la isla de Baffin.")));
		lugaresMontreal.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y blanca."),new Pista("Queria pasar una noche en la isla de Prince Edward."),new Pista("")));
		lugaresMontreal.add(new Lugar("Banco",new Pista("Llevaba un diccionario frances."),new Pista(""),new Pista("")));
		lugaresMontreal.add(new Lugar("Bolsa",new Pista("Cambio su dinero a dolares."),new Pista(""),new Pista("")));
		lugaresMontreal.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre Yukon."),new Pista("Queria enumerar las especies de pajaros existentes en los territorios del norte."),new Pista("Dijo que estaba escribiendo un libro sobre los enfrentamientos coloniales franco-ingleses.")));
    
		lugaresNuevaYork.add(new Lugar("Aeropuerto",new Pista("Dijo que deseaba subir a la cima del Empire State."),new Pista(""),new Pista("")));
		lugaresNuevaYork.add(new Lugar("Puerto",new Pista("Se fue en un crucero que llevaba una bandera roja, blanca y azul con estrellas."),new Pista(""),new Pista("")));
		lugaresNuevaYork.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
		lugaresNuevaYork.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por dolares."),new Pista(""),new Pista("")));
		lugaresNuevaYork.add(new Lugar("Biblioteca",new Pista("Pidio un libro sobre la estatua de la libertad."),new Pista("Pidio un mapa de Manhattan."),new Pista("")));
 
		lugaresSingapur.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Fue a visitar una isla del sudeste asiatico."),new Pista("")));
		lugaresSingapur.add(new Lugar("Puerto",new Pista("Dijo que queria visitar un bosque tropical."),new Pista("Dijo que queria tirarse de cabeza en el puerto Calder."),new Pista("")));
		lugaresSingapur.add(new Lugar("Banco",new Pista("Dijo que queria comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
		lugaresSingapur.add(new Lugar("Bolsa",new Pista("Dijo que queria jugar al polo con el presidente."),new Pista(""),new Pista("")));
		lugaresSingapur.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Dijo que tenia ganas de degustar un Gin Tonic en el hotel Raffles."),new Pista("")));
    
		lugaresBagdad.add(new Lugar("Aeropuerto",new Pista("Se ha marchado en un avion que ondeaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
		lugaresBagdad.add(new Lugar("Puerto",new Pista("Me ha pedido una tabla de las mareas del Golfo Persico."),new Pista("Dijo que queria bajar por el Tigris en canoa."),new Pista("Se ha informado sobre la posibilidad de hacer vela en el Eufrates.")));
		lugaresBagdad.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el dinar."),new Pista(""),new Pista("")));
		lugaresBagdad.add(new Lugar("Bolsa",new Pista("Se fue rapidamente en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
		lugaresBagdad.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario de arabe en su mochila."),new Pista("No ha ocultado su decepcion al no encontrar libros sobre los asirios."),new Pista("Dijo que tenia secretos susceptibles de interesar al consejo dirigente de la revolucion.")));
   
		lugaresEstambul.add(new Lugar("Aeropuerto",new Pista("Tomo un avion adornado con una bandera con una luna y una estrella."),new Pista("Se fue a un pais que se encuentra ubicado en dos contienentes."),new Pista("")));
		lugaresEstambul.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera adornada con una luna y una estrella."),new Pista("Dijo que contaba con pasar la noche en el palacio de un sultan."),new Pista("")));
		lugaresEstambul.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
		lugaresEstambul.add(new Lugar("Bolsa",new Pista("Cambio su dinero por liras."),new Pista(""),new Pista("")));
		lugaresEstambul.add(new Lugar("Biblioteca",new Pista("Hizo muchas preguntas sobre el imperio bizantino."),new Pista(""),new Pista("")));

		lugaresKatmandu.add(new Lugar("Aeropuerto",new Pista("Contaba pasar sus vacaciones en un reino asiatico."),new Pista(""),new Pista("")));
		lugaresKatmandu.add(new Lugar("Puerto",new Pista("Se ha ido en un vehiculo que llevaba una bandera adornada con un triangulo doble."),new Pista("Estaba pensando en visitar un pais montanioso."),new Pista("")));
		lugaresKatmandu.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
		lugaresKatmandu.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
		lugaresKatmandu.add(new Lugar("Biblioteca",new Pista("Buscaba un libro sobre la conquista del monte Everest."),new Pista("Pidio un mapa de Himalaya"),new Pista("Queria aprenderse las oraciones hinduistas.")));
   
		lugaresDubai.add(new Lugar("Aeropuerto",new Pista("Paneo viajar hacia el medio oriente."),new Pista("Pidio el asiento de al lado de la ventana para poder ver el Burj Khalifa."),new Pista("")));
		lugaresDubai.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, verde, blanca y negra."),new Pista(""),new Pista("")));
		lugaresDubai.add(new Lugar("Banco",new Pista("Cambio su dinero a dirham."),new Pista(""),new Pista("")));
		lugaresDubai.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
		lugaresDubai.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer el medio oriente."),new Pista("Pregunto sobre la industria petrolera."),new Pista("")));
        
		lugaresSanMarino.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
		lugaresSanMarino.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Titano"),new Pista(""),new Pista("")));
		lugaresSanMarino.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
		lugaresSanMarino.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
		lugaresSanMarino.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario italiano."),new Pista(""),new Pista("")));
          
		lugaresNuevaDelhi.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja, blanca y verde."),new Pista(""),new Pista("")));
		lugaresNuevaDelhi.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
		lugaresNuevaDelhi.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
		lugaresNuevaDelhi.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
		lugaresNuevaDelhi.add(new Lugar("Biblioteca",new Pista("Deseaba ver el Nanda Devi."),new Pista("Estaba buscando un turbante sij."),new Pista("")));
                  
		lugaresCiudaddeMexico.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
		lugaresCiudaddeMexico.add(new Lugar("Puerto",new Pista("Estaba pensando en viajar a un pais que se hable espaniol."),new Pista(""),new Pista("")));
		lugaresCiudaddeMexico.add(new Lugar("Banco",new Pista("Dijo que iba a montar en caballo con el presidente."),new Pista(""),new Pista("")));
		lugaresCiudaddeMexico.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a pesos."),new Pista(""),new Pista("")));
		lugaresCiudaddeMexico.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre los Aztecas."),new Pista(""),new Pista("")));
          
		lugaresLima.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
		lugaresLima.add(new Lugar("Puerto",new Pista("Estaba pensando en visitar America."),new Pista(""),new Pista("")));
		lugaresLima.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaban el sol."),new Pista(""),new Pista("")));
		lugaresLima.add(new Lugar("Bolsa",new Pista("Tenia la intencion de comprar una mina de cobre."),new Pista("Dijo que tenia la intencion de invertir en el mercado del cinc."),new Pista("")));
		lugaresLima.add(new Lugar("Biblioteca",new Pista("Retiro una biografia de Francisco Pizarro."),new Pista("Solicito un libro sobre la geologia de los Andes."),new Pista("")));
   
		lugaresKigali.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera azul, amarilla y verde."),new Pista(""),new Pista("")));
		lugaresKigali.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul, amarilla y verde."),new Pista(""),new Pista("")));
		lugaresKigali.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el franco CFA."),new Pista(""),new Pista("")));
		lugaresKigali.add(new Lugar("Bolsa",new Pista("Compro francos CFA en el mercado negro."),new Pista("Llevaba un diccionario en frances."),new Pista("")));
		lugaresKigali.add(new Lugar("Biblioteca",new Pista("Retiro libros sobre los gorilas de las montanias."),new Pista("Dijo que queria averiguar sobre volcanes."),new Pista("Dijo que queria averiguar sobre los mambos negros.")));
           
		lugaresReykjavik.add(new Lugar("Aeropuerto",new Pista("Dijo que iba a veranear en una isla del atlantico norte."),new Pista(""),new Pista("")));
		lugaresReykjavik.add(new Lugar("Puerto",new Pista("Se fue en un barco que llevaba una bandera roja y azul."),new Pista(""),new Pista("")));
		lugaresReykjavik.add(new Lugar("Banco",new Pista("Pregunto sobre el precio de la corona."),new Pista(""),new Pista("")));
		lugaresReykjavik.add(new Lugar("Bolsa",new Pista("Cambio su dinero a coronas."),new Pista(""),new Pista("")));
		lugaresReykjavik.add(new Lugar("Biblioteca",new Pista("Me dijo que iba a tomar un cafe con el presidente."),new Pista(""),new Pista("")));
             
		lugaresBudapest.add(new Lugar("Aeropuerto",new Pista("Contaba con visitar un pais de Europa central."),new Pista(""),new Pista("")));
		lugaresBudapest.add(new Lugar("Puerto",new Pista("Tomo un barco que llevaba una bandera roja, blanca y verde."),new Pista("Se translado a un pais vecino de Austria."),new Pista("Comento que le gustaria bajar por el Danubio en un barco velero.")));
		lugaresBudapest.add(new Lugar("Banco",new Pista("Ha cambiado su dinero a forints."),new Pista(""),new Pista("")));
		lugaresBudapest.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
		lugaresBudapest.add(new Lugar("Biblioteca",new Pista("Solicito un libro sobre Budapest."),new Pista("Estaba buscando antiguos manuscritos magiares."),new Pista("")));
               
		lugaresBamako.add(new Lugar("Aeropuerto",new Pista("Dijo que se iba a tomar unas vacaciones en el contiente africano."),new Pista(""),new Pista("")));
		lugaresBamako.add(new Lugar("Puerto",new Pista("Se marcho en un barco que lucia una bandera verde, amarilla y roja."),new Pista(""),new Pista("")));
		lugaresBamako.add(new Lugar("Banco",new Pista("Dijo que iba a jugar al bridge con el presidente."),new Pista(""),new Pista("")));
		lugaresBamako.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por francos CFA."),new Pista(""),new Pista("")));
		lugaresBamako.add(new Lugar("Biblioteca",new Pista("Se intereso por el estudio de las relaciones familiares de los tuaregs."),new Pista("Pensaba visitar una excavacion arqueologica al antiguo Tombuctu."),new Pista("")));
              
		lugaresBangkok.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que tenia adornada el ala con una bandera roja, blanca y azul."),new Pista(""),new Pista("")));
		lugaresBangkok.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
		lugaresBangkok.add(new Lugar("Banco",new Pista("Deseaba comprar bahts en el mercado negro. Ha hablado de la belleza de las montanias."),new Pista(""),new Pista("")));
		lugaresBangkok.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaban los bahts."),new Pista(""),new Pista("")));
		lugaresBangkok.add(new Lugar("Biblioteca",new Pista("Contaba realizar una visita con un guia por los wats siameses."),new Pista(""),new Pista("")));
            
		lugaresMoroni.add(new Lugar("Aeropuerto",new Pista("Estaba pensando en visitar unas islas en el sur."),new Pista(""),new Pista("")));
		lugaresMoroni.add(new Lugar("Puerto",new Pista("Se ha ido en un catamaran que lucia una bandera verde y blanca."),new Pista(""),new Pista("")));
		lugaresMoroni.add(new Lugar("Banco",new Pista("Dijo que iba a comprar todo lo necesario para hacer perfumes."),new Pista(""),new Pista("")));
		lugaresMoroni.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el franco comorense."),new Pista(""),new Pista("")));
		lugaresMoroni.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionaro arabe en la maleta."),new Pista("Pidio informacion sobre los volcanes. Ha hablado de la belleza de las montanias."),new Pista("")));
             
		lugaresPuertoMoresby.add(new Lugar("Aeropuerto",new Pista("Dijo que pensaba visitar Nueva-Irlanda."),new Pista(""),new Pista("")));
		lugaresPuertoMoresby.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y negra."),new Pista(""),new Pista("")));
		lugaresPuertoMoresby.add(new Lugar("Banco",new Pista("Cambio su dinero a kinas."),new Pista(""),new Pista("")));
		lugaresPuertoMoresby.add(new Lugar("Bolsa",new Pista("Dijo que iba a una barbacoa con el primer ministro."),new Pista(""),new Pista("")));
		lugaresPuertoMoresby.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                              
                      
		//Asigno el elemento XML de la instancia al documento generado anteriormente
	       
		//assertNotNull(elementoLadrones);
					
		//Guardo el XML en el disco
					
		//doc.appendChild(elementoCiudades);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("LugaresDeCiudades.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
							
		//assertTrue(archivo.exists()); 
	}
	*/
}