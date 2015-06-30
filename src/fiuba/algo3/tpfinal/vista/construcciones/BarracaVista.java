package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class BarracaVista extends Vista{

	private Barraca miBarraca;
	private Image img;
	private Image fondo;
	
	public BarracaVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable barraca) {
		img = (new ImageIcon("imagenes/construcciones/Barraca.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miBarraca == null){
			miBarraca = (Barraca) barraca;
		}
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Barraca");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miBarraca.getVida());
		miPanel.add(capaVida);
	}
	
	public void actualizar() {
		if (miBarraca.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miBarraca.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}
}
