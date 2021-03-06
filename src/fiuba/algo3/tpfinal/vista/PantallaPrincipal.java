package fiuba.algo3.tpfinal.vista;

import java.awt.Toolkit;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fiuba.algo3.tpfinal.controlador.AccionAcercaDe;
import fiuba.algo3.tpfinal.controlador.AccionCrearJuegoAvanzado;
import fiuba.algo3.tpfinal.controlador.AccionIniciarApagarSonido;
import fiuba.algo3.tpfinal.controlador.AccionNuevoJuego;
import fiuba.algo3.tpfinal.controlador.AccionSalir;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoPrincipal;


public class PantallaPrincipal {

	JFrame ventanaPrincipal;

	public PantallaPrincipal() throws LineUnavailableException, IOException,
			UnsupportedAudioFileException {
		
		crearVentanaPrincipal();
		
		JLabel capa = crearFondo();

		SonidoPrincipal sonido = crearSonido();

		crearBarraDeMenu(capa, sonido);

		ventanaPrincipal.setVisible(true);

	}

	private void crearBarraDeMenu(JLabel capa, SonidoPrincipal sonido) {
		// creo la barra de menus
		JMenuBar barraMenu = new JMenuBar();

		// Creo el primer menu y lo agrego a la barra
		JMenu menuJuego = new JMenu("Juego");
		barraMenu.add(menuJuego);

		// Creo el primer item del menu, lo agrego al mismo y le seteo su accion
		JMenuItem menuItem = new JMenuItem("Nuevo juego");
		menuItem.addActionListener(new AccionNuevoJuego(capa));
		menuJuego.add(menuItem);
		
		JMenuItem menuJuegoAvanzado = new JMenuItem("Crear juego avanzado");
		menuJuegoAvanzado.addActionListener(new AccionCrearJuegoAvanzado(capa));
		menuJuego.add(menuJuegoAvanzado);

		// Creo el item de salir, le vinculo su accion y lo agrego al menu
		JMenuItem itemSalir = new JMenuItem("Salir");
		menuJuego.add(itemSalir);
		itemSalir.addActionListener(new AccionSalir());

		// Creo el menu de opciones y lo agrego a la barra
		JMenu menuOpciones = new JMenu("Opciones");
		barraMenu.add(menuOpciones);

		// Creo el item de Apagar/Iniciar sonido, lo agrego y le seteo su accion
		JMenuItem itemIniciarApagarSonido = new JMenuItem(
				"Iniciar/Apagar sonido");
		itemIniciarApagarSonido
				.addActionListener(new AccionIniciarApagarSonido(sonido));
		menuOpciones.add(itemIniciarApagarSonido);

		// Creo el menu de ayuda y lo agrego a la barra
		JMenu menuAyuda = new JMenu("Ayuda");
		barraMenu.add(menuAyuda);

		// Creo el item de Acerca de, lo agrego y le seteo su accion
		JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
		itemAcercaDe.addActionListener(new AccionAcercaDe());
		menuAyuda.add(itemAcercaDe);

		// Agrego la barra de menu a la ventana principal
		ventanaPrincipal.setJMenuBar(barraMenu);
	}

	private SonidoPrincipal crearSonido() throws LineUnavailableException,
			IOException, UnsupportedAudioFileException {
		// Le agrego el sonido
		SonidoPrincipal sonido = new SonidoPrincipal();
		return sonido;
	}

	private JLabel crearFondo() {
		// creo una capa en la ventana, le seteo una imagen y dejo la ventana
		// como visible
		JLabel capa = new JLabel(new ImageIcon("imagenes/algocraft.jpg"));
		ventanaPrincipal.getContentPane().add(capa);
		// ventanaPrincipal.pack();
		return capa;
	}

	private void crearVentanaPrincipal() {
		// Creo la ventana principal
		ventanaPrincipal = new JFrame("AlgoCraft");
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ventanaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/logo.jpg"));
		ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		ventanaPrincipal.setBounds(0, 0, 1000, 800);
	}
}
