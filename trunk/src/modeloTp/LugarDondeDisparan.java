package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeDisparan implements ILugar{
	
	@SuppressWarnings("unused")
	private String nombre;
	
	public LugarDondeDisparan(String unNombre){
		this.nombre = unNombre;
	}

	public Pista devolverPista(JugadorNovato jugador) {
		jugador.recibirBalazo();
		return null;
	}
		
	public Pista  devolverPista(JugadorDetective jugador){	
		jugador.recibirBalazo();
		return null;
	}
	
	public Pista  devolverPista(JugadorInvestigador jugador){	
		jugador.recibirBalazo();
		return null;
	}
		
	public Pista  devolverPista(JugadorSargento jugador){	
		jugador.recibirBalazo();
		return null;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}
