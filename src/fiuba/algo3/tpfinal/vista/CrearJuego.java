package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiuba.algo3.tpfinal.excepciones.LargoDeNombreInvalido;
import fiuba.algo3.tpfinal.excepciones.NombresIguales;
import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("unused")
public class CrearJuego implements ActionListener{
	
	private JTextField nombreJUno;
	private JComboBox<String> razaJUno;
	private JComboBox<String> colorJUno;
	private JTextField nombreJDos;
	private JComboBox<String> razaJDos;
	private JComboBox<String> colorJDos;
	private JLabel miCapa;

	public CrearJuego(JLabel capa, JTextField nombreUno, JComboBox<String> razaUno, JComboBox<String> colorUno, JTextField nombreDos, JComboBox<String> razaDos, JComboBox<String> colorDos) {
		miCapa = capa;
		nombreJUno = nombreUno;
		razaJUno = razaUno;
		colorJUno = colorUno;
		nombreJDos = nombreDos;
		razaJDos = razaDos;
		colorJDos = colorDos;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!datosSonCorrectos()) {
			System.out.println("Error");
			JInternalFrame frame = crearVentanaDeError();
			verificarLargoDeNombres(frame);
			verificarIgualdadDeNombres(frame);
			verificarIgualdadDeColores(frame);
			return;
		}
		
		System.out.println("OK");
		HashMap<String, Class<?>> hashDeRazas = new HashMap<String, Class<?>>();
		hashDeRazas.put("Terran", JugadorTerran.class);
		hashDeRazas.put("Protoss", JugadorProtoss.class);
		Mapa mapa;
		try {
			mapa = new Mapa("mapaTierra.txt");
			Jugador jugadorUno = (Jugador) hashDeRazas.get(razaJUno.getSelectedItem()).getDeclaredConstructor(Jugador.class, Mapa.class).newInstance(nombreJUno.getText(), mapa);
			Jugador jugadorDos = (Jugador) hashDeRazas.get(razaJDos.getSelectedItem()).getDeclaredConstructor(Jugador.class, Mapa.class).newInstance(nombreJDos.getText(), mapa);
			
			Juego nuevoJuego = new Juego(jugadorUno, jugadorDos, mapa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private boolean datosSonCorrectos() {
		return (!((String) colorJUno.getSelectedItem())
				.matches((String) colorJDos.getSelectedItem()))
				&& !(nombreJUno.getText().matches(nombreJDos.getText()))
				&& !((nombreJUno.getText().length() < 4) || (nombreJDos
						.getText().length() < 4));
	}

	private void verificarIgualdadDeColores(JInternalFrame frame) {
		if (((String) colorJUno.getSelectedItem()).matches((String)colorJDos.getSelectedItem())) {
			JLabel label = new JLabel("El color de los jugadores deben ser distintos");
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.pack();
			miCapa.add(frame);
		}
	}

	private void verificarIgualdadDeNombres(JInternalFrame frame) {
		if (nombreJUno.getText().matches(nombreJDos.getText())) {
			JLabel label = new JLabel("El nombre de los jugadores deben ser distintos");
			frame.getContentPane().add(label, BorderLayout.CENTER);
			frame.pack();
			miCapa.add(frame);
		}
	}

	private void verificarLargoDeNombres(JInternalFrame frame) {
		if ((nombreJUno.getText().length() < 4) || (nombreJDos.getText().length() < 4)) {
			JLabel label = new JLabel("El nombre de los jugadores debe ser de al menos cuatro caracteres");
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
		frame.setLocation(miCapa.getWidth()/2, miCapa.getHeight()/2);
		frame.setClosable(true);
		frame.setVisible(true);
		return frame;
	}

}
