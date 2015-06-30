package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NexoMineralVista extends Vista{
	
	private NexoMineral miNexo;
	private Image img;
	private Image fondo;
	
	public NexoMineralVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable nexo) {
		img = (new ImageIcon("imagenes/construcciones/NexoMineral.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/mineral.png")).getImage();
		if (miNexo == null){
			miNexo = (NexoMineral) nexo;
		}
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Nexo mineral");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miNexo.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miNexo.getEscudo());
		miPanel.add(capaEscudo);
	}
	
	public void actualizar() {
		if (miNexo.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miNexo.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
