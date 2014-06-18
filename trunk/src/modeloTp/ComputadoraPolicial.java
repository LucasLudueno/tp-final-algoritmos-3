package modeloTp;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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

	public Node serializar(Document doc) {
		Element elementoComputadora = doc.createElement("ComputadoraPolicial");
		Element elementoLadrones = doc.createElement("Ladrones");
		
		elementoComputadora.appendChild(elementoLadrones);
		for (int i=0; i < sospechosos.size(); i++) {
			elementoLadrones.appendChild(sospechosos.get(i).serializar(doc));
		}
		
		return elementoComputadora;
	}

	public static ComputadoraPolicial cargarEstado(Element elementoComputadora) {
		Element elementoLadrones = (Element) elementoComputadora.getElementsByTagName("Ladrones").item(0);
		ArrayList<Ladron> listaSospechosos = new ArrayList<Ladron>();
		for (int i=0; i < elementoLadrones.getChildNodes().getLength(); i++){
			Ladron unLadron = Ladron.cargarEstado((Element) elementoLadrones.getChildNodes().item(i));	
			listaSospechosos.add(unLadron);
		}
		
		ComputadoraPolicial unaComputadora = new ComputadoraPolicial(listaSospechosos);
		
		return unaComputadora;
	}

}
