package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class RefineriaVista extends Vista{
	
	private Refineria miRefineria;
	private Image img;
	private Image fondo;
	
	public RefineriaVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable refineria) {
		img = (new ImageIcon("imagenes/construcciones/Refineria.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/vespene.png")).getImage();
		if (miRefineria == null){
			miRefineria = (Refineria) refineria;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Refineria");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miRefineria.getVida());
		miPanel.add(capaVida);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miRefineria.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
