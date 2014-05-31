package testAeropuerto;

import org.junit.Assert;
import org.junit.Test;
import clasesTp.Aeropuerto;

public class TestAeropuerto {

	@Test
	public void deberiaCrearseElAeropuertoConUnaPregunta() {
		
		Aeropuerto aeropuerto = new Aeropuerto();
		
		Assert.assertTrue(aeropuerto.pregunta_facil() != null);
		
	}

}
