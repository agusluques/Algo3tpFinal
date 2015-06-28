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
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ZealotVista extends Vista implements Observador {

	private Zealot miZealot;
	private JInternalFrame miVentanaDeAccion;
	private JPanel miPanel;
	private Image img;
	private Image fondo;

	public ZealotVista() {
		setPreferredSize(new Dimension(40, 40));
		setBackground(Color.GRAY);
	}

	/*
	 * public MarineVista() { super("/imagenes/unidades/Zealot.png"); }
	 */

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirMenuObservador() {
	
		miVentanaDeAccion.add(miPanel);
		miPanel.setVisible(true);
		System.out.println("Hiciste click en un Zealot fiera!");
	}

	@Override
	public void ocultarMenuObservador() {
	
		miPanel.setVisible(false);
		miVentanaDeAccion.remove(miPanel);
		
		System.out.println("Clickeaste en otra cosa que no es un Zealot loco!");

	}

	@Override
	public void setObservable(Observable zealot) {
		img = (new ImageIcon("imagenes/zealot.png")).getImage();
		fondo = (new ImageIcon("imagenes/tierra.png")).getImage();
		miZealot = (Zealot) zealot;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Zealot");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miZealot.getVida());
		miPanel.add(capaVida);
		JLabel capaEscudo = new JLabel("Escudo: " + miZealot.getEscudo());
		miPanel.add(capaEscudo);
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
