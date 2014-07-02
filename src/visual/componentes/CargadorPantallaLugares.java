package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;

import JuegoPorConsola.GeneradorDePartidas;

import modeloTp.Jugador;

public class CargadorPantallaLugares implements ActionListener{
	
	private JFrame ventana;
	private GeneradorDePartidas generador;
	private Jugador jugador;
	private Calendario calendario;
	
	public CargadorPantallaLugares (JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario){
		this.ventana = unaVentana;
		this.generador = generador;
		this.jugador = unJugador;
		this.calendario = calendario;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenu archivo = (JMenu) ventana.getJMenuBar().getComponent(0);
		archivo.getItem(0).setEnabled(true);
		archivo.getItem(0).addActionListener(new CargarSiguienteCaso(ventana,jugador.obtenerNombre()));
		PanelLugares panel = new PanelLugares(ventana,generador,jugador,calendario);
		
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel.obtenerPanel());
		ventana.revalidate();		
	}
	
}
