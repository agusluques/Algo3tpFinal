package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class PuertoEstelarTerranVista extends Vista{
	
	private PuertoEstelarTerran miPuertoEstelar;
	private Image img;
	private Image fondo;
	
	public PuertoEstelarTerranVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable refineria) {
		img = (new ImageIcon("imagenes/construcciones/PuertoEstelarTerran.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarTerran) refineria;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Puerto estelar");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getVida());
		miPanel.add(capaVida);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miPuertoEstelar.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
