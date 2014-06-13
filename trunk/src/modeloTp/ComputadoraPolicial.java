package modeloTp;

import java.util.ArrayList;

public class ComputadoraPolicial {

	private String sexoLadron;
	private String cabelloLadron;
	private String hobbyLadron;
	private String seniaLadron;
	private String vehiculoLadron;
	private ArrayList<Ladron> sospechosos;
	
	public ComputadoraPolicial(){
	
		this.sospechosos = new ArrayList<Ladron>();
	}
	
	public String obtenerSexoLadron() {
		
		return this.sexoLadron;
	}

	public String obtenerHobbyLadron() {
		
		return this.hobbyLadron;
	}

	public String obtenerCabelloLadron() {
		
		return this.cabelloLadron;
	}

	public String obtenerSeniaLadron() {
		
		return this.seniaLadron;
	}

	public String obtenerVehiculoLadron() {
		
		return this.vehiculoLadron;
	}

	public ArrayList<Ladron> obtenerSospechosos() {
		
		return this.sospechosos;
	}

}
