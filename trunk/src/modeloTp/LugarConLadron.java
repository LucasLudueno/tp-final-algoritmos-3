package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarConLadron implements ILugar{

	private Ladron ladronEscondido;
	private String nombre;
	private Pista juegoGanado;
	private Pista ordenDeArrestoNoEmitida;
	private Pista ordenDeArrestoIncorrecta;
	
	public LugarConLadron(String unNombre, Ladron ladron, Pista juegoGanado, Pista ordenDeArrestoIncorrecta, Pista ordenDeArrestoNoEmitida){
		this.ladronEscondido = ladron;
		this.nombre = unNombre;
		this.juegoGanado = juegoGanado;
		this.ordenDeArrestoNoEmitida = ordenDeArrestoNoEmitida;
		this.ordenDeArrestoIncorrecta = ordenDeArrestoIncorrecta;
	}
	
	public Pista devolverPista(JugadorNovato jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				return this.juegoGanado;
			}
			    return this.ordenDeArrestoIncorrecta;
		}
		
		return this.ordenDeArrestoNoEmitida;
	}
		
	public Pista devolverPista(JugadorDetective jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				return this.juegoGanado;
			}
			    return this.ordenDeArrestoIncorrecta;
		}
		
		return this.ordenDeArrestoNoEmitida;
	}
	
	public Pista devolverPista(JugadorInvestigador jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				return this.juegoGanado;
			}
			    return this.ordenDeArrestoIncorrecta;
		}
		
		return this.ordenDeArrestoNoEmitida;
	}
		
	public Pista devolverPista(JugadorSargento jugador){	
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado == ladronEscondido.obtenerNombre() ){
				return this.juegoGanado;
			}
			    return this.ordenDeArrestoIncorrecta;
		}
		
		return this.ordenDeArrestoNoEmitida;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String obtenerNombre() {
		
		return this.nombre;
	}
}
