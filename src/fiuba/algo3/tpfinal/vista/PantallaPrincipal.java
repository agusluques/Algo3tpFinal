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

public class PantallaPrincipal {

	JFrame ventanaPrincipal;

	public PantallaPrincipal() throws LineUnavailableException, IOException,
			UnsupportedAudioFileException {
		// Creo la ventana principal
		ventanaPrincipal = new JFrame("AlgoCraft");
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"imagenes/logo.png"));
		ventanaPrincipal.setBounds(100, 100, 750, 500);
		// creo una capa en la ventana, le seteo una imagen y dejo la ventana
		// como visible
		JLabel capa = new JLabel(new ImageIcon("imagenes/algocraft.jpg"));
		ventanaPrincipal.getContentPane().add(capa);
		// ventanaPrincipal.pack();

		// Le agrego el sonido
		HiloSonido sonido = new HiloSonido(
				"sonidos/sonidoPantallaPrincipal.wav");
		sonido.start();

		// creo la barra de menus
		JMenuBar barraMenu = new JMenuBar();

		// Creo el primer menu y lo agrego a la barra
		JMenu menuJuego = new JMenu("Juego");
		barraMenu.add(menuJuego);

		// Creo el primer item del menu, lo agrego al mismo y le seteo su accion
		JMenuItem menuItem = new JMenuItem("Nuevo juego");
		menuItem.addActionListener(new AccionNuevoJuego(capa));
		menuJuego.add(menuItem);

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
		itemAcercaDe.addActionListener(new AccionAcercaDe(capa));
		menuAyuda.add(itemAcercaDe);

		// Agrego la barra de menu a la ventana principal
		ventanaPrincipal.setJMenuBar(barraMenu);

		ventanaPrincipal.setVisible(true);

	}
}
