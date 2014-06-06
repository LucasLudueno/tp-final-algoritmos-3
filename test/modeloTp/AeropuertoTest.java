package modeloTp;

import org.junit.Test;
import org.junit.Assert;

public class AeropuertoTest {

	@Test
	public void elAeropuertoDeberiaDevolverLaPistaFacilSiElPersonajeEsNovato(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto(pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaFacil);
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorDetective jugador = new JugadorDetective(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto(pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaFacilSiElPersonajeEsSargento(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorSargento jugador = new JugadorSargento(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto(pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaDificil);
	}
	
	@Test
	public void elAeropuertoDeberiaDevolverLaPistaMediaSiElPersonajeEsInvestigador(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		JugadorInvestigador jugador = new JugadorInvestigador(BuenosAires);
		Aeropuerto aeropuerto = new Aeropuerto(pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}

}
