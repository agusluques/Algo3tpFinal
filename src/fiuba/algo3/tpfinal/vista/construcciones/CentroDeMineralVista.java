package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class CentroDeMineralVista extends Vista {
	
	private CentroDeMineral miCentroDeMineral;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public CentroDeMineralVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/mineral.png")).getImage();
	}

	@Override
	public void setObservable(Observable centroDeMineral) {
		
		
		if (miCentroDeMineral == null){
			miCentroDeMineral = (CentroDeMineral) centroDeMineral;
			imagenes = new HashImagenesConColor(miCentroDeMineral.getJugador().getColor());
		}
		if(miCentroDeMineral.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("CentroDeMineral");
		}

	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Centro de mineral");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miCentroDeMineral.getVida());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miCentroDeMineral.getJugador())){
			if(miCentroDeMineral.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(enConstruccion);
				
				JLabel tiempo = new JLabel("Tiempo restante: " + miCentroDeMineral.getTiempoRestante());
				tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(tiempo);
			} else {
				JLabel recursos = new JLabel("Recursos restantes: "+((DepositoDeMinerales) miCentroDeMineral.getJugador().getMapa().getParcela(miCentroDeMineral.getPosicion()).getSuperficie()).getRecursos());
				recursos.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(recursos);
			}
		}
		
	}
	
	@Override
	public void actualizar() {
		if (miCentroDeMineral.estaMuerto()){
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miPanel.setVisible(true);
			miVentanaDeAccion.add(miPanel);
			
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miCentroDeMineral.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
