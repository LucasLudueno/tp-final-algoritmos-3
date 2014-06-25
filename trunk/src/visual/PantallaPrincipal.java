package visual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modeloTp.Ciudad;
import modeloTp.ComputadoraPolicial;
import modeloTp.GeneradorDePartidas;
import modeloTp.ILugar;
import modeloTp.JugadorNovato;

public class PantallaPrincipal {
	
	
	public static void main (String[] args ) throws ParserConfigurationException, TransformerException, SAXException, IOException{
	
		GeneradorDePartidas juego = new GeneradorDePartidas();	
		ArrayList<Ciudad> ciudadesValidas = juego.generarRecorridoDelLadron();
		ArrayList<ILugar> lugaresEnLaCiudad;
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner (System.in);
		@SuppressWarnings("unused")
		String espacio = "";
		int opcionElegida = 0;
		int contador = 0;
		ComputadoraPolicial computadora = new ComputadoraPolicial(juego.generarListaDeLadrones());
		JugadorNovato jugador = new JugadorNovato(ciudadesValidas.get(0), computadora);
		
		Ciudad ciudadJugando = ciudadesValidas.get(contador);
		
		while (ciudadJugando != ciudadesValidas.get((ciudadesValidas.size()-1))){
			
		 	lugaresEnLaCiudad = ciudadJugando.obtenerLugares();
		 	
			System.out.println(ciudadJugando.obtenerNombre());
			System.out.println("1)_ "+lugaresEnLaCiudad.get(0).obtenerNombre());
			System.out.println("2)_ "+lugaresEnLaCiudad.get(1).obtenerNombre());
			System.out.println("3)_ "+lugaresEnLaCiudad.get(2).obtenerNombre());
			System.out.println("4)_ Proximas ciudades a viajar");
		
	        opcionElegida = entradaEscaner.nextInt(); 
		
	        if ( opcionElegida == 4){
	        	
	        	System.out.println("1)_ "+ciudadJugando.obtenerCiudadesAViajar().get(0).obtenerNombre());
	        	System.out.println("2)_ "+ciudadJugando.obtenerCiudadesAViajar().get(1).obtenerNombre());
	        	System.out.println("3)_ "+ciudadJugando.obtenerCiudadesAViajar().get(2).obtenerNombre());
	        	
	        	opcionElegida = entradaEscaner.nextInt();
	        	
	        	if( contador+1 >=ciudadesValidas.size()-1){
	        		System.out.println("No hay mas ciudades");
	        		espacio = entradaEscaner.nextLine();
	        	}
	        	else if ( ciudadesValidas.get(contador+1).obtenerNombre() == ciudadJugando.obtenerCiudadesAViajar().get(opcionElegida-1).obtenerNombre()){
	        		
	        		contador = contador +1;
	        		ciudadJugando = ciudadesValidas.get(contador);
	        	}
	        	
	        }
	        
	        System.out.println(lugaresEnLaCiudad.get(opcionElegida-1).devolverPista(jugador).obtenerContenido());
	       
	        espacio = entradaEscaner.nextLine();
	        }
	        
		}
	}
