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
	
	public Pista verPistaSegunRango(Novato rango, Jugador jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado.equals(ladronEscondido.obtenerNombre() ) ){
				return this.juegoGanado;
				
			}else{
				return this.ordenDeArrestoIncorrecta;
			}
		}
		
		return this.ordenDeArrestoNoEmitida;
	}
		
	public Pista verPistaSegunRango(Detective rango, Jugador jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado.equals(ladronEscondido.obtenerNombre() ) ){
				return this.juegoGanado;
				
			}else{
				return this.ordenDeArrestoIncorrecta;
			}
		}
		
		return this.ordenDeArrestoNoEmitida;
	}

	public Pista verPistaSegunRango(Investigador rango, Jugador jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado.equals(ladronEscondido.obtenerNombre() ) ){
				return this.juegoGanado;
				
			}else{
				return this.ordenDeArrestoIncorrecta;
			}
		}
		
		return this.ordenDeArrestoNoEmitida;
	}
	
	public Pista verPistaSegunRango(Sargento rango, Jugador jugador) {
		
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado.equals(ladronEscondido.obtenerNombre() ) ){
				return this.juegoGanado;
				
			}else{
				return this.ordenDeArrestoIncorrecta;
			}
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
