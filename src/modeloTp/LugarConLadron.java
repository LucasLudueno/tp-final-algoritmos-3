package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarConLadron implements ILugar{

	private Ladron ladronEscondido;
	
	@SuppressWarnings("unused")
	private String nombre;
	
	public LugarConLadron(String unNombre, Ladron ladron){
		this.ladronEscondido = ladron;
		this.nombre = unNombre;
	}
	
	public Pista devolverPista(JugadorNovato jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
		return null;
	}
		
	public Pista devolverPista(JugadorDetective jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
		return null;
	}
	
	public Pista devolverPista(JugadorInvestigador jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
		return null;
	}
		
	public Pista devolverPista(JugadorSargento jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
		return null;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
}
