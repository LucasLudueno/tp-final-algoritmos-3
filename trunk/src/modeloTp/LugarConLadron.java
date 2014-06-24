package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarConLadron implements ILugar{

	private Ladron ladronEscondido;
	
	public LugarConLadron(Ladron ladron){
		this.ladronEscondido = ladron;
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