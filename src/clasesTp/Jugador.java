package clasesTp;

public class Jugador {

	private Ciudad ciudad;
	private int tiempo;
	private int velocidad;
	private String nivel;
	
	public Jugador(Ciudad ciudad, int velocidad, int tiempo, String nivel){
		
		this.ciudad = ciudad;
		this.velocidad = velocidad;
		this.tiempo = tiempo;
		this.nivel = nivel;
	}

	public void introducirCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		
	}

	public void viajar(Ciudad ciudad) {
		
		this.tiempo = this.tiempo - this.calculoDeTiempo(ciudad.distancia(this.ciudad));
		this.introducirCiudad(ciudad);
		
	}

	private int calculoDeTiempo(int distancia) {
	
		return (int)distancia/this.velocidad;
	}

	public int tiempo() {
		return this.tiempo;
	}

	public Ciudad ciudad() {
		
		return this.ciudad;
	}

	public int velocidad() {
		
		return this.velocidad;
	}

	public String nivel() {
		
		return this.nivel;
	}

}
