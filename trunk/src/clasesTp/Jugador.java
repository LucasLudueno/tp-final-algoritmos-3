package clasesTp;

public class Jugador {

	private Ciudad ciudad;
	private int tiempo;
	private int velocidad;
	
	public Jugador(Ciudad ciudad, int velocidad, int tiempo){
		
		this.ciudad = ciudad;
		this.velocidad = velocidad;
		this.tiempo = tiempo;
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

	public int obtenerTiempoRestante() {
		return this.tiempo;
	}

	public Ciudad obtenerCiudadActual() {
		
		return this.ciudad;
	}

} 