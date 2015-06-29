package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Scout;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ScoutVista extends Vista implements Observador {

	private Scout miScout;
	private JInternalFrame miVentanaDeAccion;
	private JPanel miPanel;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();

	public ScoutVista() {
		setPreferredSize(new Dimension(40, 40));

	}


	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void imprimirMenuObservador() {
	
		miVentanaDeAccion.add(miPanel);
		miPanel.setVisible(true);
		System.out.println("Hiciste click en un Scout fiera!");
	}

	@Override
	public void ocultarMenuObservador() {
	
		miPanel.setVisible(false);
		miVentanaDeAccion.remove(miPanel);
		
		System.out.println("Clickeaste en otra cosa que no es un Scout loco!");

	}

	@Override
	public void setObservable(Observable scout) {
		img = (new ImageIcon("imagenes/scout.png")).getImage();
		miScout = (Scout) scout;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Scout");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miScout.getVida());
		miPanel.add(capaVida);
		JLabel capaEscudo = new JLabel("Escudo: " + miScout.getEscudo());
		miPanel.add(capaEscudo);
		miPanel.setVisible(false);
		
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;

	}
	   public void paint(Graphics g) {
		   Coordenada miCoord = miScout.getCoordenada();
		   Class<?> sup = miScout.getJugador().getMapa().getParcela(miCoord).getSuperficie().getClass();
			
		   g.drawImage(imagenes.get(sup),0,0,40,40,null);
		   g.drawImage(img,0,0,40,40, null);

	   }
}

