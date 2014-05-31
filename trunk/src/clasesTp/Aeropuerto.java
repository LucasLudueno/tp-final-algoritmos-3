package clasesTp;

public class Aeropuerto {

	private String pregunta_facil;
	private String pregunta_medio;
	private String pregunta_dificil;

	public Aeropuerto (){
		
		this.pregunta_facil = "a";
		this.pregunta_medio = "b";
		this.pregunta_dificil = "c";

	}
	
	public String pregunta_facil() {
			
		return this.pregunta_facil;
	}
	
	public String pregunta_medio() {
		
		return this.pregunta_medio;
	}
	
	public String pregunta_dificil() {
		
		return this.pregunta_dificil;
	}

	public String devolverPregunta(Jugador jugador) {
		
		if (jugador.nivel() == "novato") return this.pregunta_facil();
		if (jugador.nivel() == "detective") return this.pregunta_dificil();
		return null;
	}

}
