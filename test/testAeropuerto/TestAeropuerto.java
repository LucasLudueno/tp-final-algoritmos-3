package testAeropuerto;

import org.junit.Assert;
import org.junit.Test;
import clasesTp.Aeropuerto;

public class TestAeropuerto {

	@Test
	public void deberiaCrearseElAeropuertoConPistas() {
		
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.obtenerPistaFacil() != null);
		Assert.assertTrue(aeropuerto.obtenerPistaDificil() != null);
		Assert.assertTrue(aeropuerto.obtenerPistaMedio() != null);
		
	}

}