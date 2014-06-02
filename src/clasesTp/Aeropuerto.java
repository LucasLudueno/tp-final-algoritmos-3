package clasesTp;

public class Aeropuerto implements Lugar {

	private String pistaFacil;
	private String pistaMedio;

	public Aeropuerto (){
		
		this.pistaFacil = "a";
		this.pistaMedio = "b";

	}
	
	public String obtenerPistaFacil(){  /* CONSIDERO QUE ESTE METODO NO VA */
		return this.pistaFacil;
	}
	
	public String obtenerPistaMedio(){ /* CONSIDERO QUE ESTE METODO NO VA */
		return this.pistaFacil;
	}
	
	public String devolverPista(JugadorNovato jugador) {
		
		return this.pistaFacil;
	}
	
	public String devolverPista(JugadorDetective jugador){
		
		return this.pistaMedio;
	}

	@Override
	public Pista obtenerPista() {
		return new Pista();
	}	
}
