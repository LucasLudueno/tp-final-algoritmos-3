package modeloTp;

import java.util.ArrayList;
import java.util.Random;

public class GeneradorDePartidas {
	
private ArrayList<Ciudad> ciudades;	
	
	public GeneradorDePartidas(){
		
		ciudades.add(new Ciudad("Buenos Aires",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Madrid",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Londres",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Hong Kong",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Atenas",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Sidney",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Moscú",1,1,null,null,null,null));
		ciudades.add(new Ciudad("París",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Tokio",1,1,null,null,null,null));
		ciudades.add(new Ciudad("El Cairo",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Rio De Janeiro",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Roma",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Oslo",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Montreal",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Nueva York",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Pekin",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Bangkok",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Bagdad",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Estambul",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Berlín",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Katmandú",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Dubai",1,1,null,null,null,null));
		
	}
	
	public ArrayList<Ciudad> generarListaDeCiudadesValidas(ArrayList<Ciudad> unaListaDeCiudades){
		ArrayList<Ciudad> ciudadesValidas = new ArrayList<Ciudad>();
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Random generador = new Random();
		
		for (int i=0; i < 6; i++){
			int valor = generador.nextInt(ciudades.size());
			ciudadesValidas.add(ciudades.get(valor));
			ciudades.remove(valor);
		}
		
		for (int i=0; i < ciudadesValidas.size(); i++){
			if (ciudadesValidas.get(i).obtenerNombre() == "Buenos Aires"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avión pintado de celeste y blanco"),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras españolas"),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos"),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja"),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico más alto de América"),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Madrid"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tomó un avión que llevaba una bandera roja y amarilla"),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que tenía pensado asistir a una corrida de toros"),new Pista(""),new Pista("")));
			}
				
			if (ciudadesValidas.get(i).obtenerNombre() == "Londres"){
				lugares.add(new Lugar("Biblioteca",new Pista("Buscaba sellos para añadirlos a su colección"),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Hong Kong"){}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Atenas"){}

			if (ciudadesValidas.get(i).obtenerNombre() == "Sidney"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tomó un avión que llevaba adornada una bandera azul y roja con estrellas blancas"),new Pista(""),new Pista("")));
			}	
			
			
			while (lugares.size() > 3){
				int valor = generador.nextInt(lugares.size());
				lugares.remove(valor);
			}
			
			for(int j=0; j < lugares.size(); j++){
				ciudadesValidas.get(i).obtenerLugares().add(lugares.get(j));
			}
			
		}
		
		return ciudadesValidas;
	}

}
