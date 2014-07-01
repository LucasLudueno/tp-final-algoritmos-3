package modeloTp;

public class Sargento extends Rango{

	public Sargento() {
		
		this.nombre = "Sargento";
		this.velocidad = 1500;
	}

	public Pista pedirPista(ILugar lugar, Jugador jugador){
		
		return lugar.verPistaSegunRango(this, jugador);
	}	
}
