package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import visual.componentes.VentanaAcercaDe;

public class IniciarGUI {
	
	private JFrame ventana = new JFrame();
	
	public IniciarGUI(){
		ventana.setTitle("Algo Thieft");
		ventana.setBounds(230,150,700,500);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setJMenuBar(this.obtenerBarraDeMenu());
		ventana.setVisible(true);
	}
	
	private JMenuBar obtenerBarraDeMenu(){
		JMenu menuArchivo = new JMenu("Archivo");
		
		JMenuItem nuevo = new JMenuItem("Nuevo");
		menuArchivo.add(nuevo);
		
		JMenuItem guardar = new JMenuItem("Guardar");
		menuArchivo.add(guardar);
		
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}		
		});
		menuArchivo.add(salir);
		
		JMenu menuAcercaDe = new JMenu("Acerca de");
		
		JMenuItem acercaDe = new JMenuItem("Acerca de Algo Thieft");
		acercaDe.addActionListener(new VentanaAcercaDe());
		menuAcercaDe.add(acercaDe);
		
		JMenuBar menu = new JMenuBar();
		menu.add(menuArchivo);
		menu.add(menuAcercaDe);
		menu.setVisible(true);
		
		return menu;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		IniciarGUI gui = new IniciarGUI();
	}

}
