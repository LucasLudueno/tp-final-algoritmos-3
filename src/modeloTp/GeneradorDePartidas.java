package modeloTp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class GeneradorDePartidas {
	
	private ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public GeneradorDePartidas(){
		ArrayList<Ciudad> listaDeCiudades = new ArrayList<Ciudad>();
		Random generador = new Random();
		int valor;
		
		//Genero la lista de las ciudades que contiene el juego
		listaDeCiudades.add(new Ciudad("Buenos Aires",8,5,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Madrid",12,10,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Londres",12,12,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Atenas",14,11,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Sidney",22,5,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Moscu",15,12,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Paris",13,11,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Tokio",22,10,null,null,null,null));
		listaDeCiudades.add(new Ciudad("El Cairo",14,10,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Rio De Janeiro",9,6,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Roma",13,11,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Oslo",13,13,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Montreal",8,12,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Nueva York",8,11,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Singapur",19,8,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Bagdad",15,10,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Estambul",15,11,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Katmandu",18,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Dubai",15,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("San Marino",13,10,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Nueva Delhi",17,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Ciudad de Mexico",5,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Lima",7,7,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Kigali",14,8,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Reykjavik",11,13,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Budapest",14,12,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Bamako",12,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Bangkok",19,9,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Moroni",15,7,null,null,null,null));
		listaDeCiudades.add(new Ciudad("Puerto Moresby",22,7,null,null,null,null));
		
		while (listaDeCiudades.size() > 0){
			valor = generador.nextInt(listaDeCiudades.size());
			ciudades.add(listaDeCiudades.get(valor));
			listaDeCiudades.remove(valor);
		}
	}
	
	public ArrayList<Ciudad> obtenerCiudades(){
		return ciudades;
	}
	
	private ArrayList<Ciudad> generarListaDeCiudadesValidas(){
		ArrayList<Ciudad> ciudadesValidas = new ArrayList<Ciudad>();
		Random generador = new Random();
		
		//Tomo aleatoriamente seis ciudades de la lista
		for (int i=0; i < 6; i++){
			int valor = generador.nextInt(ciudades.size());
			ciudadesValidas.add(ciudades.get(valor));
			ciudades.remove(valor);
		}
		
		return ciudadesValidas;
	}
	
	public ArrayList<Ciudad> generarCiudadesConLugares(){
		ArrayList<Ciudad> ciudadesValidas = this.generarListaDeCiudadesValidas();
		this.generarLugaresACiudadesInvalidas();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Random generador = new Random();
		
		//Genero los lugares con sus pistas para cada ciudad
		for(int i=0; i < ciudadesValidas.size(); i++){
			if (ciudadesValidas.get(i).obtenerNombre() == "Buenos Aires"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion pintado de azul y blanco."),new Pista("Ha tomado un avion que llevaba un sol dorado."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras espaniolas."),new Pista("Pregunto donde se encontraba el rio Parana."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos."),new Pista("Ha invertido todo su dinero en soja."),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico mas alto de America."),new Pista("Era beneficiario de una beca para estudiar el nivel de colesterol de los gauchos."),new Pista("Ha hecho preguntas sobre la epoca de las conquistas espaniolas.")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Madrid"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba la bandera roja y amarilla."),new Pista("Dijo que queria asistir a la fiesta del tomate."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por euros."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria invertir en Paella."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Pidio un libro acerca de los toros."),new Pista(""),new Pista("")));
			}
                
			if (ciudadesValidas.get(i).obtenerNombre() == "Londres"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja, blanca y azul."),new Pista("Se informo sobre los vuelos nocturnos hacia la isla de Wight."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, blanca y azul."),new Pista("Pensaba navegar en un barco velero por el Severn."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a libras esterlinas."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que tenia la intencion de invertir en Whisky."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria saber si el Big Ben hacia tic."),new Pista("Buscaba sellos para aniadirlos a su coleccion."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Atenas"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Pidio el asiento de al lado de la ventana para poder ver los montes del Pindo."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario de griego en el bolsillo."),new Pista("Menciono que se estaba preparando para jugar al golf con el primer ministro."),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a euros."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("No dejaba de hacer preguntas sobre la antigua Esparta."),new Pista("Dijo que estaba investigando la republica de Platon."),new Pista("")));
			}

			if (ciudadesValidas.get(i).obtenerNombre() == "Sidney"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista("Dijo que queria visitar el Opera House."),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("Se fue en un barco que llevaba una bandera que contiene otra bandera por dentro.")));
				lugares.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista("Queria invertir en la cria de ovejas."),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Pensaba hacer un censo de las diversas especies de canguros."),new Pista("Solicito una biografia del capitan Cook.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Moscu"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se ha informado sobre las condiciones de la navegacion en el lago Baikal."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Queria comprar una reliquia que hubiera pertenecido a un zar."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a rublos."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Ha pedido un libro de recetas eslavas."),new Pista(""),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Paris"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, azul y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el euro."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Intentaba comprender si habia alguna relacion entre la Bolsa y la moda."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Queria un libro sobre la construccion de la torre Eiffel."),new Pista("Estaba haciendo estudio sobre la cultura franca."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Tokio"){
      		 	lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Se fue en un avion blanco que contiene un circulo rojo."),new Pista("")));
      		 	lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Fuji."),new Pista("Pensaba partir con la mochila al hombro para explorar un archipielago."),new Pista("")));
      		 	lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a yens."),new Pista(""),new Pista("")));
      		 	lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria visitar un pais en el que el precio del arroz fuera alto."),new Pista("Comento que habia invertido mucho en electronica."),new Pista("Dijo que estaba interesado en la industria automotriz.")));
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
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, azul y amarilla."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se preparaba para bajar por las cataratas del Iguazu."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a reales."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a adquirir el monopolio de la industria del cafe."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Buscaba libros sobre las conquistas portugesas."),new Pista(""),new Pista("")));
        	}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Roma"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que queria visitar el Coliseo."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista("Se ha marchado en un bote hinchable que llevaba una bandera verde, blanca y roja."),new Pista("El queria aprender a hablar con las manos."),new Pista("Deseaba observar una erupcion volcanica.")));
				lugares.add(new Lugar("Banco",new Pista("Se ha ido en un vehiculo que llevaba una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a liras."),new Pista("Dijo que iba a hacer un negocio en la industria textil."),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Dijo que debia ir a la opera con el presidente."),new Pista("Dijo que queria visitar el Parlamento."),new Pista("Estaba interesado en la industria textil.")));                         
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Oslo"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y azul."),new Pista("Estaba buscando un guia que le enseniara los fiordos."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se marcho en un fuera borda que llevaba una bandera con una cruz azul."),new Pista("Dijo que queria navegar en kayak por los fiordos."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero por coronas."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que se iba de pesca con el rey."),new Pista("Tenia la intencion de invertir en la electrometalurgia."),new Pista("Comento que iba a adquirir el monopolio del mercado del aluminio.")));
                lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer la region escandinava."),new Pista("Comento que tenia ganas de estudiar la construccion de las naves vikingas."),new Pista("Estaba estudiando la influencia de Ibsen en Ingmar Bergman.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Montreal"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera con una hoja de arce."),new Pista(""),new Pista("Dijo que proponia visiar la isla de Baffin.")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y blanca."),new Pista("Queria pasar una noche en la isla de Prince Edward."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario frances."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a dolares."),new Pista("Dijo que tenia la intencion de adquirir el monopolio del mercado del uranio."),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre Yukon."),new Pista("Queria enumerar las especies de pajaros existentes en los territorios del norte."),new Pista("Dijo que estaba escribiendo un libro sobre los enfrentamientos coloniales franco-ingleses.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Nueva York"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que deseaba subir a la cima del Empire State."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un crucero que llevaba una bandera roja, blanca y azul con estrellas."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el dolar."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por dolares."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Pidio un libro sobre la estatua de la libertad."),new Pista("Pidio un mapa de Manhattan."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Singapur"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista("Fue a visitar una isla del sudeste asiatico."),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar un bosque tropical."),new Pista("Dijo que queria tirarse de cabeza en el puerto Calder."),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista("Dijo que queria comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Dijo que queria jugar al polo con el presidente."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista("Dijo que tenia ganas de degustar un Gin Tonic en el hotel Raffles."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Bagdad"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Se ha marchado en un avion que ondeaba una bandera roja, blanca y negra."),new Pista("Buscaba una guia de familiarizacion con los vestigios de ceramicas mesopotamicas."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Me ha pedido una tabla de las mareas del Golfo Persico."),new Pista("Dijo que queria bajar por el Tigris en canoa."),new Pista("Se ha informado sobre la posibilidad de hacer vela en el Eufrates.")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba el dinar."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Se fue rapidamente en un vehiculo que llevaba una bandera roja, blanca y negra."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario de arabe en su mochila."),new Pista("No ha ocultado su decepcion al no encontrar libros sobre los asirios."),new Pista("Dijo que tenia secretos susceptibles de interesar al consejo dirigente de la revolucion.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Estambul"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion adornado con una bandera con una luna y una estrella."),new Pista("Se fue a un pais que se encuentra ubicado en dos contienentes."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera adornada con una luna y una estrella."),new Pista("Dijo que contaba con pasar la noche en el palacio de un sultan."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto cuanto estaba la lira."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero por liras."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Hizo muchas preguntas sobre el imperio bizantino."),new Pista(""),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Katmandu"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Contaba pasar sus vacaciones en un reino asiatico."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se ha ido en un vehiculo que llevaba una bandera adornada con un triangulo doble."),new Pista("Estaba pensando en visitar un pais montanioso."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a rupias."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Llevaba un diccionario nepali."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Buscaba un libro sobre la conquista del monte Everest."),new Pista("Pidio un mapa de Himalaya"),new Pista("Queria aprenderse las oraciones hinduistas.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Dubai"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Paneo viajar hacia el medio oriente."),new Pista("Pidio el asiento de al lado de la ventana para poder ver el Burj Khalifa."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja, verde, blanca y negra."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a dirham."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a invertir en la industria del petroleo."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Estaba interesado en conocer el medio oriente."),new Pista("Pregunto sobre la industria petrolera."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "San Marino"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera azul y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Dijo que queria visitar el Monte Titano"),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Contaba con salir, con la mochila al hombro, a visitar a los vecinos de Italia."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionario italiano."),new Pista(""),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Nueva Delhi"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion cuya ala estaba adornada con una bandera roja, blanca y verde."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Dijo que queria averiguar sobre la religion Sikh."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Llevaba un diccionario hindi."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a rupias."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Deseaba ver el Nanda Devi."),new Pista("Estaba buscando un turbante sij."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Ciudad de Mexico"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, blanca y roja."),new Pista("Conocia el antiguo nombre de la capital, Tenoctitlan."),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Estaba pensando en viajar a un pais que se hable espaniol."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Dijo que iba a montar en caballo con el presidente."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero a pesos."),new Pista("Queria saber el precio de la cania de azucar."),new Pista("")));
           		lugares.add(new Lugar("Biblioteca",new Pista("Dijo que queria averiguar sobre los Aztecas."),new Pista("Investigaba los origenes de los calendarios mayas."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Lima"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Estaba pensando en visitar America."),new Pista("Ha dicho que queria seguir los pasos de los conquistadores espanioles."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaban el sol."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Tenia la intencion de comprar una mina de cobre."),new Pista("Dijo que tenia la intencion de invertir en el mercado del cinc."),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Retiro una biografia de Francisco Pizarro."),new Pista("Solicito un libro sobre la geologia de los Andes."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Kigali"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera azul, amarilla y verde."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera azul, amarilla y verde."),new Pista("Se inquieto al saber que habia cocodrilos en el rio Kagera."),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto a cuanto estaba el franco CFA."),new Pista("Estaba haciendo investigaciones sobre personas extremadamente altas."),new Pista("")));
            	lugares.add(new Lugar("Bolsa",new Pista("Compro francos CFA en el mercado negro."),new Pista("Llevaba un diccionario en frances."),new Pista("")));
            	lugares.add(new Lugar("Biblioteca",new Pista("Retiro libros sobre los gorilas de las montanias."),new Pista("Dijo que queria averiguar sobre volcanes."),new Pista("Dijo que queria averiguar sobre los mambos negros.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Reykjavik"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que iba a veranear en una isla del atlantico norte."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un barco que llevaba una bandera roja y azul."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Pregunto sobre el precio de la corona."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Cambio su dinero a coronas."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que iba a tomar un cafe con el presidente."),new Pista(""),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Budapest"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Contaba con visitar un pais de Europa central."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Tomo un barco que llevaba una bandera roja, blanca y verde."),new Pista("Se translado a un pais vecino de Austria."),new Pista("Comento que le gustaria bajar por el Danubio en un barco velero.")));
                lugares.add(new Lugar("Banco",new Pista("Ha cambiado su dinero a forints."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a jugar al golf con el presidente."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Solicito un libro sobre Budapest."),new Pista("Estaba buscando antiguos manuscritos magiares."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Bamako"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que se iba a tomar unas vacaciones en el contiente africano."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se marcho en un barco que lucia una bandera verde, amarilla y roja."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Dijo que iba a jugar al bridge con el presidente."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Vino a cambiar su dinero por francos CFA."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Se intereso por el estudio de las relaciones familiares de los tuaregs."),new Pista("Pensaba visitar una excavacion arqueologica al antiguo Tombuctu."),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Bangkok"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que tenia adornada el ala con una bandera roja, blanca y azul."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Dijo que iba a pasar unas vacaciones por la Asia Oriental."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Deseaba comprar bahts en el mercado negro. Ha hablado de la belleza de las montanias."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaban los bahts."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Contaba realizar una visita con un guia por los wats siameses."),new Pista(""),new Pista("")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Moroni"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Estaba pensando en visitar unas islas en el sur."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se ha ido en un catamaran que lucia una bandera verde y blanca."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Dijo que iba a comprar todo lo necesario para hacer perfumes."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Pregunto a cuanto estaba el franco comorense."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Llevaba un diccionaro arabe en la maleta."),new Pista("Pidio informacion sobre los volcanes. Ha hablado de la belleza de las montanias."),new Pista("Buscaba un libro sobre la industria del perfume.")));
			}
        
			if (ciudadesValidas.get(i).obtenerNombre() == "Puerto Moresby"){
                lugares.add(new Lugar("Aeropuerto",new Pista("Dijo que pensaba visitar Nueva-Irlanda."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Puerto",new Pista("Se fue en un vehiculo que llevaba una bandera roja y negra."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Banco",new Pista("Cambio su dinero a kinas."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Bolsa",new Pista("Dijo que iba a una barbacoa con el primer ministro."),new Pista(""),new Pista("")));
                lugares.add(new Lugar("Biblioteca",new Pista("Hizo preguntas sobre la colonizacion europea."),new Pista(""),new Pista("")));
			}
			
			while (lugares.size() > 3){
				int valor = generador.nextInt(lugares.size());
				lugares.remove(valor);
			}
			
			for(int j=0; j < lugares.size(); j++){
                ciudadesValidas.get(i).obtenerLugares().add(lugares.get(j));
			}
			lugares.clear();
		}	
		
		//Agrego las ciudades a viajar asignando la siguiente ciudad valida y las restantes son ciudades invalidas al azar
        
        for(int i=0; i < ciudadesValidas.size() - 1; i++){
        	Ciudad unaCiudad = ciudadesValidas.get(i);
        	unaCiudad.agregarCiudadAViajar(ciudadesValidas.get(i + 1));
        	
        	for(int j=0; j<2; j++){
        		int valor = generador.nextInt(ciudades.size()); 
        		unaCiudad.agregarCiudadAViajar(ciudades.get(valor));
        	}
        }
		return ciudadesValidas;		
	}
	
	private void generarLugaresACiudadesInvalidas(){
		Random generador = new Random();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		
		for(int i=0; i < ciudades.size(); i++){
			lugares.add(new Lugar("Aeropuerto",new Pista("Lo siento, nunca he visto a esa persona."),new Pista("Lo siento, nunca he visto a esa persona."),new Pista("Lo siento, nunca he visto a esa persona.")));
	        lugares.add(new Lugar("Puerto",new Pista("Pasa mucha gente por aqui. No he visto nada sospechoso."),new Pista("Pasa mucha gente por aqui. No he visto nada sospechoso."),new Pista("Pasa mucha gente por aqui. No he visto nada sospechoso.")));
	        lugares.add(new Lugar("Banco",new Pista("Lo siento, no he visto a nadie que responda a esas senias."),new Pista("Lo siento, no he visto a nadie que responda a esas senias."),new Pista("Lo siento, no he visto a nadie que responda a esas senias.")));
	        lugares.add(new Lugar("Bolsa",new Pista("Lo lamento, nunca he visto a la persona que buscas."),new Pista("Lo lamento, nunca he visto a la persona que buscas."),new Pista("Lo lamento, nunca he visto a la persona que buscas.")));
	        lugares.add(new Lugar("Biblioteca",new Pista("No creo haber visto a una persona asi en la biblioteca."),new Pista("No creo haber visto a una persona asi en la biblioteca."),new Pista("No creo haber visto a una persona asi en la biblioteca.")));
	        	
	        	while (lugares.size() > 3){
	        		int valor = generador.nextInt(lugares.size());
					lugares.remove(valor);
	        	}
			
	        	for(int j=0; j < lugares.size(); j++){
	        		ciudades.get(i).obtenerLugares().add(lugares.get(j));
	        	}
	        lugares.clear();
		}
	}
	
	public ArrayList<Ciudad> generarRecorridoDelLadron() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		ArrayList<Ciudad> recorridoLadron = this.generarCiudadesConLugares(); 
		
		for (int i=0; i < recorridoLadron.size()-1; i++){
			recorridoLadron.get(i).obtenerLugares().clear();
			for (int j=0; j < 3; j++){
				ILugar unLugar = recorridoLadron.get(i+1).obtenerLugares().get(j);
				recorridoLadron.get(i).agregarLugar(unLugar);
			}
		}
		
		//Asigno las acciones de la ultima ciudad
		Random generador = new Random();
		ArrayList<String> listaDeLugares = new ArrayList<String>();
		listaDeLugares.add("Aeropuerto");
		listaDeLugares.add("Puerto");
		listaDeLugares.add("Banco");
		listaDeLugares.add("Bolsa");
		listaDeLugares.add("Biblioteca");
		
		ArrayList<ILugar> lugaresSospechosos = new ArrayList<ILugar>();
		Ladron ladronElegido = this.obtenerUnLadronDeLaLista();
		
		int valor = generador.nextInt(listaDeLugares.size());
		lugaresSospechosos.add(new LugarConLadron(listaDeLugares.get(valor),ladronElegido));
		listaDeLugares.remove(valor);
		
		valor = generador.nextInt(listaDeLugares.size());
		lugaresSospechosos.add(new LugarDondeAcuchillan(listaDeLugares.get(valor)));
		listaDeLugares.remove(valor);
		
		valor = generador.nextInt(listaDeLugares.size());
		lugaresSospechosos.add(new LugarDondeDisparan(listaDeLugares.get(valor)));
		
		//Asigno los lugares a la ultima ciudad del recorrido
		recorridoLadron.get(recorridoLadron.size()-1).obtenerLugares().clear();
		while(lugaresSospechosos.size()>0){
			valor = generador.nextInt(lugaresSospechosos.size());
			recorridoLadron.get(recorridoLadron.size()-1).agregarLugar(lugaresSospechosos.get(valor));
			lugaresSospechosos.remove(valor);			
		}
		
		return recorridoLadron;
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
	
	private Ladron obtenerUnLadronDeLaLista() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		Random generador = new Random();
		ArrayList<Ladron> listaDeLadrones = this.generarListaDeLadrones();
		
		int valor = generador.nextInt(listaDeLadrones.size());
		
		return listaDeLadrones.get(valor);
	}
}
