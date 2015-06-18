package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PantallaPrincipal {

	JFrame ventanaPrincipal;

	public PantallaPrincipal(){
		//Creo la ventana principal
		ventanaPrincipal = new JFrame("AlgoCraft");
		//creo una capa en la ventana, le seteo una imagen y dejo la ventana como visible
		JLabel capa = new JLabel(new ImageIcon("imagenes/algocraft_1.jpg"));
		ventanaPrincipal.add(capa);
		ventanaPrincipal.pack();
		ventanaPrincipal.setVisible(true);
		
		//creo la barra de menus
		JMenuBar barraMenu = new JMenuBar();
		
		//Creo el primer menu y lo agrego a la barra
		JMenu menuJuego = new JMenu("Juego");
		barraMenu.add(menuJuego);
		
		//Creo el primer item del menu, lo agrego al mismo y le seteo su accion
		JMenuItem menuItem = new JMenuItem("Nuevo juego");
		ActionListener accionNuevoJuego = new AccionNuevoJuego(capa);
		menuItem.addActionListener(accionNuevoJuego);
		menuJuego.add(menuItem);
		
		//Creo el item de salir, le vinculo su accion y lo agrego al menu
		JMenuItem itemSalir = new JMenuItem("Salir");
		menuJuego.add(itemSalir);
		itemSalir.addActionListener(new AccionSalir());
		
		//Agrego la barra de menu a la ventana principal
		ventanaPrincipal.setJMenuBar(barraMenu);
	
	}
}
