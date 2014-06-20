package modeloTp;

public class LugarConLadron {

	private Ladron ladronEscondido;
	
	public LugarConLadron(Ladron ladron){
		this.ladronEscondido = ladron;
	}
	
	public void devolverPista(JugadorNovato jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
	}
		
	public void devolverPista(JugadorDetective jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
	}
	
	public void devolverPista(JugadorInvestigador jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
	}
		
	public void devolverPista(JugadorSargento jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado  == ladronEscondido.obtenerNombre() ){
				//GANASTEEEEEEEEE
			}
			    //PERDISTEEEEEEEEE
		}
		
		//PERDISTEEEEEEEEE
	}
}
