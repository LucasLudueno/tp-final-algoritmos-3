package modeloTp;

public class Lugar {
	
	protected Pista pistaFacil;
	protected Pista pistaMedia;
	protected Pista pistaDificil;
	
protected Lugar(Pista pistaFacil, Pista pistaMedia, Pista pistaDificil){
		
		this.pistaFacil = pistaFacil;
		this.pistaMedia = pistaMedia;
		this.pistaDificil = pistaDificil;

	}
	
	protected Pista devolverPista(JugadorNovato jugador) {
		return this.pistaFacil;
	}
	
	protected Pista devolverPista(JugadorDetective jugador){	
		return this.pistaMedia;
	}
	
	protected Pista devolverPista(JugadorInvestigador jugador){	
		return this.pistaMedia;
	}
	
	protected Pista devolverPista(JugadorSargento jugador){	
		return this.pistaDificil;
	}	
}
