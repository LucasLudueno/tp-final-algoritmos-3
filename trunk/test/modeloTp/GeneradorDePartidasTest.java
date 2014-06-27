package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.xml.sax.SAXException;

import controladorTp.Serializador;



public class GeneradorDePartidasTest {
	
	@Test
	public void elGeneradorDePartidasDebeCrearseConLasCiudadesDelJuego(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		assertEquals(generador.obtenerCiudades().size(),30);		
	}
	
	@Test
	public void cadaCiudadDebeTenerTresCiudadesAViajar(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		for(int i=0; i < generador.obtenerCiudades().size(); i++){
			assertEquals(generador.obtenerCiudades().get(i).obtenerCiudadesAViajar().size(),3);
		}
	}
	
	@Test
	public void elGeneradorDeCiudadesDebeAsignarLosLugaresACadaCiudad(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		ArrayList<Ciudad> listaDeCiudadesValidas = generador.generarCiudadesConLugares();
		ArrayList<Ciudad> listaDeCiudadesInvalidas = generador.obtenerCiudades();
		
		for(int i=0; i<listaDeCiudadesValidas.size(); i++){
			assertEquals(listaDeCiudadesValidas.get(i).obtenerLugares().size(),3);
		}
		
		for(int i=0; i<listaDeCiudadesInvalidas.size(); i++){
			assertEquals(listaDeCiudadesInvalidas.get(i).obtenerLugares().size(),3);
		}
	}
	
	@Test
	public void lasCiudadesDelRecorridoDelLadronDebenTener3ciudadesADondeViajar(){
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		generador.obtenerCiudades();
		ArrayList<Ciudad> recorridoDelLadron= generador.generarCiudadesConLugares();
		
		for(int j=0; j < recorridoDelLadron.size() - 1; j++){
			
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().size() == 3);
    		
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(0) != null);
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(1) != null);
    		assertTrue(recorridoDelLadron.get(j).obtenerCiudadesAViajar().get(2) != null);
    	}		
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
		
		//Elimino el archivo
		File archivo = new File("ListaDeLadrones.xml");
		archivo.delete();
	}
	
	@Test
	public void elGeneradorDePartidasDebeGenerarElRecorridoDelLadronConSusCiudadesYLugares() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		Serializador serializador = new Serializador();
		serializador.serializadorDeListaDeLadrones();
		
		GeneradorDePartidas generador = new GeneradorDePartidas();
		ArrayList<Ciudad> recorridoLadron = generador.generarRecorridoDelLadron();
		
		assertEquals(recorridoLadron.size(),6);
		for(int i=0; i < recorridoLadron.size(); i++){
			assertEquals(recorridoLadron.get(i).cantidadLugares(),3);
		}
		
		//Elimino el archivo
		File archivo = new File("ListaDeLadrones.xml");
		archivo.delete();
	}
}
