package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import modeloTp.Jugador;

public class BuscadorSospechosos implements ActionListener{
	
	private Jugador jugador;
	private JTextArea pantalla;
	private JComboBox<String> sexo;
	private JComboBox<String> hobby;
	private JComboBox<String> pelo;
	private JComboBox<String> senias;
	private JComboBox<String> coche;
	
	public BuscadorSospechosos(Jugador unJugador, JTextArea unaPantalla, JComboBox<String> datosSexo, JComboBox<String> datosHobby, JComboBox<String> datosPelo, JComboBox<String> datosSenias, JComboBox<String> datosCoche){
		this.jugador = unJugador;
		this.pantalla = unaPantalla;
		this.sexo = datosSexo;
		this.hobby = datosHobby;
		this.pelo = datosPelo;
		this.senias = datosSenias;
		this.coche = datosCoche;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (jugador.emitirOrdenDeArresto(String.valueOf(sexo.getSelectedItem()),String.valueOf(hobby.getSelectedItem()),String.valueOf(pelo.getSelectedItem()),String.valueOf(senias.getSelectedItem()),String.valueOf(coche.getSelectedItem())) == true){
			pantalla.setText("Orden de arresto emitida contra "+jugador.obtenerNombreDeLadronBuscado());
		} else {
			pantalla.setText("No Hay Suficientes pistas para obtener coincidencias");
		}
		pantalla.repaint();
		pantalla.revalidate();
	}
}
