package visual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modeloTp.Ciudad;
import modeloTp.ComputadoraPolicial;
import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.GeneradorDePartidas;
import modeloTp.ILugar;
import modeloTp.JugadorNovato;

public class PantallaPrincipal {
	
	
	public static void main (String[] args ) throws ParserConfigurationException, TransformerException, SAXException, IOException, ExcepcionNoHayMasTiempo{
	
		GeneradorDePartidas juego = new GeneradorDePartidas();	
		ArrayList<Ciudad> ciudadesValidas = juego.obtenerRecorridoLadron();
		ArrayList<ILugar> lugaresEnLaCiudad;
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		
		int opcionElegida = 0;
		ComputadoraPolicial computadora = new ComputadoraPolicial(juego.generarListaDeLadrones());
		JugadorNovato jugador = new JugadorNovato(ciudadesValidas.get(0), computadora);
		int tiempoAntesDeDormir = jugador.obtenerTiempoRestante();
		boolean juegoTerminado = false;
		
		while (juegoTerminado != true){
			
		 	lugaresEnLaCiudad = jugador.obtenerCiudadActual().obtenerLugares();
		 	
		 	System.out.println("");
			System.out.print("Ciudad actual: "+jugador.obtenerCiudadActual().obtenerNombre());
			System.out.print(" / ");
			System.out.println("Tiempo restante: "+jugador.obtenerTiempoRestante());
			System.out.println("");
			System.out.println("1)_ "+lugaresEnLaCiudad.get(0).obtenerNombre());
			System.out.println("2)_ "+lugaresEnLaCiudad.get(1).obtenerNombre());
			System.out.println("3)_ "+lugaresEnLaCiudad.get(2).obtenerNombre());
			System.out.println("4)_ Computadora Policial");
			System.out.println("5)_ Proximas ciudades a viajar");
		
	        opcionElegida = entradaEscaner.nextInt(); 
	        entradaEscaner.nextLine();
	        
	        if ( opcionElegida == 5){
	        	
	        	System.out.println("");
	        	System.out.println("Ciudades a viajar:");
	        	System.out.println("");
	        	System.out.println("1)_ "+jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(0).obtenerNombre());
	        	System.out.println("2)_ "+jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(1).obtenerNombre());
	        	System.out.println("3)_ "+jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(2).obtenerNombre());
	        	
	        	jugador.viajar(jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(entradaEscaner.nextInt()-1));	        	
	        	entradaEscaner.nextLine();
	        	
	        	if(juego.obtenerPasoActual() < (juego.obtenerRecorridoLadron().size()-1)){
	        		if(jugador.obtenerCiudadActual() == ciudadesValidas.get(juego.obtenerPasoActual()+1)){
	        			juego.pasarALaSiguienteCiudadDelRecorrido();
	        		}
	        	}
	        	
	        } else if( opcionElegida == 4){
	        	
	        	System.out.println("Ingrese sexo del sospechoso ");
	        	String sexo = entradaEscaner.nextLine();
	        	System.out.println("Ingrese hobby del sospechoso ");
	        	String hobby = entradaEscaner.nextLine();
	        	System.out.println("Ingrese cabello del sospechoso ");
	        	String cabello = entradaEscaner.nextLine();
	        	System.out.println("Ingrese senia del sospechoso ");
	        	String senia = entradaEscaner.nextLine();
	        	System.out.println("Ingrese vehiculo del sospechoso ");
	        	String vehiculo = entradaEscaner.nextLine();
	        	
	        	if (jugador.emitirOrdenDeArresto(sexo, hobby, cabello, senia, vehiculo) == true) System.out.println("Orden de arresto emitida");
	        	else System.out.println("No Hay Suficientes pistas para obtener coincidencias");
	        	
	        	
	        }
	        
	        
	        
	        else {
	        	System.out.println(lugaresEnLaCiudad.get(opcionElegida-1).devolverPista(jugador).obtenerContenido());
	        	jugador.restarTiempoPorEntrarALugar();
	        	entradaEscaner.nextLine();
	        }
	       
	        
			if(tiempoAntesDeDormir - jugador.obtenerTiempoRestante() > 17) {
	        	
	        	tiempoAntesDeDormir = jugador.obtenerTiempoRestante();
	        	jugador.dormir();
	        	System.out.println("El jugador esta durmiendo");
	        }
	        
	    }
	        
	}
}