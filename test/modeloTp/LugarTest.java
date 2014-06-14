package modeloTp;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

public class LugarTest {

	@Test 
	public void elLugarDeberiaDevolverElNombreIngresado(){
		
		Lugar bolsa = new Lugar("bolsa", null, null, null);
		
		Assert.assertTrue( bolsa.obtenerNombre() == "bolsa" );
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaFacilSiElPersonajeEsNovato(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorNovato jugador = new JugadorNovato(BuenosAires);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaFacil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorDetective jugador = new JugadorDetective(BuenosAires);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaDificilSiElPersonajeEsSargento(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorSargento jugador = new JugadorSargento(BuenosAires);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaDificil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMediaSiElPersonajeEsInvestigador(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1,null,null,null, new ArrayList<Ciudad>());
		JugadorInvestigador jugador = new JugadorInvestigador(BuenosAires);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		Assert.assertTrue(aeropuerto.devolverPista(jugador) == pistaMedia);
	}

}
