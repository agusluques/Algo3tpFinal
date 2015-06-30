package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AccesoVista extends Vista {
	
	private Acceso miAcceso;
	private Image img;
	private Image fondo;
	
	public AccesoVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable acceso) {
		img = (new ImageIcon("imagenes/construcciones/Acceso.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miAcceso == null){
			miAcceso = (Acceso) acceso;
		}
		crearPanel();
		miPanel.setVisible(false);
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Acceso");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAcceso.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miAcceso.getEscudo());
		miPanel.add(capaEscudo);
	}
	
	public void actualizar() {
		if (miAcceso.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miAcceso.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
