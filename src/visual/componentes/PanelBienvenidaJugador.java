package visual.componentes;

import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import JuegoPorConsola.GeneradorDePartidas;

import modeloTp.ComputadoraPolicial;
import modeloTp.Jugador;

public class PanelBienvenidaJugador {
	
	private JPanel bienvenidaJugador = new JPanel();
	
	public PanelBienvenidaJugador(JFrame unaVentana, JTextField unCampo) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas juego = new GeneradorDePartidas(null,null,null);
		ComputadoraPolicial computadora = new ComputadoraPolicial(juego.generarListaDeLadrones());
		Jugador jugador = new Jugador(unCampo.getText(), juego.obtenerRecorridoLadron().get(0), computadora);
		Calendario calendario = new Calendario();
		
		bienvenidaJugador.setLayout(null);
		JLabel bienvenido = new JLabel("Bienvenido, " + unCampo.getText());
		bienvenido.setFont(new Font("Arial",Font.BOLD,20));
		bienvenido.setBounds(20,35,300,30);
		bienvenidaJugador.add(bienvenido);
		
		JTextArea areaTexto = new JTextArea(
				"Tu nombre no aparece en los ficheros de la Interpol. Has sido identificado/a como " + unCampo.getText() + "."
				+ "\n"
				+ "\n"
				+ "Tu graduacion actual es: Novato."
				+ "\n"
				+ "\n"
				+ "NOTICIAS"
				+ "\n"
				+ "Tesoro nacional robado en " + juego.obtenerRecorridoLadron().get(0).obtenerNombre() + "."
				+ "\n"
				+ "Un sospechoso de sexo " + juego.obtenerLadronBuscado().obtenerSexo() + " ha sido visto en el lugar del crimen."
				+ "\n"
				+ "\n"
				+ "Tu mision:"
				+ "\n"
				+ "Perseguir al ladron desde " + juego.obtenerRecorridoLadron().get(0).obtenerNombre() + " hasta su escondite y arrestarlo."
				+ "\n"
				+ "Tienes que arrestar al ladron antes del domingo a las 17 hs."
				+ "\n"
				+ "\n"
				+ "Buena suerte, " + unCampo.getText() + "."
				);
		areaTexto.setOpaque(false);
		areaTexto.setFocusable(false);
		areaTexto.setFont(new Font("Arial",Font.BOLD,14));
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setBounds(15,105,660,250);
		bienvenidaJugador.add(areaTexto);
		
		JButton botonComenzar = new JButton("Comenzar");
		botonComenzar.setBounds(296,370,100,30);
		botonComenzar.addActionListener(new CargadorPantallaLugares(unaVentana,juego,jugador,calendario));
		bienvenidaJugador.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftPantallaBienvenida_img.jpg");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		bienvenidaJugador.add(fondo);
	}

	public JPanel obtenerPanel(){
		return bienvenidaJugador;
	}

}
