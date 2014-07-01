package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface ILugar {
	
	public Pista verPistaSegunRango(Novato rango, Jugador jugador);
	
	public Pista verPistaSegunRango(Detective rango, Jugador jugador);
	
	public Pista verPistaSegunRango(Investigador rango, Jugador jugador);
	
	public Pista verPistaSegunRango(Sargento rango, Jugador jugador);
	
	public Node serializar(Document doc);
	
	public String obtenerNombre();
}
