package modeloTp;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Ciudad {

	private String nombre;
	private int posicion_x;
	private int posicion_y;
	private ArrayList<Lugar> lugares;
	private ArrayList<Ciudad> ciudadesAViajar;
	

	public Ciudad(String nombre, int posicion_x, int posicion_y,Lugar lugar1,Lugar lugar2,Lugar lugar3, ArrayList<Ciudad> ciudadesAViajar){
		
		this.nombre = nombre;
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		this.lugares = new ArrayList<Lugar>();
		this.ciudadesAViajar = ciudadesAViajar;
		
		this.lugares.add(lugar1);
		this.lugares.add(lugar2);
		this.lugares.add(lugar3);
	}

	public String obtenerNombre() {
		return this.nombre;
	} 
	
	public int obtenerPosicion_x() {
		
		return this.posicion_x;
	}


	public int obtenerPosicion_y() {
		
		return this.posicion_y;
	}


	public int obtenerDistancia(Ciudad ciudad) {
		
		int diferencia_x = (this.posicion_x - ciudad.posicion_x)*(this.posicion_x - ciudad.posicion_x);
		int diferencia_y = (this.posicion_y - ciudad.posicion_y)*(this.posicion_y - ciudad.posicion_y);
		
		return (int) Math.sqrt(diferencia_x + diferencia_y);
						
	}

	public int cantidadLugares() {
		return this.lugares.size();
	}

	public Pista obtenerPista(Jugador jugador, Lugar lugar) {
		
		if (this.lugares.contains(lugar) == true){
			jugador.restarTiempoPorEntrarALugar();
			return ((this.lugares.get(this.lugares.indexOf(lugar))).devolverPista((JugadorNovato) jugador));
		}
		return null;
	}

	public ArrayList<Lugar> obtenerLugares() {
		
		return this.lugares;
	}	
	
	public ArrayList<Ciudad> obtenerCiudadesAViajar() {
		
		return this.ciudadesAViajar;
	}

	public Node serializar(Document doc) {
		Element elementoCiudad = doc.createElement("Ciudad");
		elementoCiudad.setAttribute("nombre",this.nombre);
		elementoCiudad.setAttribute("posicion_x",String.valueOf(this.posicion_x));
		elementoCiudad.setAttribute("posicion_y",String.valueOf(this.posicion_y));
		
		Element elementoLugares = doc.createElement("Lugares");
		elementoCiudad.appendChild(elementoLugares);
		for (int i = 0 ; i < lugares.size() ; i++){
			elementoLugares.appendChild(lugares.get(i).serializar(doc));
		}
		
		return elementoCiudad;
	}

	public static Ciudad cargarEstado(Element elementoCiudad) {
		String nombre = elementoCiudad.getAttribute("nombre");
		int posicion_x = Integer.valueOf(elementoCiudad.getAttribute("posicion_x"));
		int posicion_y = Integer.valueOf(elementoCiudad.getAttribute("posicion_y"));
		
		Element elementoLugares = (Element)elementoCiudad.getElementsByTagName("Lugares").item(0);
		Lugar lugarUno = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(0));
		Lugar lugarDos = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(1));
		Lugar lugarTres = Lugar.cargarEstado((Element) elementoLugares.getChildNodes().item(2));
		
		Ciudad unaCiudad = new Ciudad(nombre,posicion_x,posicion_y,lugarUno,lugarDos,lugarTres,null);
		
		return unaCiudad;
	}
}