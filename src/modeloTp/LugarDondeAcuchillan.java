package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeAcuchillan implements ILugar{
	
	public Pista devolverPista(JugadorNovato jugador) {
		jugador.recibirCuchillazo();
		return null;
	}
		
	public Pista  devolverPista(JugadorDetective jugador){	
		jugador.recibirCuchillazo();
		return null;
	}
	
	public Pista  devolverPista(JugadorInvestigador jugador){	
		jugador.recibirCuchillazo();
		return null;
	}
		
	public Pista  devolverPista(JugadorSargento jugador){	
		jugador.recibirCuchillazo();
		return null;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
