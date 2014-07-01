package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeDisparan implements ILugar{
	
	private String nombre;
	private Pista avisoDisparo;
	
	public LugarDondeDisparan(String unNombre){
		this.nombre = unNombre;
		this.avisoDisparo = new Pista( "Has recibido un disparo, en este lugar no esta el ladron" );

	}

	
	public Pista verPistaSegunRango(Novato rango, Jugador jugador) {
		jugador.recibirBalazo();
		return this.avisoDisparo;
	}
	
	public Pista verPistaSegunRango(Detective rango, Jugador jugador) {
		jugador.recibirBalazo();
		return this.avisoDisparo;
	}
	
	public Pista verPistaSegunRango(Investigador rango, Jugador jugador) {
		jugador.recibirBalazo();
		return this.avisoDisparo;
	}
	
	public Pista verPistaSegunRango(Sargento rango, Jugador jugador) {
		jugador.recibirBalazo();
		return this.avisoDisparo;
	}
	
	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String obtenerNombre(){
		
		return this.nombre;
	}
	
}
