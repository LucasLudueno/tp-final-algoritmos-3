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
        
private ArrayList<Ciudad> ciudades;     
        
        public GeneradorDePartidas(){
                
        		this.ciudades = new ArrayList<Ciudad>();
                ciudades.add(new Ciudad("Buenos Aires",1,1,null,null,null,null));
                ciudades.add(new Ciudad("Madrid",1,1,null,null,null,null));
                ciudades.add(new Ciudad("Londres",1,1,null,null,null,null));
                ciudades.add(new Ciudad("Hong Kong",1,1,null,null,null,null));
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
                ciudades.add(new Ciudad("Pekin",1,1,null,null,null,null));
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
        }
        
        public ArrayList<Ciudad> generarListaDeCiudadesValidas(ArrayList<Ciudad> unaListaDeCiudades){
                ArrayList<Ciudad> ciudadesValidas = new ArrayList<Ciudad>();
                ArrayList<Lugar> lugares = new ArrayList<Lugar>();
                Random generador = new Random();
                
                for (int i=0; i < 6; i++){
                        int valor = generador.nextInt(ciudades.size());
                        ciudadesValidas.add(ciudades.get(valor));
                        ciudades.remove(valor);
                }
                
                for (int i=0; i < ciudadesValidas.size(); i++){
                        if (ciudadesValidas.get(i).obtenerNombre() == "Buenos Aires"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion pintado de azul y blanco."),new Pista("Ha tomado un avion que llevaba un sol dorado."),new Pista("")));
                        	lugares.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras espaniolas."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos."),new Pista("Ha invertido todo su dinero en soja."),new Pista("")));
                        	lugares.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico mas alto de America."),new Pista("Era beneficiario de una beca para estudiar el nivel de colesterol de los gauchos."),new Pista("Ha hecho preguntas sobre la epoca de las conquistas espaniolas.")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Madrid"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que tenia pensado asistir a una corrida de toros."),new Pista(""),new Pista("")));
                        }
                                
                        if (ciudadesValidas.get(i).obtenerNombre() == "Londres"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Se informo sobre los vuelos nocturnos hacia la isla de Wight."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a libras esterlinas."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Bolsa",new Pista("Dijo que tenia la intencion de invertir en Whisky."),new Pista(""),new Pista("")));
                        	lugares.add(new Lugar("Biblioteca",new Pista("Buscaba sellos para aniadirlos a su coleccion."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Hong Kong"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Atenas"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Pidio el asiento de al lado de la ventana para poder ver los montes del Pindo."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y blanca."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario de griego en el bolsillo."),new Pista("Menciono que se estaba preparando para jugar al golf con el primer ministro."),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a euros."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("No dejaba de hacer preguntas sobre la antigua Esparta."),new Pista(""),new Pista("")));
                        }

                        if (ciudadesValidas.get(i).obtenerNombre() == "Sidney"){
                            lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Estaba interesado en ver a los coalas."),new Pista("Dijo que queria visitar el Opera House.")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Moscu"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se ha informado sobre las condiciones de la navegacion en el lago Baikal."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Queria comprar una reliquia que hubiera pertenecido a un zar."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a rublos."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Ha pedido un libro de recetas eslavas."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Paris"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Tokio"){
                            lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Fuji."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a yens."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Se fue en un vehiculo en el que ondeaba una bandera roja y blanca."),new Pista("Dijo que estaba interesado en la insdustria automotriz."),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre los samurais."),new Pista("Deseaba visitar los lugares santos sintoistas."),new Pista("Comento que tenia ganas de leer una novela sobre los shoguns.")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "El Cairo"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero en libras."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a adquirir el monopolio del mercado del algodon."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la piramide de Keops."),new Pista("Estudiaba la historia antigua de Alejandria."),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Rio De Janeiro"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Roma"){
                            lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que queria visitar el Coliseo."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se ha marchado en un bote hinchable que llevaba una bandera verde, blanca y roja."),new Pista("El queria aprender a hablar con las manos."),new Pista("Deseaba observar una erupcion volcanica.")));
                            lugares.add(new Lugar("Banco",new Pista("Se ha ido en un vehiculo que llevaba una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a liras."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Dijo que debia ir a la opera con el presidente."),new Pista("Dijo que queria visitar el Parlamento."),new Pista("Estaba interesado en la industria textil.")));                         
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Oslo"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y azul."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se marcho en un fuera borda que llevaba una bandera con una cruz azul."),new Pista("Dijo que queria navegar en kayak por los fiordos."),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por coronas."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Dijo que se iba de pesca con el rey."),new Pista("Tenia la intencion de invertir en la electrometalurgia."),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la region escandinava."),new Pista("Comento que tenia ganas de estudiar la construccion de las naves vikingas."),new Pista("Estaba estudiando las canciones de cuna de la epoca de los vikingos. Ha hablado de la belleza de las montanias.")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Montreal"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera con una hoja de arce."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y blanca."),new Pista("Queria pasar una noche en la isla de Prince Edward."),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario frances."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a dolares."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre Yukon."),new Pista("Queria enumerar las especies de pajaros existentes en los territorios del norte."),new Pista("Dijo que estaba escribiendo un libro sobre los enfrentamientos coloniales franco-ingleses.")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Nueva York"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Pekin"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Singapur"){
                            lugares.add(new Lugar("Aeropuerto",new Pista("Fue a visitar una isla del sudeste asiatico."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar un bosque tropical."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Dijo que queria comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria jugar al polo con el presidente."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Dijo que tenia ganas de degustar un Gin Tonic en el hotel Raffles. Pidio una mariscada."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Bagdad"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Se ha marchado en un avion que ondeaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Me ha pedido una tabla de las mareas del Golfo Persico."),new Pista("Dijo que queria bajar por el Tigris en canoa."),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el dinar."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Se fue rapidamente en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("No ha ocultado su decepcion al no encontrar libros sobre los asirios."),new Pista("Dijo que tenia secretos susceptibles de interesar al consejo dirigente de la revolucion."),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Estambul"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion adornado con una bandera con una luna y una estrella."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera adornada con una luna y una estrella."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero por liras."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Hizo muchas preguntas sobre el imperio bizantino."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Katmandu"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Contaba pasar sus vacaciones en un reino asiatico."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se ha ido en un vehiculo que llevaba una bandera adornada con un triangulo doble."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Queria aprenderse las oraciones hinduistas."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Dubai"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Paneo viajar hacia el medio oriente."),new Pista("Pidio el asiento de al lado de la ventana para poder ver el Burj Khalifa."),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, verde, blanca y negra."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a dirham."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer el medio oriente."),new Pista("Pregunto sobre la industria petrolera."),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "San Marino"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Nueva Delhi"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja, blanca y verde."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Deseaba ver el Nanda Devi."),new Pista("Estaba buscando un turbante sij."),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Ciudad de Mexico"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Lima"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Kigali"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Reykjavik"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Se fue en un barco que llevaba una bandera roja y azul."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a coronas."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que iba a tomar un cafe con el presidente."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Budapest"){
                        	lugares.add(new Lugar("Aeropuerto",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Puerto",new Pista("Comento que le gustaria bajar por el Danubio en un barco velero."),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                            lugares.add(new Lugar("Biblioteca",new Pista("Solicito un libro sobre Budapest."),new Pista("Estaba buscando antiguos manuscritos magiares."),new Pista("")));
                        }
                        
                        
                        while (lugares.size() > 3){
                                int valor = generador.nextInt(lugares.size());
                                lugares.remove(valor);
                        }
                        
                        for(int j=0; j < lugares.size(); j++){
                                ciudadesValidas.get(i).obtenerLugares().add(lugares.get(j));
                        }
                        
                }
                
                return ciudadesValidas;
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
}