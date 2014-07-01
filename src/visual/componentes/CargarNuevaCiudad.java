package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modeloTp.ExcepcionNoHayMasTiempo;
import modeloTp.GeneradorDePartidas;
import modeloTp.Jugador;

public class CargarNuevaCiudad implements ActionListener {
	
	private JFrame ventana;
	private GeneradorDePartidas generador;
	private Jugador jugador;
	private Calendario calendario;
	private int valor;
	
	public CargarNuevaCiudad(int valor, JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario){
		this.ventana = unaVentana;
		this.generador = generador;
		this.jugador = unJugador;
		this.calendario = calendario;
		this.valor = valor;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			jugador.viajar(jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(valor));
		} catch (ExcepcionNoHayMasTiempo e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(generador.obtenerPasoActual() < (generador.obtenerRecorridoLadron().size()-1)){
    		if(jugador.obtenerCiudadActual() == generador.obtenerRecorridoLadron().get(generador.obtenerPasoActual()+1)){
    			try {
					generador.pasarALaSiguienteCiudadDelRecorrido();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
		
		PanelLugares panel = new PanelLugares(ventana,generador,jugador,calendario);
		
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel.obtenerPanel());
		ventana.revalidate();	
	}

}