package modeloTp;

public interface ILugar {

	public Pista devolverPista(JugadorNovato jugador);
	
	public Pista devolverPista(JugadorDetective jugador);
	
	public Pista devolverPista(JugadorInvestigador jugador);
	
	public Pista devolverPista(JugadorSargento jugador);
}
