package modeloTp;

import java.util.ArrayList;

/*
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
*/

public class Jugador {

	private Ciudad ciudadActual;
	private int tiempoRestante;
	private int tiempoPorEntrarALugar;
	private int tiempoPorHeridaDeCuchillo;
	private int tiempoPorHeridaDeBala;
	private int tiempoPorDormir;
	private int tiempoEmitirOrdenDeArresto;
	private String nombreDelLadronBuscado;
	private ComputadoraPolicial computadoraPolicial;
	private int cantidadDeArrestos;
	private Rango rangoActual;
	
	
	public Jugador(Ciudad ciudad, ComputadoraPolicial computadoraPolicial){
		
		this.ciudadActual = ciudad;
		this.tiempoRestante = 154; 
		this.tiempoPorEntrarALugar = 1;
		this.tiempoPorHeridaDeCuchillo = 2;
		this.tiempoPorHeridaDeBala = 4;
		this.tiempoPorDormir = 8;
		this.tiempoEmitirOrdenDeArresto = 3;
		this.computadoraPolicial = computadoraPolicial;
		this.cantidadDeArrestos = 0;
		this.nombreDelLadronBuscado = null;
		this.rangoActual = new Novato();
	}

	public void agregarArresto(){
		
		this.cantidadDeArrestos = this.cantidadDeArrestos + 1;
		this.actualizarRango();
		
	}
	
	private void actualizarRango() {
		
		if(this.cantidadDeArrestos < 5) this.rangoActual = new Novato();
		else if(this.cantidadDeArrestos < 10) this.rangoActual = new Detective();
		else if(this.cantidadDeArrestos < 20) this.rangoActual = new Investigador();
		else this.rangoActual = new Sargento();
		
	}

	public int obtenerCantidadDeArrestos(){
		
		return this.cantidadDeArrestos;
	}
	
	public void restarTiempoPorEntrarALugar(){
		reducirTiempo(tiempoPorEntrarALugar);
		
		if (this.tiempoPorEntrarALugar < 3){
			this.tiempoPorEntrarALugar = this.tiempoPorEntrarALugar + 1;
		}
	}
	
	
	private void cambiarDeCiudad(Ciudad ciudad) {
		this.ciudadActual = ciudad;
		
	}

	public void viajar(Ciudad ciudad) throws ExcepcionNoHayMasTiempo {
		
		if( this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudadActual)) >= this.tiempoRestante ) throw new ExcepcionNoHayMasTiempo();
		else this.tiempoRestante = this.tiempoRestante - this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudadActual));
		this.cambiarDeCiudad(ciudad);
		this.tiempoPorEntrarALugar = 1;
		
	}

	private int calcularTiempoDeViaje(int distancia) {
	
		return (int)distancia/this.rangoActual.obtenerVelocidad();
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
	
	public boolean emitirOrdenDeArresto(String sexo, String hobby, String cabello,  String senia, String vehiculo){
		
		reducirTiempo( this.tiempoEmitirOrdenDeArresto);
		ArrayList<Ladron> posiblesLadrones = this.computadoraPolicial.buscarPosiblesLadrones(sexo, hobby, cabello, senia, vehiculo);
		
		if (posiblesLadrones.size() == 1){
			this.nombreDelLadronBuscado = ( (Ladron)posiblesLadrones.get(0) ).obtenerNombre();
			
			return true;
		}
	
		return false;
	}
	
	private void reducirTiempo( Integer tiempo ){
		
		if( this.tiempoRestante <= tiempo){
			tiempoRestante = 0;
		} else {
			this.tiempoRestante = this.tiempoRestante - tiempo;
		}
	}
	
	public String obtenerNombreDeLadronBuscado() {
		
		return this.nombreDelLadronBuscado;
	}

	public boolean seEmitioOrdenDeArresto() {
		return (this.nombreDelLadronBuscado != null);
	}

	public Rango obtenerRango() {
		
		return this.rangoActual;
	}

	/*
	public Node serializar(Document doc) {
		Element elementoJugador = doc.createElement("Jugador");
		elementoJugador.setAttribute("velocidad", String.valueOf(this.velocidad));
		
		Element elementoCiudadActual = doc.createElement("CiudadActual");
		elementoJugador.appendChild(elementoCiudadActual);
		elementoCiudadActual.appendChild(this.ciudadActual.serializar(doc));
		
		Element elementoComputadora = doc.createElement("ComputadoraPolicial");
		elementoJugador.appendChild(elementoComputadora);
		elementoComputadora.appendChild(this.computadoraPolicial.serializar(doc));
		
		return elementoJugador;
	}

	public static Jugador cargarEstado(Document doc) {
		Element elementoCiudadActual = (Element) doc.getElementsByTagName("CiudadActual").item(0);
		Ciudad ciudadActual = Ciudad.cargarEstado((Element) elementoCiudadActual.getChildNodes().item(0));
		
		Element elementoComputadora = (Element) doc.getElementsByTagName("ComputadoraPolicial").item(0);
		ComputadoraPolicial unaComputadora = ComputadoraPolicial.cargarEstado((Element) elementoComputadora.getChildNodes().item(0));
		
		Jugador unJugador = new Jugador(ciudadActual,unaComputadora);
		
		Element elementoJugador = (Element) doc.getElementsByTagName("Jugador").item(0);
		unJugador.velocidad = Integer.valueOf(elementoJugador.getAttribute("velocidad"));
		
		return unJugador;
	}
	*/
} 