package testAeropuerto;

import org.junit.Assert;
import org.junit.Test;

import clasesTp.Aeropuerto;
import clasesTp.Ciudad;
import clasesTp.JugadorDetective;
import clasesTp.JugadorNovato;

public class TestAeropuerto {

	@Test
	public void novatoDeberiaObtenerPistaFacilCuandoAccedeAlAeropuerto() {
		
		JugadorNovato jugador = new JugadorNovato(new Ciudad("Buenos Aires",1,1),0,0);
		
		Assert.assertTrue(jugador.obtenerPistaDe(new Aeropuerto()) == "a");	
	}
	
	@Test
	public void detectiveDeberiaObtenerPistaMediaCuandoAccedeAlAeropuerto(){
		
		JugadorDetective jugador = new JugadorDetective(new Ciudad("Buenos Aires",1,1),0,0);
				
		Assert.assertTrue(jugador.obtenerPistaDe(new Aeropuerto()) == "b");		
	}
	
} 