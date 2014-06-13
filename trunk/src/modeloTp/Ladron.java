package modeloTp;

public class Ladron {
	
	private String nombre;
	private String sexo;
	private String cabello;
	private String hobby;
	private String senia;
	private String vehiculo;
	
	public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo){
		this.nombre = nombre;
		this.sexo = sexo;
		this.cabello = cabello;
		this.hobby = hobby;
		this.senia = senia;
		this.vehiculo = vehiculo;
	}

	public String obtenerNombre() {
		
		return this.nombre;
	}
	
	public String obtenerSexo() {
		
		return this.sexo;
	}

	public String obtenerHobby() {
		
		return this.hobby;
	}

	public String obtenerCabello() {
		
		return this.cabello;
	}

	public String obtenerSenia() {
		
		return this.senia;
	}

	public String obtenerVehiculo() {
		
		return this.vehiculo;
	}

}
