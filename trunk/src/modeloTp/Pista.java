package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Pista {
	
	private String contenido;
	
	public Pista(String unTexto) {
		this.contenido = unTexto;
	}

	public String obtenerContenido() {
		return this.contenido;
	}

	public Element serializar(Document doc) {
		Element element = doc.createElement("Pista");
		element.setAttribute("contenido", this.contenido);
		return element;
	}

	public static Pista cargarEstado(Document doc) {
		Pista nuevaPista = new Pista("");
		Element elementoPista = (Element)doc.getElementsByTagName("Pista").item(0);
		nuevaPista.contenido = elementoPista.getAttribute("contenido");
		return nuevaPista;
	}
	
}
