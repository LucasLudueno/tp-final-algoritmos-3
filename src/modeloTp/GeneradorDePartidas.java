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
                ciudades.add(new Ciudad("Moscu",1,1,null,null,null,null));
                ciudades.add(new Ciudad("Paris",1,1,null,null,null,null));
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
                ciudades.add(new Ciudad("Berlin",1,1,null,null,null,null));
                ciudades.add(new Ciudad("Katmandu",1,1,null,null,null,null));
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
                                lugares.add(new Lugar("Aeropuerto",new Pista("Ha tomado un avion pintado de celeste y blanco."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista("Llevaba un diccionario con palabras espaniolas."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista("Vino a cambiar su dinero a pesos."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista("Ha declarado que iba a adquirir el monopolio del mercado del aceite de soja."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista("Dijo que estaba interesado en conocer el pico mas alto de America."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Madrid"){
                                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba una bandera roja y amarilla."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista("Me dijo que tenia pensado asistir a una corrida de toros."),new Pista(""),new Pista("")));
                        }
                                
                        if (ciudadesValidas.get(i).obtenerNombre() == "Londres"){
                                lugares.add(new Lugar("Biblioteca",new Pista("Buscaba sellos para aniadirlos a su coleccion."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Hong Kong"){}
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Atenas"){}

                        if (ciudadesValidas.get(i).obtenerNombre() == "Sidney"){
                                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion que llevaba adornada una bandera azul y roja con estrellas blancas."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista("Dijo que iba a asistir en una barbacoa ofrecida por el primer ministro."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista("Estaba hojeando un diccionario en ingles."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Moscu"){}
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Paris"){}
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Tokio"){
                                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera roja y blanca."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista("Se fue en un vehiculo en el que ondeaba una bandera roja y blanca."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista("Deseaba visitar los lugares santos sintoistas."),new Pista(""),new Pista("")));
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Roma"){
                                lugares.add(new Lugar("Aeropuerto",new Pista("Tomo un avion cuya ala estaba adornada con una bandera verde, blanca y roja."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista(""),new Pista(""),new Pista("")));                         
                        }
                        
                        if (ciudadesValidas.get(i).obtenerNombre() == "Singapur"){
                                lugares.add(new Lugar("Aeropuerto",new Pista("Fue a visitar una isla del sudeste asiatico."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Puerto",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Banco",new Pista("Dijo que queria comprar un barco para dar la vuelta al mundo."),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Bolsa",new Pista(""),new Pista(""),new Pista("")));
                                lugares.add(new Lugar("Biblioteca",new Pista("Dijo que tenia ganas de degustar un Gin Tonic en el hotel Raffles. Pidio una mariscada."),new Pista(""),new Pista("")));
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