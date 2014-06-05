package modeloTp;

public class Jugador {

	private Ciudad ciudad;
	private int tiempo;
	protected int velocidad;
	
	public Jugador(Ciudad ciudad){
		
		this.ciudad = ciudad;
		this.tiempo = 24;
	}

	private void cambiarDeCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		
	}

	public void viajar(Ciudad ciudad) throws ExcepcionNoHayMasTiempo {
		
		if( this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudad)) >= this.tiempo ) throw new ExcepcionNoHayMasTiempo();
		else this.tiempo = this.tiempo - this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudad));
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