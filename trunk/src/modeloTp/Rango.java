package modeloTp;

public abstract class Rango {
	
	protected String nombre;
	protected int velocidad;

	public abstract Pista pedirPista(ILugar iLugar, Jugador jugador);

	public int obtenerVelocidad() {
		
		return this.velocidad;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}


}
