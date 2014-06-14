package modeloTp;

import java.util.ArrayList;

public class Jugador {

	private Ciudad ciudadActual;
	private int tiempoRestante;
	private int tiempoPorEntrarALugar;
	private int tiempoPorHeridaDeCuchillo;
	private int tiempoPorHeridaDeBala;
	private int tiempoPorDormir;
	private int tiempoEmitirOrdenDeArresto;
	private ComputadoraPolicial computadoraPolicial;
	protected int velocidad;
	
	
	public Jugador(Ciudad ciudad, ComputadoraPolicial computadoraPolicial){
		
		this.ciudadActual = ciudad;
		this.tiempoRestante = 154; 
		this.tiempoPorEntrarALugar = 1;
		this.tiempoPorHeridaDeCuchillo = 2;
		this.tiempoPorHeridaDeBala = 4;
		this.tiempoPorDormir = 8;
		this.tiempoEmitirOrdenDeArresto = 3;
		this.computadoraPolicial = computadoraPolicial;
	}

	public void restarTiempoPorEntrarALugar(){
		reducirTiempo(tiempoPorEntrarALugar);
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
		
		reducirTiempo(tiempoPorHeridaDeCuchillo);
		
	}

	public void recibirBalazo() {
		
		reducirTiempo(tiempoPorHeridaDeBala);
	}

	public void dormir() {
		
		reducirTiempo(tiempoPorDormir);
		
	}
	
	public Ladron emitirOrdenDeArresto(String sexo, String hobby, String cabello,  String senia, String vehiculo){
		
		reducirTiempo( this.tiempoEmitirOrdenDeArresto);
		ArrayList<Ladron> posiblesLadrones = this.computadoraPolicial.buscarPosiblesLadrones(sexo, hobby, cabello, senia, vehiculo);
		
		if (posiblesLadrones.size() == 1){
			return posiblesLadrones.get(0);
		}
		return null;
	}
	
	private void reducirTiempo( Integer tiempo ){
		
		this.tiempoRestante = this.tiempoRestante - tiempo;
	}
	
	
} 