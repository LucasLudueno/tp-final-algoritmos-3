package modeloTp;

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
}
