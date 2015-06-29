package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.vista.programa.JuegoVista;

public class CrearJuego implements ActionListener {

	private JTextField nombreJUno;
	private JComboBox<String> razaJUno;
	private JComboBox<String> colorJUno;
	private JTextField nombreJDos;
	private JComboBox<String> razaJDos;
	private JComboBox<String> colorJDos;
	private JLabel miCapa;
	private JInternalFrame menu;

	public CrearJuego(JInternalFrame elFrame, JLabel capa, JTextField nombreUno,
			JComboBox<String> razaUno, JComboBox<String> colorUno,
			JTextField nombreDos, JComboBox<String> razaDos,
			JComboBox<String> colorDos) {
		miCapa = capa;
		nombreJUno = nombreUno;
		razaJUno = razaUno;
		colorJUno = colorUno;
		nombreJDos = nombreDos;
		razaJDos = razaDos;
		colorJDos = colorDos;
		menu = elFrame;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!datosSonCorrectos()) {
			JInternalFrame frame = crearVentanaDeError();
			verificarLargoDeNombres(frame);
			verificarIgualdadDeNombres(frame);
			verificarIgualdadDeColores(frame);
			return;
		}
		menu.setVisible(false);
		HashMap<String, Class<?>> hashDeRazas = new HashMap<String, Class<?>>();
		hashDeRazas.put("Terran", JugadorTerran.class);
		hashDeRazas.put("Protoss", JugadorProtoss.class);
		Mapa mapa;
		try {
			String direccionDelMapa = this.elegirMapa();
			mapa = new Mapa(direccionDelMapa);
			Jugador jugadorUno = (Jugador) hashDeRazas
					.get(razaJUno.getSelectedItem())
					.getDeclaredConstructor(String.class, Mapa.class)
					.newInstance(nombreJUno.getText(), mapa);
			Jugador jugadorDos = (Jugador) hashDeRazas
					.get(razaJDos.getSelectedItem())
					.getDeclaredConstructor(String.class, Mapa.class)
					.newInstance(nombreJDos.getText(), mapa);

			Juego nuevoJuego = new Juego(jugadorUno, jugadorDos, mapa);
			new JuegoVista(miCapa, nuevoJuego);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String elegirMapa() {
		ArrayList<String> mapas = new ArrayList<String>();
		mapas.add("mapaTierra.txt");
		Random generadorDePosicionAleatoria = new Random();
		int posicionAleatoria = generadorDePosicionAleatoria.nextInt(mapas
				.size());
		return mapas.get(posicionAleatoria);
	}

	private boolean datosSonCorrectos() {
		return (!((String) colorJUno.getSelectedItem())
				.matches((String) colorJDos.getSelectedItem()))
				&& !(nombreJUno.getText().matches(nombreJDos.getText()))
				&& !((nombreJUno.getText().length() < 4) || (nombreJDos
						.getText().length() < 4));
	}

	private void verificarIgualdadDeColores(JInternalFrame frame) {
		if (((String) colorJUno.getSelectedItem()).matches((String) colorJDos
				.getSelectedItem())) {
			JLabel label = new JLabel(
					"El color de los jugadores deben ser distintos");
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.pack();
			miCapa.add(frame);
		}
	}

	private void verificarIgualdadDeNombres(JInternalFrame frame) {
		if (nombreJUno.getText().matches(nombreJDos.getText())) {
			JLabel label = new JLabel(
					"El nombre de los jugadores deben ser distintos");
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.pack();
			miCapa.add(frame);
		}
	}

	private void verificarLargoDeNombres(JInternalFrame frame) {
		if ((nombreJUno.getText().length() < 4)
				|| (nombreJDos.getText().length() < 4)) {
			JLabel label = new JLabel(
					"El nombre de los jugadores debe ser de al menos cuatro caracteres");
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.pack();
			miCapa.add(frame);
		}
	}

	private JInternalFrame crearVentanaDeError() {
		JInternalFrame frame = new JInternalFrame("Error!");
		frame.setBackground(Color.RED);
		frame.getContentPane().setBackground(Color.RED);
		frame.setSize(1000, 1000);
		frame.setLocation(miCapa.getWidth() / 2, miCapa.getHeight() / 2);
		frame.setClosable(true);
		frame.setVisible(true);

		JButton aceptar = new JButton("OK");
		aceptar.addActionListener(new AccionCerrarVentanaEmergente(frame));
		frame.getContentPane().add(aceptar, BorderLayout.AFTER_LAST_LINE);

		return frame;
	}

}
