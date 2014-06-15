package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Pista {
	
	private String contenido;
	
	public Pista(String unTexto) {
		this.contenido = unTexto;
	}

	public String obtenerContenido() {
		return this.contenido;
	}

	public Node serializar(Document doc) {
		Element element = doc.createElement("Pista");
		element.setAttribute("contenido", this.contenido);
		return element;
	}

	public static Pista cargarEstado(Node elementoPista) {
		Pista nuevaPista = new Pista("");
		nuevaPista.contenido = ((Element)elementoPista).getAttribute("contenido");
		return nuevaPista;
	}
	
}
