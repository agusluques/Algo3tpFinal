package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NexoMineralVista extends Vista{
	
	private NexoMineral miNexo;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public NexoMineralVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/mineral.png")).getImage();
	}

	@Override
	public void setObservable(Observable nexo) {
		
	
		if (miNexo == null){
			miNexo = (NexoMineral) nexo;
			imagenes = new HashImagenesConColor(miNexo.getJugador().getColor());
		}
		if(miNexo.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("NexoMineral");
		}
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Nexo mineral");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miNexo.getCantidadDeVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miNexo.getCantidadDeEscudo());
		miPanel.add(capaEscudo);
	}
	
	@Override
	public void actualizar() {
		if (miNexo.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
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
