package modeloTp;

abstract class Lugar {
	
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	
	abstract String devolverPista(JugadorNovato jugador);
	abstract String devolverPista(JugadorDetective jugador);
	
}
