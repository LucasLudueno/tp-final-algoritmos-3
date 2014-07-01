package modeloTp;

public class Detective extends Rango{

	public Detective() {
		
		this.velocidad = 2;
	}
	
	public Pista pedirPista(ILugar lugar, Jugador jugador){
		
		return lugar.verPistaSegunRango(this,jugador);
	}	
}
