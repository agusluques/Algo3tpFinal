package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class RefineriaVista extends Vista{
	
	private Refineria miRefineria;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public RefineriaVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/vespene.png")).getImage();
	}

	@Override
	public void setObservable(Observable refineria) {
				
		if (miRefineria == null){
			miRefineria = (Refineria) refineria;
			imagenes = new HashImagenesConColor(miRefineria.getJugador().getColor());
		}
		if(miRefineria.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("Refineria");
		}
		
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Refineria");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miRefineria.getVida());
		miPanel.add(capaVida);
	}
	
	public void actualizar() {
		if (miRefineria.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miRefineria.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
