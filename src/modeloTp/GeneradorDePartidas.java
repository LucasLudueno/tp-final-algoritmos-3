package modeloTp;
/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static org.junit.Assert.assertTrue;

import org.xml.sax.SAXException;


import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
*/

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
//import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;

import java.util.Random;
//import org.junit.Assert;
//import org.junit.Test;
import java.util.ArrayList;
import modeloTp.Ciudad;
import modeloTp.Ladron;

public class GeneradorDePartidas {
        
private ArrayList<Ciudad> ciudadesAuxiliares;
private ArrayList<Ciudad> recorridoDelLadron;     
        
        public GeneradorDePartidas(){
        	recorridoDelLadron = new ArrayList<Ciudad>();
        	ciudadesAuxiliares = new ArrayList<Ciudad>();
        }
        
        public void cargarDatos() throws ParserConfigurationException, SAXException, IOException{
                          
                //GENERO DEL XML UNA LISTA CON TODAS LAS CIUDADES QUE TENGO GUARDADAS
                
                File archivo = new File("ListaDeCiudades.xml");
    			
    			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    			Document doc = dBuilder.parse(archivo);
    			doc.getDocumentElement().normalize();
    			
    			Element elementoCiudades = (Element)doc.getElementsByTagName("Ciudades").item(0);						
    			    			
    			int i = 0;
    			while (elementoCiudades.getChildNodes().item(i) != null){
    				Ciudad unaCiudad = Ciudad.cargarEstado((Element) elementoCiudades.getChildNodes().item(i));
    				ciudadesAuxiliares.add( unaCiudad );
    				i = i + 1;
    			}
                
    			Random generadorRandom = new Random();
                
                // GENERO LA LISTA: RECORRIDO DEL LADRON
                for (int j=0; j < 6; j++){
                        int posicionRandom = generadorRandom.nextInt(ciudadesAuxiliares.size());
                        recorridoDelLadron.add(ciudadesAuxiliares.get(posicionRandom));
                        ciudadesAuxiliares.remove(posicionRandom);
                }
                
                
    			// AGREGO A CADA CADA CIUDAD DEL RECORRIDO DEL LADRON LOS LUGARES DE LA PROXIMA CIUDAD
                
                for(int k=0; k< recorridoDelLadron.size() - 1; k++){
                	
                	String nombreDeProximaCiudad = recorridoDelLadron.get(k + 1).obtenerNombre();
                	ArrayList<Lugar> lugares = new ArrayList<Lugar>();

                    if ( nombreDeProximaCiudad == "Madrid"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
                    	lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba la bandera roja y amarilla."),new Pista("Dijo que queria asistir a la fiesta del tomate."),new Pista("")));
                    	lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por euros."),new Pista(""),new Pista("")));
                    	lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria invertir en Paella."),new Pista(""),new Pista("")));
                    	lugares.add(new Lugar("Biblioteca",new Pista("Pidio un libro acerca de los toros."),new Pista(""),new Pista("")));
                    }
                            
                    if (nombreDeProximaCiudad == "Londres"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y azul."),new Pista("Se informo sobre los vuelos nocturnos hacia la isla de Wight."),new Pista("")));
                    	lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y azul."),new Pista("Pensaba navegar en un barco velero por el Severn."),new Pista("")));
                    	lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a libras esterlinas."),new Pista(""),new Pista("")));
                    	lugares.add(new Lugar("Bolsa",new Pista("Dijo que tenia la intencion de invertir en Whisky."),new Pista(""),new Pista("")));
                    	lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria saber si el Big Ben hacia tic."),new Pista("Buscaba sellos para aniadirlos a su coleccion."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Atenas"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Pidio el asiento de al lado de la ventana para poder ver los montes del Pindo."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario de griego en el bolsillo."),new Pista("Menciono que se estaba preparando para jugar al golf con el primer ministro."),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a euros."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("No dejaba de hacer preguntas sobre la antigua Esparta."),new Pista(""),new Pista("")));
                    }

                    if (nombreDeProximaCiudad == "Sidney"){
                        lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista("Dijo que queria visitar el Opera House."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("Se fue en un barco que llevaba una bandera que contiene otra bandera por dentro.")));
                        lugares.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista("Queria invertir en la cria de ovejas."),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Pensaba hacer un censo de las diversas especies de canguros."),new Pista("Solicito una biografia del capitan Cook.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Moscu"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se ha informado sobre las condiciones de la navegacion en el lago Baikal."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Queria comprar una reliquia que hubiera pertenecido a un zar."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a rublos."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Ha pedido un libro de recetas eslavas."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Paris"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el euro."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Intentaba comprender si habia alguna relacion entre la Bolsa y la moda."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre la construccion de la torre Eiffel."),new Pista("Estaba haciendo estudio sobre la cultura franca."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Tokio"){
                        lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Se fue en un avion blanco que contiene un circulo rojo."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Fuji."),new Pista("Pensaba partir con la mochila al hombro para explorar un archipielago."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a yens."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria visitar un pais en el que el precio del arroz fuera alto."),new Pista("Comento que habia invertido mucho en electronica."),new Pista("Dijo que estaba interesado en la industria automotriz.")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre los samurais."),new Pista("Deseaba visitar los lugares santos sintoistas."),new Pista("Comento que tenia ganas de leer una novela sobre los shoguns.")));
                    }
                    
                    if (nombreDeProximaCiudad == "El Cairo"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero en libras."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a adquirir el monopolio del mercado del algodon."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la piramide de Keops."),new Pista("Estudiaba la historia antigua de Alejandria."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Rio De Janeiro"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, azul y amarilla."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se preparaba para bajar por las cataratas del Iguazu."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a cruzados."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Roma"){
                        lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que queria visitar el Coliseo."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se ha marchado en un bote hinchable que llevaba una bandera verde, blanca y roja."),new Pista("El queria aprender a hablar con las manos."),new Pista("Deseaba observar una erupcion volcanica.")));
                        lugares.add(new Lugar("Banco",new Pista("Se ha ido en un vehiculo que llevaba una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a liras."),new Pista("Dijo que iba a hacer un negocio en la industria textil."),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Dijo que debia ir a la opera con el presidente."),new Pista("Dijo que queria visitar el Parlamento."),new Pista("Estaba interesado en la industria textil.")));                         
                    }
                    
                    if (nombreDeProximaCiudad == "Oslo"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y azul."),new Pista("Estaba buscando un guia que le enseniara los fiordos."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se marcho en un fuera borda que llevaba una bandera con una cruz azul."),new Pista("Dijo que queria navegar en kayak por los fiordos."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por coronas."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Dijo que se iba de pesca con el rey."),new Pista("Tenia la intencion de invertir en la electrometalurgia."),new Pista("Comento que iba a adquirir el monopolio del mercado del aluminio.")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la region escandinava."),new Pista("Comento que tenia ganas de estudiar la construccion de las naves vikingas."),new Pista("Estaba estudiando la influencia de Ibsen en Ingmar Bergman.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Montreal"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera con una hoja de arce."),new Pista(""),new Pista("Dijo que proponia visiar la isla de Baffin.")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y blanca."),new Pista("Queria pasar una noche en la isla de Prince Edward."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario frances."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a dolares."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre Yukon."),new Pista("Queria enumerar las especies de pajaros existentes en los territorios del norte."),new Pista("Dijo que estaba escribiendo un libro sobre los enfrentamientos coloniales franco-ingleses.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Nueva York"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que deseaba subir a la cima del Empire State."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un crucero que llevaba una bandera roja, blanca y azul con estrellas."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por dolares."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Pidio un libro sobre la estatua de la libertad."),new Pista("Pidio un mapa de Manhattan."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Singapur"){
                        lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Fue a visitar una isla del sudeste asiatico."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar un bosque tropical."),new Pista("Dijo que queria tirarse de cabeza en el puerto Calder."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Dijo que queria comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria jugar al polo con el presidente."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Dijo que tenia ganas de degustar un Gin Tonic en el hotel Raffles."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Bagdad"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Se ha marchado en un avion que ondeaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Me ha pedido una tabla de las mareas del Golfo Persico."),new Pista("Dijo que queria bajar por el Tigris en canoa."),new Pista("Se ha informado sobre la posibilidad de hacer vela en el Eufrates.")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el dinar."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Se fue rapidamente en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario de arabe en su mochila."),new Pista("No ha ocultado su decepcion al no encontrar libros sobre los asirios."),new Pista("Dijo que tenia secretos susceptibles de interesar al consejo dirigente de la revolucion.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Estambul"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion adornado con una bandera con una luna y una estrella."),new Pista("Se fue a un pais que se encuentra ubicado en dos contienentes."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera adornada con una luna y una estrella."),new Pista("Dijo que contaba con pasar la noche en el palacio de un sultan."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero por liras."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Hizo muchas preguntas sobre el imperio bizantino."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Katmandu"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Contaba pasar sus vacaciones en un reino asiatico."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se ha ido en un vehiculo que llevaba una bandera adornada con un triangulo doble."),new Pista("Estaba pensando en visitar un pais montanioso."),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Buscaba un libro sobre la conquista del monte Everest."),new Pista("Pidio un mapa de Himalaya"),new Pista("Queria aprenderse las oraciones hinduistas.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Dubai"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Paneo viajar hacia el medio oriente."),new Pista("Pidio el asiento de al lado de la ventana para poder ver el Burj Khalifa."),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, verde, blanca y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a dirham."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer el medio oriente."),new Pista("Pregunto sobre la industria petrolera."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "San Marino"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Titano"),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario italiano."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Nueva Delhi"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja, blanca y verde."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Deseaba ver el Nanda Devi."),new Pista("Estaba buscando un turbante sij."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Ciudad de Mexico"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Estaba pensando en viajar a un pais que se hable espaniol."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Dijo que iba a montar en caballo con el presidente."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a pesos."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre los Aztecas."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Lima"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Estaba pensando en visitar America."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaban el sol."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Tenia la intencion de comprar una mina de cobre."),new Pista("Dijo que tenia la intencion de invertir en el mercado del cinc."),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Retiro una biografia de Francisco Pizarro."),new Pista("Solicito un libro sobre la geologia de los Andes."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Kigali"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera azul, amarilla y verde."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul, amarilla y verde."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el franco CFA."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Compro francos CFA en el mercado negro."),new Pista("Llevaba un diccionario en frances."),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Retiro libros sobre los gorilas de las montanias."),new Pista("Dijo que queria averiguar sobre volcanes."),new Pista("Dijo que queria averiguar sobre los mambos negros.")));
                    }
                    
                    if (nombreDeProximaCiudad == "Reykjavik"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que iba a veranear en una isla del atlantico norte."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un barco que llevaba una bandera roja y azul."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Pregunto sobre el precio de la corona."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a coronas."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que iba a tomar un cafe con el presidente."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Budapest"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Contaba con visitar un pais de Europa central."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Tomo un barco que llevaba una bandera roja, blanca y verde."),new Pista("Se translado a un pais vecino de Austria."),new Pista("Comento que le gustaria bajar por el Danubio en un barco velero.")));
                        lugares.add(new Lugar("Banco",new Pista("Ha cambiado su dinero a forints."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Solicito un libro sobre Budapest."),new Pista("Estaba buscando antiguos manuscritos magiares."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Bamako"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que se iba a tomar unas vacaciones en el contiente africano."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se marcho en un barco que lucia una bandera verde, amarilla y roja."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Dijo que iba a jugar al bridge con el presidente."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por francos CFA."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Se intereso por el estudio de las relaciones familiares de los tuaregs."),new Pista("Pensaba visitar una excavacion arqueologica al antiguo Tombuctu."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Bangkok"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que tenia adornada el ala con una bandera roja, blanca y azul."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Deseaba comprar bahts en el mercado negro. Ha hablado de la belleza de las montanias."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaban los bahts."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Contaba realizar una visita con un guia por los wats siameses."),new Pista(""),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Moroni"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Estaba pensando en visitar unas islas en el sur."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se ha ido en un catamaran que lucia una bandera verde y blanca."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Dijo que iba a comprar todo lo necesario para hacer perfumes."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el franco comorense."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionaro arabe en la maleta."),new Pista("Pidio informacion sobre los volcanes. Ha hablado de la belleza de las montanias."),new Pista("")));
                    }
                    
                    if (nombreDeProximaCiudad == "Puerto Moresby"){
                    	lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que pensaba visitar Nueva-Irlanda."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y negra."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a kinas."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a una barbacoa con el primer ministro."),new Pista(""),new Pista("")));
                        lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                    }
                	
                	
                	/* CON SERIALIZACION, DEJENLO QUE DESPUES LE PREGUNTO AL PROFE Y ASI QUEDA PROLIJO
                	 
                	File archivoLugar = new File("LugaresDeCiudades.xml");
        			
        			DocumentBuilderFactory dbFactoryLugar = DocumentBuilderFactory.newInstance();
        			DocumentBuilder dBuilderLugar = dbFactoryLugar.newDocumentBuilder();
        			Document docLugar = dBuilder.parse(archivoLugar);
        			docLugar.getDocumentElement().normalize();
        			
        			Element elementoLugares = (Element)docLugar.getElementsByTagName(nombreDeProximaCiudad).item(0);						
        			
        			ArrayList<Lugar> lugares = new ArrayList<Lugar>();
        			
        			int j = 0; //OBTENGO TODOS LOS LUGARES DEL PAIS SIGUIENTE
        			while (elementoLugares.getChildNodes().item(j) != null){
        				Lugar lugar = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(j));
        				lugares.add( lugar );
        				j = j + 1;
        			}
        			
        			*/
                	
                	
                 //REMUEVO TODOS LOS LUGARES MENOS 2
                	
        			  while (lugares.size() > 2){ 
                          int valor = generadorRandom.nextInt(lugares.size());
                          lugares.remove(valor);
                  }
        			  
        		//AGREGO TODOS LOS LUGARES A LA CIUDAD, 1 CON PISTA DEL LADRON Y LOS OTROS SOBRE A DONDE FUE
        			  
        			  recorridoDelLadron.get(i).agregarLugar( lugares.get(0) );
        			  recorridoDelLadron.get(i).agregarLugar( lugares.get(1) );
        			  
        			  // ACA HAY QUE CARGAR LAS PISTAS CON LOS LADRONES
        			  //Integer posicionDeLugarConPistaDeLadron = generadorRandom.nextInt(lugaresDePistasDelLadron).size();
        			  //recorridoDelLadron.get(i).agregarLugar( lugaresDePistasDelLadron.get( posicionDeLugarConPistaDeLadron ) );
        			     			
                	
                }
                
                //A LOS PAISES QUE NO ESTAN EN EL RECORRIDO DEL LADRON LES AGREGO LUGARES SIN PISTAS
                
                Lugar lugarSinPistas1 = new Lugar("Banco", new Pista("no he visto a esa persona"), new Pista("no he visto a esa persona"), new Pista("no he visto a esa persona") );
                Lugar lugarSinPistas2 = new Lugar("Biblioteca", new Pista("esa persona no ha pasado por aqui"), new Pista("esa persona no ha pasado por aqui"), new Pista("esa persona no ha pasado por aqui") );
                Lugar lugarSinPistas3 = new Lugar("Muelle", new Pista("deberias ir a otro lugar a preguntar, por aqui no he visto a nadie"), new Pista("deberias ir a otro lugar a preguntar, por aqui no he visto a nadie"), new Pista("deberias ir a otro lugar a preguntar, por aqui no he visto a nadie") );

                for(int k=0; i< ciudadesAuxiliares.size(); k++){
                	
                	ciudadesAuxiliares.get(k).agregarLugar(lugarSinPistas1);
                	ciudadesAuxiliares.get(k).agregarLugar(lugarSinPistas2);
                	ciudadesAuxiliares.get(k).agregarLugar(lugarSinPistas3);
                }
                
                //A LAS CIUDADES DEL RECORRIDO DEL LADRON LES AGREGO LA PROXIMA CIUDAD EN LA LISTA Y OTRAS 2 AL AZAR DE LAS CIUDADES AUXILIARES
                
                for( int k=0; k< recorridoDelLadron.size() - 1; k++){
                	
                	Ciudad unaCiudad = recorridoDelLadron.get(k);
                	unaCiudad.agregarCiudadAViajar( recorridoDelLadron.get(k + 1) );
                	
                	int valor1 = generadorRandom.nextInt(ciudadesAuxiliares.size());
                	int valor2 = valor1;
                	while (valor1 != valor2){
                		valor2 = generadorRandom.nextInt(ciudadesAuxiliares.size());
                	}
                	
                	unaCiudad.agregarCiudadAViajar( ciudadesAuxiliares.get(valor1) );
                	unaCiudad.agregarCiudadAViajar( ciudadesAuxiliares.get(valor2) );
                	
                }
                
                //AGREGO A LA ULTIMA CIUDAD LOS LUGARES EN QUE TE ACUCHILLAN, DISPARAN Y GANAS.
                
                LugarDondeAcuchillan lugar1 = new LugarDondeAcuchillan();
                LugarDondeDisparan lugar2 = new LugarDondeDisparan();
                LugarConLadron lugar3 = new LugarConLadron( null);
                Ciudad ultimaCiudad = recorridoDelLadron.get( recorridoDelLadron.size() -1);
                
                ultimaCiudad.agregarLugar(lugar1);
                ultimaCiudad.agregarLugar(lugar2);
                ultimaCiudad.agregarLugar(lugar3);
                
                
                ////////////////////////////
               
        }
        
        public ArrayList<Ladron> generarListaDeLadrones() throws ParserConfigurationException, TransformerException, SAXException, IOException{
        	
        	File archivo = new File("ListaDeLadrones.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivo);
			doc.getDocumentElement().normalize();
			
			Element elementoLadrones = (Element)doc.getElementsByTagName("Ladrones").item(0);						
			
			ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
			
			int i = 0;
			while (elementoLadrones.getChildNodes().item(i) != null){
				Ladron ladron = Ladron.cargarEstado((Element) elementoLadrones.getChildNodes().item(i));
				ladrones.add( ladron );
				i = i + 1;
			}
			
			return ladrones;
        }
        
        public ArrayList<Ciudad> obtenerRecorridoDelLadron(){
        	
        	return this.recorridoDelLadron;
        }
        
        public ArrayList<Ciudad> obtenerCiudadesAuxiliares(){
        	
        	return this.ciudadesAuxiliares;
        }
}