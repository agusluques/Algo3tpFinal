package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class AccionNuevoJuego implements ActionListener {

	JLabel miCapa;

	public AccionNuevoJuego(JLabel capa) {
		miCapa = capa;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent e) {
		// Creo la ventanita chiquita, le seteo el tamanio, la posicion y la
		// visibilidad
		JInternalFrame frame = new JInternalFrame("Creacion de los jugadores");
		frame.setResizable(true);
		frame.setClosable(true);
		frame.setSize(641, 147);
		frame.setLocation(10, 10);
		frame.setVisible(true);

		// Creo division
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		// Creo las opciones de as razas y colores
		String[] razas = { "Terran", "Protoss" };
		String[] colores = { "Rojo", "Azul", "Amarillo", "Verde", "Naranja",
				"Violeta" };

		// Creo el ingreso de nombre Jugador Uno
		JPanel panelUno = new JPanel();
		JLabel nombreJugadorUno = new JLabel("Nombre Jugador Uno:");
		JTextField nombreUno = new JTextField(21);
		nombreUno.addKeyListener(new LectorDeLetras());
		JLabel razaJugadorUno = new JLabel("Raza Jugador Uno:");
		JComboBox razaUno = new JComboBox(razas);
		JLabel colorJugadorUno = new JLabel("Color Jugador Uno:");
		JComboBox colorUno = new JComboBox(colores);
		panelUno.add(nombreJugadorUno);
		panelUno.add(nombreUno);
		panelUno.add(razaJugadorUno);
		panelUno.add(razaUno);
		panelUno.add(colorJugadorUno);
		panelUno.add(colorUno);
		splitPane.setLeftComponent(panelUno);

		// Creo el ingreso de nombre Jugador Dos
		JPanel panelDos = new JPanel();
		JLabel nombreJugadorDos = new JLabel("Nombre Jugador Dos:");
		JTextField nombreDos = new JTextField(21);
		nombreUno.addKeyListener(new LectorDeLetras());
		JLabel razaJugadorDos = new JLabel("Raza Jugador Dos:");
		JComboBox razaDos = new JComboBox(razas);
		JLabel colorJugadorDos = new JLabel("Color Jugador Dos:");
		JComboBox colorDos = new JComboBox(colores);
		panelDos.add(nombreJugadorDos);
		panelDos.add(nombreDos);
		panelDos.add(razaJugadorDos);
		panelDos.add(razaDos);
		panelDos.add(colorJugadorDos);
		panelDos.add(colorDos);
		splitPane.setRightComponent(panelDos);

		// Creo el boton "Aceptar"
		JButton aceptar = new JButton();
		aceptar.addActionListener(new CrearJuego(frame,miCapa, nombreUno, razaUno,
				colorUno, nombreDos, razaDos, colorDos));
		aceptar.setText("Aceptar");
		frame.getContentPane().add(aceptar, BorderLayout.AFTER_LAST_LINE);

		// Agrego la ventanita chiquita a la capa
		frame.pack();
		miCapa.add(frame);
		try {
			frame.setSelected(true);

		} catch (java.beans.PropertyVetoException e1) {
		}
	}

}
