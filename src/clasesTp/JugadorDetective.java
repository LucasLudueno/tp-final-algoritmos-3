package clasesTp;

public class JugadorDetective extends Jugador{

	public JugadorDetective(Ciudad ciudad, int velocidad, int tiempo) {
		super(ciudad, velocidad, tiempo);
	}
	
	public String obtenerPistaDe(Aeropuerto aeropuerto) {
		return aeropuerto.devolverPista(this);
	}
}
