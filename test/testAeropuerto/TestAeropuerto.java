package testAeropuerto;

import org.junit.Assert;
import org.junit.Test;
import clasesTp.Aeropuerto;

public class TestAeropuerto {

	@Test /* CONSIDERO QUE ESTA PRUEBA NO VA, POR LO MENOS POR AHORA */
	public void deberiaCrearseElAeropuertoConPistas() {
		
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.obtenerPistaFacil() != null);
		Assert.assertTrue(aeropuerto.obtenerPistaMedio() != null);
		
	}

} 