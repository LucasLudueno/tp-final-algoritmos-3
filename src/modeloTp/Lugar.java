package modeloTp;

abstract class Lugar {
	
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	protected Pista pistaDificil;
	
	abstract Pista devolverPista(JugadorNovato jugador);
	abstract Pista devolverPista(JugadorDetective jugador);
	abstract Pista devolverPista(JugadorInvestigador jugador);
	abstract Pista devolverPista(JugadorSargento jugador);
	
}
