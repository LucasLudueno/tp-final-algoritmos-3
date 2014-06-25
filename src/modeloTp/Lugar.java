package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Lugar implements ILugar{
	
	private String nombre;
	private Pista pistaFacil;
	private Pista pistaMedia;
	private Pista pistaDificil;
	
	public Lugar(String nombre, Pista pistaFacil, Pista pistaMedia, Pista pistaDificil){
		
		this.nombre = nombre;
		this.pistaFacil = pistaFacil;
		this.pistaMedia = pistaMedia;
		this.pistaDificil = pistaDificil;

	}
	
	public Pista devolverPista(JugadorNovato jugador) {
		return this.pistaFacil;
	}
	
	public Pista devolverPista(JugadorDetective jugador){	
		return this.pistaMedia;
	}
	
	public Pista devolverPista(JugadorInvestigador jugador){	
		return this.pistaMedia;
	}
	
	public Pista devolverPista(JugadorSargento jugador){	
		return this.pistaDificil;
	}

	public String obtenerNombre() {
		
		return this.nombre;
	}

	public Node serializar(Document doc) {
		Element elementoLugar = doc.createElement("Lugar");
		elementoLugar.setAttribute("nombre",this.nombre);
		
		Element elementoPistas = doc.createElement("Pistas");
		elementoLugar.appendChild(elementoPistas);
		elementoPistas.appendChild(pistaFacil.serializar(doc));
		elementoPistas.appendChild(pistaMedia.serializar(doc));
		elementoPistas.appendChild(pistaDificil.serializar(doc));
		
		Element elementoLadron = doc.createElement("LadronEscondido");
		elementoLugar.appendChild(elementoLadron);
		
		return elementoLugar;
	}

	public static Lugar cargarEstado(Element elementoLugar) {
		String nombre = elementoLugar.getAttribute("nombre");
		
		Element elementoPistas = (Element)elementoLugar.getElementsByTagName("Pistas").item(0);
		Pista pistaFacil = Pista.cargarEstado(elementoPistas.getChildNodes().item(0));
		Pista pistaMedia = Pista.cargarEstado(elementoPistas.getChildNodes().item(1));
		Pista pistaDificil = Pista.cargarEstado(elementoPistas.getChildNodes().item(2));
		
		return new Lugar(nombre,pistaFacil,pistaMedia,pistaDificil);
	}
	
}