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
	/*
	@Test
		public void generarLugaresDeUnaCiudadDevuelveLosLugaresQueTieneEsaCiudadConSusPistas() throws ParserConfigurationException, SAXException, IOException, TransformerException{
			
			GeneradorDePartidas generador = new GeneradorDePartidas();
			ArrayList<Lugar> lugares = generador.generarLugaresDeUnaCiudad("Ciudad de Mexico");
			
			JugadorNovato jugador = new JugadorNovato(null, null);
			for(int j=0; j < lugares.size(); j++){
				Assert.assertTrue(lugares.get(j).devolverPista(jugador) != null );
			}
			
			lugares = generador.generarLugaresDeUnaCiudad("Buenos Aires");
			for(int j=0; j < lugares.size(); j++){
				Assert.assertTrue(lugares.get(j).devolverPista(jugador) != null );
			}
			
			
			listaDeCiudades.add(new Ciudad("Madrid",12,10,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Londres",12,12,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Atenas",14,11,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Sidney",22,5,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Moscu",15,12,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Paris",13,11,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Tokio",22,10,null,null,null,null));
			listaDeCiudades.add(new Ciudad("El Cairo",14,10,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Rio De Janeiro",9,6,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Roma",13,11,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Oslo",13,13,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Montreal",8,12,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Nueva York",8,11,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Singapur",19,8,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Bagdad",15,10,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Estambul",15,11,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Katmandu",18,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Dubai",15,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("San Marino",13,10,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Nueva Delhi",17,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Ciudad de Mexico",5,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Lima",7,7,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Kigali",14,8,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Reykjavik",11,13,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Budapest",14,12,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Bamako",12,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Bangkok",19,9,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Moroni",15,7,null,null,null,null));
			listaDeCiudades.add(new Ciudad("Puerto Moresby",22,7,null,null,null,null));
			
		}
		*/
}