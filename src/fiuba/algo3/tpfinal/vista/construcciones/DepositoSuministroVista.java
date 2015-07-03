package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DepositoSuministroVista extends Vista{
	
	private DepositoSuministro miDeposito;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public DepositoSuministroVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable deposito) {
	
		
		if (miDeposito == null){
			miDeposito = (DepositoSuministro) deposito;
			imagenes = new HashImagenesConColor(miDeposito.getJugador().getColor());
		}
		if(miDeposito.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("DepositoDeSuministros");
		}
	
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Deposito suministro");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miDeposito.getVida());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
		if(miDeposito.getTiempoRestante()>0){
			JLabel enConstruccion = new JLabel("Edificio en Construccion");
			enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(enConstruccion);
			
			JLabel tiempo = new JLabel("Tiempo restante: " + miDeposito.getTiempoRestante());
			tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(tiempo);
		}
	}
	
	@Override
	public void actualizar() {
		if (miDeposito.estaMuerto()){
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
		if (!miDeposito.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
