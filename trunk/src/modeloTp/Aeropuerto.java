package modeloTp;

public class Aeropuerto extends Lugar {

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
