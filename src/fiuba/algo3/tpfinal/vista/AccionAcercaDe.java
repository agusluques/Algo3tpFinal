package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class AccionAcercaDe implements ActionListener {

	private JLabel miCapa;

	public AccionAcercaDe(JLabel capa) {
		miCapa = capa;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Creo la ventanita chiquita, le seteo el tamanio, la posicion y la
		// visibilidad
		JInternalFrame frame = new JInternalFrame("Acerca de Algocraft");
		frame.setClosable(true);
		frame.setSize(500, 500);
		frame.setLocation(10, 10);
		frame.setVisible(true);

		// Agrego la informacion
		JPanel panelUno = new JPanel();
		JLabel informacion = new JLabel(
				"Trabajo practico final de 'Algoritmos y Programacion III'");
		informacion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(
				51, 51, 51), null));
		informacion.setBackground(new Color(0, 0, 0));
		informacion.setFont(new Font("Stencil", informacion.getFont()
				.getStyle(), informacion.getFont().getSize() + 13));
		panelUno.add(informacion);

		JPanel panelDos = new JPanel();
		JLabel datos = new JLabel("Los alumnos que crearon este juego son:");
		datos.setFont(new Font("Stencil", datos.getFont().getStyle(), datos
				.getFont().getSize() + 9));
		panelDos.add(datos);

		JPanel panelTres = new JPanel();
		JLabel creadores = new JLabel("Agustin, Damian y Luciano");
		creadores.setFont(new Font("Sylfaen", creadores.getFont().getStyle(),
				creadores.getFont().getSize() + 9));
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
