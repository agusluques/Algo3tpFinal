package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class CentroDeMineralVista extends Vista {
	
	private CentroDeMineral miCentroDeMineral;
	private Image img;
	private Image fondo;
	
	public CentroDeMineralVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable centroDeMineral) {
		img = (new ImageIcon("imagenes/construcciones/CentroMineral.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/mineral.png")).getImage();
		if (miCentroDeMineral == null){
			miCentroDeMineral = (CentroDeMineral) centroDeMineral;
		}
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Centro de mineral");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miCentroDeMineral.getVida());
		miPanel.add(capaVida);
	}
	
	public void actualizar() {
		if (miCentroDeMineral.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
