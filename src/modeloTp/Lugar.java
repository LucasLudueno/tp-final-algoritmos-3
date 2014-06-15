package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Lugar {
	
	private String nombre;
	private Pista pistaFacil;
	private Pista pistaMedia;
	private Pista pistaDificil;
	private Ladron ladronEscondido;
	
	public Lugar(String nombre, Pista pistaFacil, Pista pistaMedia, Pista pistaDificil, Ladron ladron){
		
		this.nombre = nombre;
		this.pistaFacil = pistaFacil;
		this.pistaMedia = pistaMedia;
		this.pistaDificil = pistaDificil;
		this.ladronEscondido = ladron;

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

	public Ladron obtenerLadron() {
		
		return this.ladronEscondido;
	}

	public Node serializar(Document doc) {
		Element elementoLugar = doc.createElement("Lugar");
		elementoLugar.setAttribute("nombre",this.nombre);
		
		Element elementoPistas = doc.createElement("Pistas");
		elementoLugar.appendChild(elementoPistas);
		elementoPistas.appendChild(pistaFacil.serializar(doc));
		elementoPistas.appendChild(pistaMedia.serializar(doc));
		elementoPistas.appendChild(pistaDificil.serializar(doc));
		
		return elementoLugar;
	}

	public static Lugar cargarEstado(Document doc) {
		Element elementoLugar = (Element) doc.getElementsByTagName("Lugar").item(0);
		String nombre = elementoLugar.getAttribute("nombre");
		
		Element elementoPistas = (Element) doc.getElementsByTagName("Pistas").item(0);
		Pista pistaFacil = Pista.cargarEstado(elementoPistas.getChildNodes().item(0));
		Pista pistaMedia = Pista.cargarEstado(elementoPistas.getChildNodes().item(1));
		Pista pistaDificil = Pista.cargarEstado(elementoPistas.getChildNodes().item(2));
		
		Lugar unLugar = new Lugar(nombre,pistaFacil,pistaMedia,pistaDificil,null);
		
		return unLugar;
	}
	
}
