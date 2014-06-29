package visual.componentes;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelBienvenidaJugador {
	
	private JPanel bienvenidaJugador = new JPanel();
	
	public PanelBienvenidaJugador(String nombreJugador, String ciudadActual, String sexoLadron){
		bienvenidaJugador.setLayout(null);
		JLabel bienvenido = new JLabel("Bienvenido, " + nombreJugador);
		bienvenido.setFont(new Font("Arial",Font.BOLD,20));
		bienvenido.setBounds(20,35,300,30);
		bienvenidaJugador.add(bienvenido);
		
		JTextArea areaTexto = new JTextArea(
				"Tu nombre no aparece en los ficheros de la Interpol. Has sido identificado/a como " + nombreJugador + "."
				+ "\n"
				+ "\n"
				+ "Tu graduacion actual es: Novato."
				+ "\n"
				+ "\n"
				+ "NOTICIAS"
				+ "\n"
				+ "Tesoro nacional robado en " + ciudadActual + "."
				+ "\n"
				+ "Un sospechoso de sexo " + sexoLadron + " ha sido visto en el lugar del crimen."
				+ "\n"
				+ "\n"
				+ "Tu mision:"
				+ "\n"
				+ "Perseguir al ladron desde " + ciudadActual + " hasta su escondite y arrestarlo."
				+ "\n"
				+ "Tienes que arrestar al ladron antes del domingo a las 17 hs."
				+ "\n"
				+ "\n"
				+ "Buena suerte, " + nombreJugador + "."
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
		bienvenidaJugador.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftPantallaBienvenida_img.png");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		bienvenidaJugador.add(fondo);
	}
	
	public JPanel obtenerPanel(){
		return bienvenidaJugador;
	}

}
