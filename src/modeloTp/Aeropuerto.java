package modeloTp;

public class Aeropuerto extends Lugar {

	private Pista pistaFacil;
	private Pista pistaMedio;

	public Aeropuerto (){
		
		this.pistaFacil = new Pista("a");
		this.pistaMedio = new Pista("b");

	}
	
	public String devolverPista(JugadorNovato jugador) {
		return this.pistaFacil.obtenerContenido();
	}
	
	public String devolverPista(JugadorDetective jugador){	
		return this.pistaMedio.obtenerContenido();
	}
}
