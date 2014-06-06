package modeloTp;

public class Bolsa extends Lugar {

public Bolsa (Pista pistaFacil, Pista pistaMedia, Pista pistaDificil){
		
		this.pistaFacil = pistaFacil;
		this.pistaMedia = pistaMedia;
		this.pistaDificil = pistaDificil;

	}
	
	public Pista devolverPista(JugadorNovato jugador) {
		return this.pistaFacil;
	}
	
	public Pista devolverPista(JugadorDetective jugador){	
		return this.pistaMedia;
	}
	
	public Pista devolverPista(JugadorInvestigador jugador){	
		return this.pistaMedia;
	}
	
	public Pista devolverPista(JugadorSargento jugador){	
		return this.pistaDificil;
	}
}

