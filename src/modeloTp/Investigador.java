package modeloTp;

public class Investigador extends Rango{

	public Investigador() {
		
		this.nombre = "Investigador";
		this.velocidad = 1300;
	}

	public Pista pedirPista(ILugar lugar,Jugador jugador){
		
		return lugar.verPistaSegunRango(this,jugador);
	}	
}
