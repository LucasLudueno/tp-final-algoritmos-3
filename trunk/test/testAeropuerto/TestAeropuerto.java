package testAeropuerto;

import org.junit.Assert;
import org.junit.Test;
import clasesTp.Aeropuerto;
import clasesTp.Ciudad;
import clasesTp.JugadorDetective;
import clasesTp.Pista;

public class TestAeropuerto {

	@Test /* Es probable que haya que modificar algunas cosas de la prueba */
	public void deberiaCrearseElAeropuertoConPistas() {
		
		JugadorDetective jugador = new JugadorDetective(new Ciudad("Buenos Aires",1,1),0,0);
		Pista unaPista = jugador.accederALugar(new Aeropuerto());	
		
		Assert.assertTrue(unaPista.obtenerPista() == "Pista");	
	}
} 