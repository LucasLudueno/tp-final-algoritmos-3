package modeloTp;

public class JugadorNovato extends Jugador{

	public JugadorNovato(Ciudad ciudad) {
		super(ciudad);
		this.cambiarVelocidad();
	}

	private void cambiarVelocidad() {
		this.velocidad = 1;
	}
}
