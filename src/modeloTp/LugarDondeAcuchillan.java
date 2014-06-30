package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeAcuchillan implements ILugar{

	private String nombre;
	private Pista avisoCuchillazo;
	
	public LugarDondeAcuchillan(String unNombre){
		this.nombre = unNombre;
		this.avisoCuchillazo = new Pista( "Has recibido un cuchillazo, el ladron no ha pasado por aqui" );
	}
	
	public Pista devolverPista(JugadorNovato jugador) {
		
		jugador.recibirCuchillazo();
		return this.avisoCuchillazo;
	}
		
	public Pista  devolverPista(JugadorDetective jugador){	
		jugador.recibirCuchillazo();
		return this.avisoCuchillazo;
	}
	
	public Pista  devolverPista(JugadorInvestigador jugador){	
		jugador.recibirCuchillazo();
		return this.avisoCuchillazo;
	}
		
	public Pista  devolverPista(JugadorSargento jugador){	
		jugador.recibirCuchillazo();
		return this.avisoCuchillazo;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String obtenerNombre() {
		
		return this.nombre;
	}
		
}
