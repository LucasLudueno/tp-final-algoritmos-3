package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class CargarSiguienteCaso implements ActionListener{
	
	private JFrame ventana;
	private String nombre;
	
	public CargarSiguienteCaso(JFrame unaVentana, String unNombre){
		this.ventana = unaVentana;
		this.nombre = unNombre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSiguienteCaso panel = null;
		try {
			panel = new PanelSiguienteCaso(ventana,nombre);
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel.obtenerPanel());
		ventana.revalidate();
	}
}
