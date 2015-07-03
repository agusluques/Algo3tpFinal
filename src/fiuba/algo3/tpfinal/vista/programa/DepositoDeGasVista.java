package fiuba.algo3.tpfinal.vista.programa;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DepositoDeGasVista extends Vista {

	private Image img;
	private DepositoDeGas miGas;

	public DepositoDeGasVista() {
		img = (new ImageIcon("imagenes/superficies/vespene.png")).getImage();

	}
	
	@Override
	public void setObservable(Observable gas) {
		if (miGas == null){
			miGas = (DepositoDeGas) gas;
		}
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Gas Vespeno");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaRecursos = new JLabel("Gas restante: "+miGas.getRecursos());
		capaRecursos.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaRecursos);
		
		miPanel.setVisible(false);
		
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
