package modeloTp;

public class JugadorDetective extends Jugador{

	public JugadorDetective(Ciudad ciudad, ComputadoraPolicial computadoraPolicial) {
		super(ciudad, computadoraPolicial);
		this.velocidad = 2;
	}
	
}
