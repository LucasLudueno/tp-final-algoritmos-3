package modeloTp;

public class Novato extends Rango{

	public Novato() {
		
		this.velocidad = 190;
	}

	public Pista pedirPista(ILugar lugar, Jugador jugador){
		return lugar.verPistaSegunRango(this, jugador);
	}	
}
