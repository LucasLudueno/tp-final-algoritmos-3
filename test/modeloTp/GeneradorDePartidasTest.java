package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.Assert;

import org.junit.Test;

import org.xml.sax.SAXException;

import controladorTp.Serializador;

public class GeneradorDePartidasTest {
	
	@Test
	public void elGeneradorDePartidasDebeCrearseConLasCiudadesDelJuego() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		assertEquals(generador.obtenerCiudades().size(),30);		
	}
	
	@Test
	public void cadaCiudadDebeTenerTresCiudadesAViajar() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		for(int i=0; i < generador.obtenerCiudades().size(); i++){
			assertEquals(generador.obtenerCiudades().get(i).obtenerCiudadesAViajar().size(),3);
		}
	}
	
	@Test
	public void elGeneradorDeCiudadesDebeAsignarLosLugaresACadaCiudad() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		ArrayList<Ciudad> listaDeCiudades = generador.obtenerCiudades();
		
		for(int i=0; i<listaDeCiudades.size(); i++){
			assertEquals(listaDeCiudades.get(i).obtenerLugares().size(),3);
		}
	}
	
	@Test
	public void lasCiudadesDelRecorridoDelLadronDebenTener3ciudadesADondeViajar() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		generador.obtenerCiudades();
		ArrayList<Ciudad> recorridoDelLadron= generador.obtenerRecorridoLadron();
		
		for(int j=0; j < recorridoDelLadron.size() - 1; j++){
			
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().size() == 3);
    		
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(0) != null);
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(1) != null);
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(2) != null);
    	}		
	}
	
	@Test
	public void pasarALaSiguienteCiudadDelRecorridoDelLadronDebeAumentarUnPasoActual() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		assertEquals(generador.obtenerPasoActual(),0);
		
		generador.pasarALaSiguienteCiudadDelRecorrido();
		
		assertEquals(generador.obtenerPasoActual(),1);
	}
	
	@Test
	public void elGeneradorDebeDevolverUnaListaConLadronesConCaracteristicas() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Creo el archivo XML
		Serializador serializador = new Serializador();
		serializador.serializadorDeListaDeLadrones();
		
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		ArrayList<Ladron> listaDeLadrones = new ArrayList<Ladron>();
		listaDeLadrones = generador.generarListaDeLadrones();
				
		for(int j=0; j < listaDeLadrones.size(); j++){
			
    		assertTrue(listaDeLadrones.get(j).obtenerNombre() != null);
    		assertTrue(listaDeLadrones.get(j).obtenerCabello() != null);
    		assertTrue(listaDeLadrones.get(j).obtenerSenia() != null);
    		assertTrue(listaDeLadrones.get(j).obtenerVehiculo() != null);
    		assertTrue(listaDeLadrones.get(j).obtenerHobby() != null);
    		assertTrue(listaDeLadrones.get(j).obtenerSexo() != null);
    	}
		
	}
	
	@Test
	public void elGeneradorDePartidasDebeGenerarElRecorridoDelLadronConSusCiudadesYLugares() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		Serializador serializador = new Serializador();
		serializador.serializadorDeListaDeLadrones();
		
		GeneradorDePartidas generador = new GeneradorDePartidas();
		ArrayList<Ciudad> recorridoLadron = generador.obtenerRecorridoLadron();
		
		assertEquals(recorridoLadron.size(),6);
		for(int i=0; i < recorridoLadron.size(); i++){
			assertEquals(recorridoLadron.get(i).cantidadLugares(),3);
		}
		
		//Elimino el archivo
		File archivo = new File("ListaDeLadrones.xml");
		archivo.delete();
	}
	
	@Test
	public void generarListaDeCiudadesDebeDevolverUnaListaDeCiudadesConNombreYCoordenadas() throws ParserConfigurationException, TransformerException, SAXException, IOException{
	
		GeneradorDePartidas generador = new GeneradorDePartidas();
		ArrayList<Ciudad> ciudades = generador.generarListaDeCiudades();
		
		
		for(int i=0; i< ciudades.size(); i++){
			Assert.assertTrue( ( (Ciudad)ciudades.get(i) ).obtenerNombre() != null );
			Assert.assertTrue( ( (Ciudad)ciudades.get(i) ).obtenerPosicion_x() != 0 );
			Assert.assertTrue( ( (Ciudad)ciudades.get(i) ).obtenerPosicion_y() != 0 );
		}
		
	}
	
	@Test
		public void generarLugaresDeUnaCiudadDevuelveLosLugaresQueTieneEsaCiudadConSusPistas() throws ParserConfigurationException, SAXException, IOException, TransformerException{
			
			GeneradorDePartidas generador = new GeneradorDePartidas();
			ArrayList<Lugar> lugares = generador.generarLugaresDeUnaCiudad("Ciudad de Mexico");
			
			JugadorNovato jugador = new JugadorNovato(null, null);
			for(int j=0; j < lugares.size(); j++){
				Assert.assertTrue(lugares.get(j).devolverPista(jugador) != null );
			}
		}
}
