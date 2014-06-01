package clasesTp;

public class Ciudad {

	private String nombre;
	private int posicion_x;
	private int posicion_y;
	
	
	public Ciudad(String nombre, int posicion_x, int posicion_y){
		
		this.nombre = nombre;
		this.posicion_x = posicion_x;
		this.posicion_y = posicion_y;
		
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

}