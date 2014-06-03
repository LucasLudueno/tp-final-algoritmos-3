package clasesTp;

public class Aeropuerto {

	private String pistaFacil;
	private String pistaMedio;

	public Aeropuerto (){
		
		this.pistaFacil = "a";
		this.pistaMedio = "b";

	}
	
	public String devolverPista(JugadorNovato jugador) {
		return this.pistaFacil;
	}
	
	public String devolverPista(JugadorDetective jugador){	
		return this.pistaMedio;
	}
}
