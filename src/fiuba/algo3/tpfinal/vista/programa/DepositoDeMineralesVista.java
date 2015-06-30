package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DepositoDeMineralesVista extends Vista {

	private Image img;
	@SuppressWarnings("unused")
	private DepositoDeMinerales miMineral;

	public DepositoDeMineralesVista() {
		img = (new ImageIcon("imagenes/superficies/mineral.png")).getImage();
	}
	
	@Override
	public void setObservable(Observable mineral) {
		if (miMineral == null){
			miMineral = (DepositoDeMinerales) mineral;
		}
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Mineral");
		miPanel.add(capaNombre);
		
		miPanel.setVisible(false);
		
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 40, 40, null);
	}
}
