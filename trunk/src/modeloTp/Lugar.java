package modeloTp;

abstract class Lugar {
	
	protected Pista pistaFacil;
	protected Pista pistaMedio;
	
	abstract String devolverPista(JugadorNovato jugador);
	abstract String devolverPista(JugadorDetective jugador);
	
}
