package modeloTp;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Assert;

public class ComputadoraPolicialTest {

	@Test
	public void laComputadoraPolicialDeberiaCrearseConLasCaracteristicasDelLadronYLosSospechososVacias(){
		ComputadoraPolicial computadora = new ComputadoraPolicial( new ArrayList<Ladron>() );
		
		Assert.assertTrue( computadora.obtenerSexoLadron() == null );
		Assert.assertTrue( computadora.obtenerHobbyLadron() == null );
		Assert.assertTrue( computadora.obtenerCabelloLadron() == null );
		Assert.assertTrue( computadora.obtenerSeniaLadron() == null );
		Assert.assertTrue( computadora.obtenerVehiculoLadron() == null );
		
		ArrayList<Ladron> sospechosos = computadora.obtenerSospechosos();
		
		Assert.assertTrue( sospechosos.size() == 0 );
	}
	
	@Test 
	public void laComputadoraDeberiaDevolverLasCaracteristicasDelLadronIngresadas(){
		
		ComputadoraPolicial computadora = new ComputadoraPolicial( new ArrayList<Ladron>() );
		
		computadora.agregarSexoLadron("masculino");
		computadora.agregarHobbyLadron("football");
		computadora.agregarVehiculoLadron("limusina");
		computadora.agregarCabelloLadron("rojo");
		computadora.agregarSeniaLadron("cicatriz");
		
		
		Assert.assertTrue( computadora.obtenerSexoLadron() == "masculino" );
		Assert.assertTrue( computadora.obtenerHobbyLadron() == "football" );
		Assert.assertTrue( computadora.obtenerCabelloLadron() == "rojo" );
		Assert.assertTrue( computadora.obtenerSeniaLadron() == "cicatriz" );
		Assert.assertTrue( computadora.obtenerVehiculoLadron() == "limusina" );
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void laComputadoraPolicialDeberiaDevolverUnaOrdenDeArrestoSiSoloUnSospechosoCoincideConLosDatosIngresados(){
		
		Ladron sospechoso1 = new Ladron("Pepe", "masculino", "tennis", "rojo", "joyas", "limusina");
		Ladron sospechoso2 = new Ladron("Maria", "femenino", "handball", "castanio", "cicatriz", "limusina");
		Ladron ladron = new Ladron("Jose", "masculino", "football", "negro", "ninguna", "desacapotable");
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		sospechosos.add(ladron);
		
		ComputadoraPolicial computadora = new ComputadoraPolicial(sospechosos);
		
		computadora.agregarSexoLadron("masculino");
		computadora.agregarHobbyLadron("football");
		computadora.agregarVehiculoLadron("limusina");
		
		OrdenDeArresto orden = computadora.emitirOrdenDeArresto();
		
		Assert.assertTrue( orden.obtenerNombreLLadron() == "Jose" );
		
	} */
}
