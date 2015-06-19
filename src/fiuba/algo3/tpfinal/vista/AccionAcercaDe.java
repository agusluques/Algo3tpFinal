package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccionAcercaDe implements ActionListener {

	private JLabel miCapa;

	public AccionAcercaDe(JLabel capa) {
		miCapa = capa;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Creo la ventanita chiquita, le seteo el tamanio, la posicion y la
		// visibilidad
		JInternalFrame frame = new JInternalFrame("Acerca de Algocraft");
		frame.setSize(500, 500);
		frame.setLocation(10, 10);
		frame.setVisible(true);
		
		//Agrego la informacion
		JPanel panelUno = new JPanel();
		JLabel informacion = new JLabel("Trabajo practico final de 'Algoritmos y Programacion III'");
		panelUno.add(informacion);
		
		JPanel panelDos = new JPanel();
		JLabel datos = new JLabel("Los alumnos que crearon este juego son:");
		panelDos.add(datos);
		
		JPanel panelTres = new JPanel();
		JLabel creadores = new JLabel("Agustin, Damian y Luciano");
		panelTres.add(creadores);
		
		frame.getContentPane().add(panelUno, BorderLayout.BEFORE_FIRST_LINE);
		frame.getContentPane().add(panelDos, BorderLayout.CENTER);
		frame.getContentPane().add(panelTres, BorderLayout.LINE_END);
		// Agrego la ventanita chiquita a la capa
		frame.pack();
		miCapa.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e1) {
		}

	}

}
