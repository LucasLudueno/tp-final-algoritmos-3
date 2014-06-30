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
	private ArrayList<Ciudad> recorridoLadron = new ArrayList<Ciudad>();
	private int pasoActual = 0;
	private Ladron ladronBuscado;
	private Pista mensajeJuegoGanado;
	private Pista mensajeJuegoPerdidoPorOrdenIncorrecta;
	private Pista mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto;
	
	
	public ArrayList<Ciudad> generarListaDeCiudades() throws ParserConfigurationException, SAXException, IOException{
		
		File archivo = new File("ListaDeCiudades.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Element elementoCiudades = (Element)doc.getElementsByTagName("Ciudades").item(0);						
		ArrayList<Ciudad> listaDeCiudades = new ArrayList<Ciudad>();
		
		int i = 0;
		while (elementoCiudades.getChildNodes().item(i) != null){
			Ciudad ciudad = Ciudad.cargarEstado((Element) elementoCiudades.getChildNodes().item(i));
			listaDeCiudades.add( ciudad );
			i = i + 1;
		}
		
		return listaDeCiudades;
	}
	
	public ArrayList<Lugar> generarLugaresDeUnaCiudad(String nombreDeLaCiudad) throws ParserConfigurationException, SAXException, IOException{
		
		File archivo = new File(nombreDeLaCiudad+".xml");
		
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
		return lugares;
	
	}
	
	public ArrayList<Pista> generarPistasDelLadron() throws ParserConfigurationException, SAXException, IOException{
		
		File archivo = new File("PistasLadronPrehechas.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Element elementoPistas = (Element)doc.getElementsByTagName("PistasLadron").item(0);						
		
		ArrayList<Pista> pistasLadron = new ArrayList<Pista>();
		
		Pista pistaCabelloLadron = Pista.cargarEstado((Element) elementoPistas.getChildNodes().item(0));
		Pista pistaHobbyLadron = Pista.cargarEstado((Element) elementoPistas.getChildNodes().item(1));
		Pista pistaSeniaLadron = Pista.cargarEstado((Element) elementoPistas.getChildNodes().item(2));
		Pista pistaVehiculoLadron = Pista.cargarEstado((Element) elementoPistas.getChildNodes().item(3));
		
		pistaCabelloLadron.agregarContenido(ladronBuscado.obtenerCabello());
		pistaHobbyLadron.agregarContenido(ladronBuscado.obtenerHobby());
		pistaSeniaLadron.agregarContenido(ladronBuscado.obtenerSenia());
		pistaVehiculoLadron.agregarContenido(ladronBuscado.obtenerVehiculo());
		
		pistasLadron.add(pistaCabelloLadron);
		pistasLadron.add(pistaHobbyLadron);
		pistasLadron.add(pistaSeniaLadron);
		pistasLadron.add(pistaVehiculoLadron);
		
		return pistasLadron;
		
	}
	
	public GeneradorDePartidas(Pista juegoGanado, Pista ordenDeArrestoIncorrecta, Pista ordenDeArrestoNoEmitida) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		this.mensajeJuegoGanado = juegoGanado;
		this.mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto = ordenDeArrestoNoEmitida;
		this.mensajeJuegoPerdidoPorOrdenIncorrecta = ordenDeArrestoIncorrecta;
		this.ladronBuscado = null;
				
		ArrayList<Ciudad> listaDeCiudades = new ArrayList<Ciudad>();
		Random generador = new Random();
		int valor;
		
		//Genero la lista de las ciudades que contiene el juego
		
		listaDeCiudades = this.generarListaDeCiudades();
		
		while (listaDeCiudades.size() > 0){
			valor = generador.nextInt(listaDeCiudades.size());
			ciudades.add(listaDeCiudades.get(valor));
			listaDeCiudades.remove(valor);
		}
		this.generarRelacionEntreCiudades();
		this.generarRecorridoLadron();
		this.generarLugaresConPistasALasCiudades();
	}
	
	public ArrayList<Ciudad> obtenerCiudades(){
		return ciudades;
	}
	
	public ArrayList<Ciudad> obtenerRecorridoLadron(){
		return recorridoLadron;
	}
	
	public int obtenerPasoActual(){
		return pasoActual;
	}
	
	private void generarRelacionEntreCiudades(){
		//Compruebo si la cantidad de elementos de la lista de ciudades es par, para que funcione el siguiente algoritmo
		if(ciudades.size() % 2 != 0){
			ciudades.remove(ciudades.size()-1);
		}
		
		//Relaciono la primera ciudad de la lista con la ultima y con la siguiente de la misma
		ciudades.get(0).agregarCiudadAViajar(ciudades.get(1));
		ciudades.get(0).agregarCiudadAViajar(ciudades.get(ciudades.size()-1));
		
		//Relaciono la ultima ciudad de la lista con la primera y con la anterior de la misma
		ciudades.get(ciudades.size()-1).agregarCiudadAViajar(ciudades.get(0));
		ciudades.get(ciudades.size()-1).agregarCiudadAViajar(ciudades.get(ciudades.size()-2));
		
		//Relaciono cada ciudad de la lista con la siguiente
		for (int i=1; i < ciudades.size()-1; i++){
			ciudades.get(i).agregarCiudadAViajar(ciudades.get(i+1));
			ciudades.get(i).agregarCiudadAViajar(ciudades.get(i-1));		
		}
		//Hasta aca cada ciudad tiene dos ciudades a viajar en su lista
		
		//Relaciono cada ciudad con otra ciudad para completar la lista de ciudades a viajar
		for (int i=0; i < (ciudades.size()/2); i++){
			ciudades.get(i).agregarCiudadAViajar(ciudades.get((ciudades.size()/2)+i));
			ciudades.get((ciudades.size()/2)+i).agregarCiudadAViajar(ciudades.get(i));
		}
	}

	private void generarRecorridoLadron(){
		Random generador = new Random();
		
		//Tomo aleatoriamente una ciudad de la lista
		recorridoLadron.add(ciudades.get(generador.nextInt(ciudades.size())));
		
		//Tomo un camino aleatorio para formar el recorrido del ladron
		for (int i=0; i < 5; i++){
			recorridoLadron.add(recorridoLadron.get(i).obtenerCiudadesAViajar().get(0));
		}
	}
	
	public void pasarALaSiguienteCiudadDelRecorrido() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		if(pasoActual < recorridoLadron.size()-2){
			pasoActual++;
			this.generarLugaresConPistasALasCiudades();
		} else {
			this.generarUltimosLugares();
		}
	}
	
	private void generarLugaresConPistasALasCiudades() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		this.generarLugaresSinLadronALasCiudades();
				
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Random generador = new Random();
		
		//Genero los lugares con sus pistas para cada ciudad
		recorridoLadron.get(pasoActual).obtenerLugares().clear();
		
		String nombreSiguienteCiudad = recorridoLadron.get(pasoActual+1).obtenerNombre();
		lugares = this.generarLugaresDeUnaCiudad(nombreSiguienteCiudad);
					
		while (lugares.size() > 3){
			int valor = generador.nextInt(lugares.size());
			lugares.remove(valor);
		}
			
		for(int j=0; j < lugares.size(); j++){
			recorridoLadron.get(pasoActual).obtenerLugares().add(lugares.get(j));
		}
		lugares.clear();
	}
	
	private void generarLugaresSinLadronALasCiudades(){
		Random generador = new Random();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		
		for(int i=0; i < ciudades.size(); i++){
			ciudades.get(i).obtenerLugares().clear();
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
	
	private void generarUltimosLugares() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		//Asigno las acciones de la ultima ciudad
		Random generador = new Random();
		int valor;
		
		ArrayList<String> listaDeLugares = new ArrayList<String>();
		listaDeLugares.add("Aeropuerto");
		listaDeLugares.add("Puerto");
		listaDeLugares.add("Banco");
		listaDeLugares.add("Bolsa");
		listaDeLugares.add("Biblioteca");
		
		ArrayList<ILugar> lugaresSospechosos = new ArrayList<ILugar>();
		
		valor = generador.nextInt(listaDeLugares.size());
		lugaresSospechosos.add(new LugarConLadron(listaDeLugares.get(valor),this.ladronBuscado, this.mensajeJuegoGanado, this.mensajeJuegoPerdidoPorOrdenIncorrecta, this.mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto));
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
	
	public Ladron obtenerLadronBuscado() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		return this.obtenerUnLadronDeLaLista();
	}
}
