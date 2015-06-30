package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class FabricaVista extends Vista{
	
	private Fabrica miFabrica;
	private Image img;
	private Image fondo;
	
	public FabricaVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable refineria) {
		img = (new ImageIcon("imagenes/construcciones/Fabrica.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miFabrica == null){
			miFabrica = (Fabrica) refineria;
		}
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Fabrica");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miFabrica.getVida());
		miPanel.add(capaVida);
	}
	
	public void actualizar() {
		if (miFabrica.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miFabrica.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
