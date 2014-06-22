package modeloTp;

import org.w3c.dom.Document;
//import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface ILugar {

	public Pista devolverPista(JugadorNovato jugador);
	
	public Pista devolverPista(JugadorDetective jugador);
	
	public Pista devolverPista(JugadorInvestigador jugador);
	
	public Pista devolverPista(JugadorSargento jugador);
	
	public Node serializar(Document doc);
	
}
