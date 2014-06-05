package modeloTp;

public class JugadorDetective extends Jugador{

	public JugadorDetective(Ciudad ciudad) {
		super(ciudad);
		this.cambiarVelocidad();
	}

	private void cambiarVelocidad() {
		this.velocidad = 2;
		
	}
	
}
