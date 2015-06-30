package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AireVista extends Vista {

	private Image img;
	@SuppressWarnings("unused")
	private Aire miAire;

	public AireVista() {
		img = (new ImageIcon("imagenes/superficies/aire.png")).getImage();

	}
	
	@Override
	public void setObservable(Observable aire) {
		if (miAire == null){
			miAire = (Aire) aire;
		}
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Aire");
		miPanel.add(capaNombre);
		
		miPanel.setVisible(false);
		
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 40, 40, null);
	}
}
