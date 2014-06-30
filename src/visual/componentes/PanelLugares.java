package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLugares implements ActionListener{
	
	private JPanel panelLugares = new JPanel();
	private JFrame ventana;
	
	public PanelLugares(JFrame unaVentana){
		panelLugares.setLayout(null);
		
		
		
		ImageIcon imagenBotonSalida = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonSalida_img.png");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		panelLugares.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonInvestigar_img.png");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		panelLugares.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftBotonComputadora_img.png");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		panelLugares.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("svn/trunk/src/visual/recursos/AlgoThieftPantallaLugares_img.png");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelLugares.add(fondo);
		
		this.ventana = unaVentana;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelLugares);
		ventana.revalidate();
	}
}
