package modeloTp;

public class Bolsa extends Lugar {

	public Bolsa (){
	
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

