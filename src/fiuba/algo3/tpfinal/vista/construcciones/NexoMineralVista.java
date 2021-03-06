package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
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

	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Nexo mineral");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miNexo.getCantidadDeVida() + "   Escudo: " + miNexo.getCantidadDeEscudo());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
	
		if(miJuego.jugadorActual.equals(miNexo.getJugador())){
			if(miNexo.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(enConstruccion);
				
				JLabel tiempo = new JLabel("Tiempo restante: " + miNexo.getTiempoRestante());
				tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(tiempo);
			} else {
				JLabel recursos = new JLabel("Recursos restantes: "+((DepositoDeMinerales) miNexo.getJugador().getMapa().getParcela(miNexo.getPosicion()).getSuperficie()).getRecursos());
				recursos.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(recursos);
			}
		}
	}
	
	@Override
	public void actualizar() {
		if (miNexo.estaMuerto()){
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
		if (!miNexo.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
