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
	private int pasoActualSobreLadron = 0; //Esta variable indica la cantidad de ciudades que el jugador a visitado y habia pasado el ladron
	private Ladron ladronBuscado;
	private Pista mensajeJuegoGanado;
	private Pista mensajeJuegoPerdidoPorOrdenIncorrecta;
	private Pista mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto;
	private ArrayList<Pista> pistasSobreLadron;
	
	
	public GeneradorDePartidas(Pista juegoGanado, Pista ordenDeArrestoIncorrecta, Pista ordenDeArrestoNoEmitida) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		this.mensajeJuegoGanado = juegoGanado;
		this.mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto = ordenDeArrestoNoEmitida;
		this.mensajeJuegoPerdidoPorOrdenIncorrecta = ordenDeArrestoIncorrecta;
		this.ladronBuscado = this.obtenerUnLadronDeLaLista();
		this.pistasSobreLadron = this.generarPistasDelLadron();
		
		ArrayList<Ciudad> listaDeCiudades = new ArrayList<Ciudad>();
		Random generadorRandom = new Random();
		int posicionEnLista;
		
		//Genero la lista de las ciudades que contiene el juego de manera al azar
		
		listaDeCiudades = this.generarListaDeCiudades();
		
		while (listaDeCiudades.size() > 0){
			posicionEnLista = generadorRandom.nextInt(listaDeCiudades.size());
			ciudades.add(listaDeCiudades.get(posicionEnLista));
			listaDeCiudades.remove(posicionEnLista);
		}
		this.generarRelacionEntreCiudades();
		this.generarRecorridoLadron();
		this.asignarLugaresConPistasUtilesALaProximaCiudadDelRecorridoDelLadron();
	}
	
	public ArrayList<Ciudad> obtenerCiudades(){
		return ciudades;
	}
	
	public ArrayList<Ciudad> obtenerRecorridoLadron(){
		return recorridoLadron;
	}
	
	public int obtenerPasoActual(){
		return pasoActualSobreLadron;
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
		Random generadorRandom = new Random();
		
		//Tomo aleatoriamente una ciudad de la lista
		recorridoLadron.add(ciudades.get(generadorRandom.nextInt(ciudades.size())));
		
		//Tomo un camino aleatorio para formar el recorrido del ladron
		for (int i=0; i < 5; i++){
			recorridoLadron.add(recorridoLadron.get(i).obtenerCiudadesAViajar().get(0));
		}
	}
		
	public void pasarALaSiguienteCiudadDelRecorrido() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		if(pasoActualSobreLadron < recorridoLadron.size()-2){
			pasoActualSobreLadron++;
			this.asignarLugaresConPistasUtilesALaProximaCiudadDelRecorridoDelLadron();
		} else {
			this.generarUltimosLugares();
		}
	}
	
	private void asignarLugaresConPistasUtilesALaProximaCiudadDelRecorridoDelLadron() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		this.asignarLugaresPorLosCualesNoPasoElLadron();
				
		ArrayList<Lugar> lugaresConPistasUtiles = new ArrayList<Lugar>();
		Random generadorRandom = new Random();
		
		//Genero los lugares con sus pistas para cada ciudad
		recorridoLadron.get(pasoActualSobreLadron).obtenerLugares().clear();
		
		String nombreSiguienteCiudad = recorridoLadron.get(pasoActualSobreLadron+1).obtenerNombre();
		lugaresConPistasUtiles = this.generarLugaresDeUnaCiudad(nombreSiguienteCiudad);
					
		while (lugaresConPistasUtiles.size() > 3){
			int posicionEnLista = generadorRandom.nextInt(lugaresConPistasUtiles.size());
			lugaresConPistasUtiles.remove(posicionEnLista);
		}
			
		//Asigno una pista del ladron
		if (this.pistasSobreLadron.size() > 0){
			int posicionEnListaDeLugares = generadorRandom.nextInt(lugaresConPistasUtiles.size());
			int posicionEnListaDePistasSobreLadron = generadorRandom.nextInt(this.pistasSobreLadron.size());
			Pista pistaSobreLadron = this.pistasSobreLadron.get(posicionEnListaDePistasSobreLadron);
			lugaresConPistasUtiles.get(posicionEnListaDeLugares).reemplazarPistas( pistaSobreLadron );
			this.pistasSobreLadron.remove(posicionEnListaDePistasSobreLadron);
		}
		
		// asigno los lugares a la ciudad actual del recorrido del ladron
		for(int j=0; j < lugaresConPistasUtiles.size(); j++){
			recorridoLadron.get(pasoActualSobreLadron).agregarLugar(lugaresConPistasUtiles.get(j));
		}
		lugaresConPistasUtiles.clear();
	}
	
	private void asignarLugaresPorLosCualesNoPasoElLadron() throws ParserConfigurationException, SAXException, IOException{
		Random generadorRandom = new Random();
		ArrayList<Lugar> lugaresSinPistasUtiles = new ArrayList<Lugar>();
		
		for(int i=0; i < this.ciudades.size(); i++){
			this.ciudades.get(i).obtenerLugares().clear();
			lugaresSinPistasUtiles = this.generarLugaresPorLosCualesNoPasoElLadron();
	        	
			while (lugaresSinPistasUtiles.size() > 3){
				int valor = generadorRandom.nextInt(lugaresSinPistasUtiles.size());
				lugaresSinPistasUtiles.remove(valor);
	        
			}
			
        	for(int j=0; j < lugaresSinPistasUtiles.size(); j++){
        		this.ciudades.get(i).obtenerLugares().add(lugaresSinPistasUtiles.get(j));
        	}
		}	
        lugaresSinPistasUtiles.clear();
	}
	
	
	private ArrayList<Lugar> generarLugaresPorLosCualesNoPasoElLadron() throws ParserConfigurationException, SAXException, IOException{
		File archivo = new File("Lugares sin pistas utiles.xml");
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Element elementoLugares = (Element)doc.getElementsByTagName("LugaresSinPistasUtiles").item(0);						
		ArrayList<Lugar> listaDeLugares = new ArrayList<Lugar>();
		
		int i = 0;
		while (elementoLugares.getChildNodes().item(i) != null){
			Lugar lugar = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(i));
			listaDeLugares.add( lugar );
			i = i + 1;
		}
		
		return listaDeLugares;
		
	}
	
	
	private void generarUltimosLugares() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		Random generadorRandom = new Random();
		int posicion;
		
		ArrayList<String> nombresDeLugares = new ArrayList<String>();
		nombresDeLugares.add("Aeropuerto");
		nombresDeLugares.add("Puerto");
		nombresDeLugares.add("Banco");
		nombresDeLugares.add("Bolsa");
		nombresDeLugares.add("Biblioteca");
		
		ArrayList<ILugar> lugaresSospechosos = new ArrayList<ILugar>();
		
		posicion = generadorRandom.nextInt(nombresDeLugares.size());
		lugaresSospechosos.add(new LugarConLadron(nombresDeLugares.get(posicion),this.ladronBuscado, this.mensajeJuegoGanado, this.mensajeJuegoPerdidoPorOrdenIncorrecta, this.mensajeJuegoPerdidoPorNoEmitirOrdenDeArresto));
		nombresDeLugares.remove(posicion);
		
		posicion = generadorRandom.nextInt(nombresDeLugares.size());
		lugaresSospechosos.add(new LugarDondeAcuchillan(nombresDeLugares.get(posicion)));
		nombresDeLugares.remove(posicion);
		
		posicion = generadorRandom.nextInt(nombresDeLugares.size());
		lugaresSospechosos.add(new LugarDondeDisparan(nombresDeLugares.get(posicion)));
		
		//Asigno los lugares a la ultima ciudad del recorrido
		recorridoLadron.get(recorridoLadron.size()-1).obtenerLugares().clear();
		while(lugaresSospechosos.size()>0){
			posicion = generadorRandom.nextInt(lugaresSospechosos.size());
			recorridoLadron.get(recorridoLadron.size()-1).agregarLugar(lugaresSospechosos.get(posicion));
			lugaresSospechosos.remove(posicion);			
		}
	}
	
	
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
		
		Element elementoLugares = (Element)doc.getElementsByTagName("Lugares").item(0);						
		
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		
		int i = 0;
		while (elementoLugares.getChildNodes().item(i) != null){
			Lugar lugar = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(i));
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
		return ladronBuscado;
	}
}
