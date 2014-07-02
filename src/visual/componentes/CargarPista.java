package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

public class CargarPista implements ActionListener{
	
	private int numeroDeLugar;
	private JFrame ventana;
	private GeneradorDePartidas generador;
	private Jugador jugador;
	private Calendario calendario;
	private int arrestos;

	public CargarPista(int numeroDeLugar, JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		this.numeroDeLugar = numeroDeLugar;
		this.ventana = unaVentana;
		this.generador = generador;
		this.jugador = unJugador;
		this.calendario = calendario;
		this.arrestos = arrestos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelPistas panel = new PanelPistas(numeroDeLugar,ventana,generador,jugador,calendario,arrestos);
		
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel.obtenerPanel());
		ventana.revalidate();
	}
	
}
