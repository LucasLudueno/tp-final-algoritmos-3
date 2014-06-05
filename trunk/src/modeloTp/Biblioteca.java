package modeloTp;

public class Biblioteca extends Lugar {

	public Biblioteca (){
	
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
