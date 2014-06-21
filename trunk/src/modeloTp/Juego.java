package modeloTp;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import modeloTp.Ladron;
import modeloTp.GeneradorDePartidas;

public class Juego {
	
	@Test
	public void iniciarJuego() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		GeneradorDePartidas generador = new GeneradorDePartidas();
		
		ArrayList<Ladron> ladrones = generador.generarListaDeLadrones();
		Assert.assertTrue( true);
	}
	

}
