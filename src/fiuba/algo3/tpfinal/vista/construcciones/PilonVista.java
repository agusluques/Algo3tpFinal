package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class PilonVista extends Vista{
	
	private Pilon miPilon;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public PilonVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable pilon) {
		
		
		if (miPilon == null){
			miPilon = (Pilon) pilon;
			imagenes = new HashImagenesConColor(miPilon.getJugador().getColor());
		}
		if(miPilon.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("Pylon");
		}

	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Pilon");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPilon.getCantidadDeVida() + "   Escudo: " + miPilon.getCantidadDeEscudo());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
			
		if(miPilon.getTiempoRestante()>0){
			JLabel enConstruccion = new JLabel("Edificio en Construccion");
			enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(enConstruccion);
			
			JLabel tiempo = new JLabel("Tiempo restante: " + miPilon.getTiempoRestante());
			tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(tiempo);
		}
	}
	
	@Override
	public void actualizar() {
		if (miPilon.estaMuerto()){
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
		if (!miPilon.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
