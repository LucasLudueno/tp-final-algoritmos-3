package modeloTp;

import java.util.ArrayList;

public class ComputadoraPolicial {

	private ArrayList<Ladron> sospechosos;
	
	public ComputadoraPolicial(ArrayList<Ladron> sospechosos){
	
		this.sospechosos = sospechosos;
	}

	public ArrayList<Ladron> buscarPosiblesLadrones(String sexo, String hobby, String cabello, String senia, String vehiculo) {
		
		ArrayList<Ladron> posiblesLadrones = new ArrayList<Ladron>();
		for(Ladron sospechoso: this.sospechosos){
	          
			if ( (sexo == null) || ( sexo == sospechoso.obtenerSexo() ) ){
				if( (hobby == null) || ( hobby == sospechoso.obtenerHobby() ) ){
					if( (cabello == null) || ( cabello == sospechoso.obtenerCabello() ) ){
						if( (senia == null) || ( senia == sospechoso.obtenerSenia() ) ){
							if( (vehiculo == null) || ( vehiculo == sospechoso.obtenerVehiculo() ) ){
								
								posiblesLadrones.add(sospechoso);
							}
						}
					}
				}	
			}				
		}
		
		return posiblesLadrones;
		
	}

}
