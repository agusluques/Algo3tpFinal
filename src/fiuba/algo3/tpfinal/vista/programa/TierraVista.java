package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class TierraVista extends Vista {

	private Image img;
	@SuppressWarnings("unused")
	private Tierra miTierra;

	public TierraVista() {
		img = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}
	
	@Override
	public void setObservable(Observable tierra) {
		if (miTierra == null){
			miTierra = (Tierra) tierra;
		}
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Tierra");
		miPanel.add(capaNombre);
		
		miPanel.setVisible(false);
		
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 40, 40, null);
	}
}
