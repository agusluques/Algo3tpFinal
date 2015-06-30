package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class PuertoEstelarProtossVista extends Vista {
	
	private PuertoEstelarProtoss miPuertoEstelar;
	private Image img;
	private Image fondo;
	
	public PuertoEstelarProtossVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable puertoEstelar) {
		img = (new ImageIcon("imagenes/construcciones/PuertoEstelarProtoss.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarProtoss) puertoEstelar;
		}
		crearPanel();
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Puerto Estelar");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miPuertoEstelar.getEscudo());
		miPanel.add(capaEscudo);
		
		miPanel.setVisible(false);
	}
	
	public void actualizar() {
		if (miPuertoEstelar.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miPuertoEstelar.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
