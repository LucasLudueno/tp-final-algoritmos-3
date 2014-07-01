package visual.componentes;

import java.util.ArrayList;

public class Calendario {
	
	private ArrayList<String> diasDeSemana = new ArrayList<String>();
	private int hora;
	private int diaActual;
	
	public Calendario(){
		diasDeSemana.add("Lunes");
		diasDeSemana.add("Martes");
		diasDeSemana.add("Miercoles");
		diasDeSemana.add("Jueves");
		diasDeSemana.add("Viernes");
		diasDeSemana.add("Sabado");
		diasDeSemana.add("Domingo");	
		
		hora = 7;
		diaActual = 0;
	}
	
	public int obtenerHora(){
		return hora;
	}
	
	public String obtenerDiaActual(){
		return diasDeSemana.get(diaActual);
	}
	
	@SuppressWarnings("static-access")
	public void sumarTiempo(int unValor) throws InterruptedException{
		while(unValor > 0){
			Thread.currentThread().sleep(20);
			hora++;
			if (hora > 24){
				hora = 0;
				diaActual++;
			}
			unValor--;			
		}
	}
	
}
