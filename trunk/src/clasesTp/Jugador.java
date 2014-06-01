package clasesTp;

public class Jugador {

	private Ciudad ciudad;
	private int tiempo;
	private int velocidad;
	private String cargo;
	
	public Jugador(Ciudad ciudad, int velocidad, int tiempo, String cargo){
		
		this.ciudad = ciudad;
		this.velocidad = velocidad;
		this.tiempo = tiempo;
		this.cargo = cargo;
	}

	public void cambiarDeCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		
	}

	public void viajar(Ciudad ciudad) {
		
		this.tiempo = this.tiempo - this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudad));
		this.cambiarDeCiudad(ciudad);
		
	}

	private int calcularTiempoDeViaje(int distancia) {
	
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

	public String cargo() {
		
		return this.cargo;
	}

}