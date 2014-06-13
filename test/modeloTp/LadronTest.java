package modeloTp;

import org.junit.Test;
import org.junit.Assert;

public class LadronTest {

	@Test
	public void ladronDeberiaCrearseConTodasLasCaracteristicas(){
		
		Ladron ladron = new Ladron("Pepe", "masculino", "tennis", "rojo", "joyas", "limusina");
		
		Assert.assertTrue( ladron.obtenerNombre() == "Pepe");
		Assert.assertTrue( ladron.obtenerSexo() == "masculino");
		Assert.assertTrue( ladron.obtenerHobby() == "tennis");
		Assert.assertTrue( ladron.obtenerCabello() == "rojo");
		Assert.assertTrue( ladron.obtenerSenia() == "joyas");
		Assert.assertTrue( ladron.obtenerVehiculo() == "limusina");
	}
}
