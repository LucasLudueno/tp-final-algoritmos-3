package modeloTp;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

public class ComputadoraPolicialTest {

	@Test
	public void laComputadoraPolicialDeberiaCrearseConLasCaracteristicasDelLadronYLosSospechososVacias(){
		ComputadoraPolicial computadora = new ComputadoraPolicial();
		
		Assert.assertTrue( computadora.obtenerSexoLadron() == null );
		Assert.assertTrue( computadora.obtenerHobbyLadron() == null );
		Assert.assertTrue( computadora.obtenerCabelloLadron() == null );
		Assert.assertTrue( computadora.obtenerSeniaLadron() == null );
		Assert.assertTrue( computadora.obtenerVehiculoLadron() == null );
		
		ArrayList<Ladron> sospechosos = computadora.obtenerSospechosos();
		
		Assert.assertTrue( sospechosos.size() == 0 );
	}
}
