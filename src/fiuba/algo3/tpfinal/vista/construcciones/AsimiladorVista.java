package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AsimiladorVista extends Vista{

	private Asimilador miAsimilador;
	private Image img;
	private Image fondo;
	
	public AsimiladorVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable pilon) {
		img = (new ImageIcon("imagenes/construcciones/Asimilador.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/vespene.png")).getImage();
		if (miAsimilador == null){
			miAsimilador = (Asimilador) pilon;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Asimilador");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAsimilador.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miAsimilador.getEscudo());
		miPanel.add(capaEscudo);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miAsimilador.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}
	}

	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);
	}
}
