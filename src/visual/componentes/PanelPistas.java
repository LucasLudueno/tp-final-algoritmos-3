package visual.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modeloTp.GeneradorDePartidas;
import modeloTp.Jugador;
import modeloTp.JugadorNovato;

public class PanelPistas implements ActionListener{
	
	private JPanel panelPistas = new JPanel();
	private JFrame ventana;
	
	public PanelPistas(int numeroDeLugar, JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario){
		panelPistas.setLayout(null);
		
		JLabel fecha = new JLabel(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.setBounds(510,33,150,40);
		fecha.setFont(new Font("Arial",Font.BOLD,21));
		fecha.setForeground(Color.WHITE);
		panelPistas.add(fecha);
		
		JLabel lugares = new JLabel(unJugador.obtenerCiudadActual().obtenerLugares().get(numeroDeLugar).obtenerNombre());
		lugares.setBounds(30,95,230,40);
		lugares.setFont(new Font("Arial",Font.BOLD,16));
		panelPistas.add(lugares);
		
		JTextArea contenidoPista = new JTextArea(unJugador.obtenerCiudadActual().obtenerLugares().get(numeroDeLugar).devolverPista((JugadorNovato) unJugador).obtenerContenido());
		contenidoPista.setOpaque(false);
		contenidoPista.setFocusable(false);
		contenidoPista.setFont(new Font("Arial",Font.BOLD,14));
		contenidoPista.setBounds(30,140,630,200);
		contenidoPista.setLineWrap(true);
		contenidoPista.setWrapStyleWord(true);
		panelPistas.add(contenidoPista);
		
		JLabel nombreCiudadActual = new JLabel(unJugador.obtenerCiudadActual().obtenerNombre());
		nombreCiudadActual.setBounds(30,33,330,40);
		nombreCiudadActual.setFont(new Font("Arial",Font.BOLD,21));
		nombreCiudadActual.setForeground(Color.WHITE);
		panelPistas.add(nombreCiudadActual);
		
		ImageIcon imagenBotonSalida = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonSalida_img.png");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		botonSalida.addActionListener(new PanelCiudadesAViajar(unaVentana,generador,unJugador,calendario));
		panelPistas.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonInvestigar_img.png");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		botonInvestigar.addActionListener(new CargadorPantallaLugares(unaVentana,generador,unJugador,calendario));
		panelPistas.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonComputadora_img.png");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		panelPistas.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftPantallaLugares_img.png");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelPistas.add(fondo);
		
		this.ventana = unaVentana;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelPistas);
		ventana.revalidate();
	}

}
