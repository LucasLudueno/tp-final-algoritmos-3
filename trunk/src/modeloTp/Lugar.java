package modeloTp;

public class Lugar {
	
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
}
