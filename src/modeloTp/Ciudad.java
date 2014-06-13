package modeloTp;

import java.util.ArrayList;


public class Ciudad {

	private String nombre;
	private int posicion_x;
	private int posicion_y;
	private ArrayList<Lugar> lugares;
	

	public Ciudad(String nombre, int posicion_x, int posicion_y,Lugar lugar1,Lugar lugar2,Lugar lugar3){
		
		this.nombre = nombre;
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		this.lugares = new ArrayList<Lugar>();
		
		this.lugares.add(lugar1);
		this.lugares.add(lugar2);
		this.lugares.add(lugar3);
	}

	public String obtenerNombre() { /* CONSIDERO QUE ESTE METODO NO VA, POR LO MENOS POR AHORA */
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
	
}