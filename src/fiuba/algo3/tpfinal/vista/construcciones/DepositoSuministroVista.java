package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
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
		crearPanel();
		
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Deposito suministro");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miDeposito.getVida());
		miPanel.add(capaVida);
	}
	
	@Override
	public void actualizar() {
		if (miDeposito.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miVentanaDeAccion.add(miPanel);
			miPanel.setVisible(true);
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miDeposito.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
