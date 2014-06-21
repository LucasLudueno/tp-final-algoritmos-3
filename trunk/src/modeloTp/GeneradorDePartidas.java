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
		ciudades.add(new Ciudad("Mosc�",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Par�s",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Tokio",1,1,null,null,null,null));
		ciudades.add(new Ciudad("El Cairo",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Rio De Janeiro",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Roma",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Oslo",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Montreal",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Nueva York",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Pekin",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Singapur",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Bagdad",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Estambul",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Berl�n",1,1,null,null,null,null));
		ciudades.add(new Ciudad("Katmand�",1,1,null,null,null,null));
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
				lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avi�n pintado de celeste y blanco."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras espa�olas."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico m�s alto de Am�rica."),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Madrid"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tom� un avi�n que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que ten�a pensado asistir a una corrida de toros."),new Pista(""),new Pista("")));
			}
				
			if (ciudadesValidas.get(i).obtenerNombre() == "Londres"){
				lugares.add(new Lugar("Biblioteca",new Pista("Buscaba sellos para a�adirlos a su colecci�n."),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Hong Kong"){}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Atenas"){}

			if (ciudadesValidas.get(i).obtenerNombre() == "Sidney"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tom� un avi�n que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingl�s."),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Mosc�"){}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Par�s"){}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Tokio"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tom� un avi�n cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista("Se fue en un veh�culo en el que ondeaba una bandera roja y blanca."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Deseaba visitar los lugares santos sintoistas."),new Pista(""),new Pista("")));
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Roma"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Tom� un avi�n cuya ala estaba adornada con una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));				
			}
			
			if (ciudadesValidas.get(i).obtenerNombre() == "Singapur"){
				lugares.add(new Lugar("Aeropuerto",new Pista("Fue a visitar una isla del sudeste asi�tico."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Banco",new Pista("Dijo que quer�a comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
				lugares.add(new Lugar("Biblioteca",new Pista("Dijo que ten�a ganas de degustar un Gin Tonic en el hotel Raffles. Pidi� una mariscada."),new Pista(""),new Pista("")));
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
