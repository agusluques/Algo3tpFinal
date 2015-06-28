package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista implements Observador {

	private Marine miMarine;
	private JInternalFrame miVentanaDeAccion;
	private JPanel miPanel;
	private Image img;
	private Image fondo;
	public MarineVista() {
		
	}

	/*
	 * public MarineVista() { super("/imagenes/unidades/Marine.png"); }
	 */

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirMenuObservador() {

		miVentanaDeAccion.add(miPanel);
		miPanel.setVisible(true);
		System.out.println("Hiciste click en un marine fiera!");
	}

	@Override
	public void ocultarMenuObservador() {
	
		miPanel.setVisible(false);
		miVentanaDeAccion.remove(miPanel);
		System.out.println("Clickeaste en otra cosa que no es un marine loco!");

	}

	@Override
	public void setObservable(Observable marine) {
		img = (new ImageIcon("imagenes/marine.png")).getImage();
		fondo = (new ImageIcon("imagenes/tierra.png")).getImage();
		miMarine = (Marine) marine;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Marine");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miMarine.getVida());
		miPanel.add(capaVida);
		miPanel.setVisible(false);
	
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;

	}

  


   public void paint(Graphics g) {
	   
	   
	
	   g.drawImage(fondo,0,0,40,40,null);
	   g.drawImage(img,0,0,40,40, null);

   }
}
