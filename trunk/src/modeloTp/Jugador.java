package modeloTp;

public class Jugador {

	private Ciudad ciudadActual;
	private int tiempoRestante;
	protected int velocidad;
	
	public Jugador(Ciudad ciudad){
		
		this.ciudadActual = ciudad;
		this.tiempoRestante = 154; 
	}

	private void cambiarDeCiudad(Ciudad ciudad) {
		this.ciudadActual = ciudad;
		
	}

	public void viajar(Ciudad ciudad) throws ExcepcionNoHayMasTiempo {
		
		if( this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudadActual)) >= this.tiempoRestante ) throw new ExcepcionNoHayMasTiempo();
		else this.tiempoRestante = this.tiempoRestante - this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudadActual));
		this.cambiarDeCiudad(ciudad);
		
	}

	private int calcularTiempoDeViaje(int distancia) {
	
		return (int)distancia/this.velocidad;
	}

	public int obtenerTiempoRestante() {
		return this.tiempoRestante;
	}

	public Ciudad obtenerCiudadActual() {
		
		return this.ciudadActual;
	}
} 