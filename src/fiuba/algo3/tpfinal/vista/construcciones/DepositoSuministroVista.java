package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DepositoSuministroVista extends Vista{
	
	private DepositoSuministro miDeposito;
	private Image img;
	private Image fondo;
	
	public DepositoSuministroVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable deposito) {
		img = (new ImageIcon("imagenes/construcciones/DepositoDeSuministro.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miDeposito == null){
			miDeposito = (DepositoSuministro) deposito;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Deposito suministro");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miDeposito.getVida());
		miPanel.add(capaVida);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miDeposito.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
