package modeloTp;

public class Detective extends Rango{

	public Detective() {
		
		this.nombre = "Detective";
		this.velocidad = 1100;
	}
	
	public Pista pedirPista(ILugar lugar, Jugador jugador){
		
		return lugar.verPistaSegunRango(this,jugador);
	}	
}
