package modeloTp;

import java.util.ArrayList;

public class ComputadoraPolicial {

	private String sexoLadron;
	private String cabelloLadron;
	private String hobbyLadron;
	private String seniaLadron;
	private String vehiculoLadron;
	private ArrayList<Ladron> sospechosos;
	
	public ComputadoraPolicial(ArrayList<Ladron> sospechosos){
	
		this.sospechosos = sospechosos;
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

	public void agregarSexoLadron(String sexoLadron) {
		
		this.sexoLadron = sexoLadron;
	}

	public void agregarHobbyLadron(String hobbyLadron) {
		
		this.hobbyLadron = hobbyLadron;		
	}

	public void agregarVehiculoLadron(String vehiculoLadron) {
		
		this.vehiculoLadron = vehiculoLadron;
	}

	public void agregarCabelloLadron(String cabelloLadron) {
		
		this.cabelloLadron = cabelloLadron;		
	}

	public void agregarSeniaLadron(String seniaLadron) {
		
		this.seniaLadron = seniaLadron;		
	}

}
