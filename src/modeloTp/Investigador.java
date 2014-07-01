package modeloTp;

public class Investigador extends Rango{

	public Investigador() {
		
		this.velocidad = 3;
	}

	public Pista pedirPista(ILugar lugar,Jugador jugador){
		
		return lugar.verPistaSegunRango(this,jugador);
	}	
}
