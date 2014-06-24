package modeloTp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.Assert;

import org.junit.Test;
import org.xml.sax.SAXException;

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
	
	@Test
	public void elGeneradorDebeDevolverUnaListaConLadronesConCaracteristicas() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		ArrayList<Ladron> listaDeLadrones = new ArrayList<Ladron>();
		listaDeLadrones = generador.generarListaDeLadrones();
				
		for(int j=0; j < listaDeLadrones.size(); j++){
			
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerNombre() != null);
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerCabello() != null);
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerSenia() != null);
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerVehiculo() != null);
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerHobby() != null);
    		Assert.assertTrue(listaDeLadrones.get(j).obtenerSexo() != null);
    	}
		
		
	}
}
