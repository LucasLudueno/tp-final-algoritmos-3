package modeloTp;

public class Jugador {

	private Ciudad ciudadActual;
	private int tiempoRestante;
	private int tiempoPorEntrarALugar;
	private int tiempoPorHeridaDeCuchillo;
	private int tiempoPorHeridaDeBala;
	protected int velocidad;
	
	public Jugador(Ciudad ciudad){
		
		this.ciudadActual = ciudad;
		this.tiempoRestante = 154; 
		this.tiempoPorEntrarALugar = 1;
		this.tiempoPorHeridaDeCuchillo = 2;
		this.tiempoPorHeridaDeBala = 4;
	}

	public void restarTiempoPorEntrarALugar(){
		this.tiempoRestante = this.tiempoRestante - this.tiempoPorEntrarALugar ;
		this.tiempoPorEntrarALugar = this.tiempoPorEntrarALugar + 1;
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

	public void recibirCuchillazo() {
		
		this.tiempoRestante = this.tiempoRestante - this.tiempoPorHeridaDeCuchillo;
		
	}

	public void recibirBalazo() {
		
		this.tiempoRestante = this.tiempoRestante - this.tiempoPorHeridaDeBala;
	}
} 