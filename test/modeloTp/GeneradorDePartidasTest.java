package modeloTp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GeneradorDePartidasTest {
	
	@Test
	public void elGeneradorDePartidasDebeCrearseConLasCiudadesDelJuego(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		assertEquals(generador.obtenerCiudades().size(),30);		
	}
	
	@Test
	public void elGeneradorDeCiudadesDebeCrearSuListaDeCiudadesValidasYEliminarlaLasCiudadesElegidasDeLaListaDeTodasLasCiudades(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		assertEquals(generador.generarCiudadesConLugares().size(),6);
		assertEquals(generador.obtenerCiudades().size(),24);
	}
	
	@Test
	public void elGeneradorDeCiudadesDebeAsignarLosLugaresACadaCiudad(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		Ciudad unaCiudadValida = generador.generarCiudadesConLugares().get(0);
		Ciudad unaCiudadInvalida = generador.obtenerCiudades().get(0);
		
		assertEquals(unaCiudadValida.obtenerLugares().size(),3);
		assertEquals(unaCiudadInvalida.obtenerLugares().size(),3);
	}
}
