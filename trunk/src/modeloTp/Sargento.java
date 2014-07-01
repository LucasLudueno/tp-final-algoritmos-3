package modeloTp;

public class Sargento extends Rango{

	public Sargento() {
		
		this.velocidad = 4;
	}

	public Pista pedirPista(ILugar lugar, Jugador jugador){
		
		return lugar.verPistaSegunRango(this, jugador);
	}	
}
