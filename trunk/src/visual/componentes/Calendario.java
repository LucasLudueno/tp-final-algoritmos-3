package visual.componentes;

import java.util.ArrayList;

public class Calendario {
	
	private ArrayList<String> diasDeSemana = new ArrayList<String>();
	private int hora;
	private int diaActual;
	private int tiempoDisponibleEnHoras;
	
	public Calendario(int tiempo){
		diasDeSemana.add("Lunes");
		diasDeSemana.add("Martes");
		diasDeSemana.add("Miercoles");
		diasDeSemana.add("Jueves");
		diasDeSemana.add("Viernes");
		diasDeSemana.add("Sabado");
		diasDeSemana.add("Domingo");	
		
		hora = 7;
		diaActual = 0;
		this.tiempoDisponibleEnHoras = tiempo;
	}
	
	public int obtenerHora(){
		return hora;
	}
	
	public String obtenerDiaActual(){
		return diasDeSemana.get(diaActual);
	}
	
	public void sumarTiempo(int unValor){
		int tiempo = (this.tiempoDisponibleEnHoras - unValor);
		
		while(tiempo > 0){
			hora++;
			if (hora > 23){
				hora = 0;
				diaActual++;
			}
			tiempo--;		
		}
		this.tiempoDisponibleEnHoras = unValor;
		if (this.tiempoDisponibleEnHoras <= 0){
			//System.exit(0);
		}
	}
	
}
