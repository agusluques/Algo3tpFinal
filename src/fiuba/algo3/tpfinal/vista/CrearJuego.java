package fiuba.algo3.tpfinal.vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.vista.programa.JuegoVista;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoError;

public class CrearJuego implements ActionListener {

	private JTextField nombreJUno;
	private JComboBox<String> razaJUno;
	private JComboBox<String> colorJUno;
	private JTextField nombreJDos;
	private JComboBox<String> razaJDos;
	private JComboBox<String> colorJDos;
	private JLabel miCapa;
	private JInternalFrame menu;
	private HashColores colores=new HashColores();

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
			try {
				verificarIgualdadDeColores(miCapa);
				verificarLargoDeNombres(miCapa);
				verificarIgualdadDeNombres(miCapa);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			jugadorUno.setColor(colores.get((String) colorJUno.getSelectedItem()));
		
			Jugador jugadorDos = (Jugador) hashDeRazas
					.get(razaJDos.getSelectedItem())
					.getDeclaredConstructor(String.class, Mapa.class)
					.newInstance(nombreJDos.getText(), mapa);
			jugadorDos.setColor(colores.get((String) colorJDos.getSelectedItem()));
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

	private void verificarIgualdadDeColores(Component frame) throws MalformedURLException {
		if (((String) colorJUno.getSelectedItem()).matches((String) colorJDos
				.getSelectedItem())) {
			new SonidoError();
			JOptionPane.showMessageDialog(frame, "Los colores no pueden ser iguales",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
	}

	private void verificarIgualdadDeNombres(Component frame) throws MalformedURLException {
		if (nombreJUno.getText().matches(nombreJDos.getText())) {
			new SonidoError();
			JOptionPane.showMessageDialog(frame, "Los nombres no pueden ser iguales",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
	}

	private void verificarLargoDeNombres(Component frame) throws MalformedURLException {
		if ((nombreJUno.getText().length() < 4)
				|| (nombreJDos.getText().length() < 4)) {
			new SonidoError();
			JOptionPane.showMessageDialog(frame, "El nombre debe tener 4 caracteres como maximo",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
	}



}
