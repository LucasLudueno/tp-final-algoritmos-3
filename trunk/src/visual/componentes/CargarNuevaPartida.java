package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modeloTp.GeneradorDePartidas;

public class CargarNuevaPartida implements ActionListener {
	
	JTextField campo;
	JFrame ventana;
	GeneradorDePartidas juego;
	
	public CargarNuevaPartida(JFrame unaVentana, JTextField unCampo) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		this.campo = unCampo;
		this.ventana = unaVentana;
		this.juego = new GeneradorDePartidas();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		PanelBienvenidaJugador panelBienvenida = new PanelBienvenidaJugador(campo.getText(),juego.obtenerRecorridoLadron().get(0).obtenerNombre(),juego.obtenerLadronBuscado().obtenerSexo());
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelBienvenida.obtenerPanel());
		ventana.revalidate();
	}

}
