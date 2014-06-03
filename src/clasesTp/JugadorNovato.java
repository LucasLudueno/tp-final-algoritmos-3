package clasesTp;

public class JugadorNovato extends Jugador{

	public JugadorNovato(Ciudad ciudad, int velocidad, int tiempo) {
		super(ciudad, velocidad, tiempo);
	}
	
	public String obtenerPistaDe(Aeropuerto aeropuerto) {
		return aeropuerto.devolverPista(this);
	}
}
