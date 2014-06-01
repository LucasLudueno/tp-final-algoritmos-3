package clasesTp;

public class Aeropuerto {

	private String pistaFacil;
	private String pistaMedio;
	private String pistaDificil;

	public Aeropuerto (){
		
		this.pistaFacil = "a";
		this.pistaMedio = "b";
		this.pistaDificil = "c";

	}
	
	public String obtenerPistaFacil() {
			
		return this.pistaFacil;
	}
	
	public String obtenerPistaMedio() {
		
		return this.pistaMedio;
	}
	
	public String obtenerPistaDificil() {
		
		return this.pistaDificil;
	}

	public String devolverPista(Jugador jugador) {
		
		if (jugador.cargo() == "novato") return this.obtenerPistaFacil();
		if (jugador.cargo() == "detective") return this.obtenerPistaDificil();
		return null;
	}
}
