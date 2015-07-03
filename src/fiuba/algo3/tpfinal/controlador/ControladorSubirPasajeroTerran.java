package fiuba.algo3.tpfinal.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteTerran;

public class ControladorSubirPasajeroTerran implements ActionListener {
	
	private NaveTransporteTerran miNave;
	private JLayeredPane ventanaMapa;
	
	public ControladorSubirPasajeroTerran(NaveTransporteTerran nave) {
		miNave = nave;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JPanel capaQueEscuchaClicks = new JPanel();
		capaQueEscuchaClicks.setBounds(0, 0, 4000, 4000);
		capaQueEscuchaClicks.setBackground(new Color(0,0,0,0));
		
		AccionSubirPasajeroTerran accion = new AccionSubirPasajeroTerran(capaQueEscuchaClicks, miNave, ventanaMapa);
		
		capaQueEscuchaClicks.addMouseListener(accion);
		capaQueEscuchaClicks.addMouseMotionListener(accion);
		capaQueEscuchaClicks.setVisible(true);
		
		ventanaMapa.add(capaQueEscuchaClicks);
		ventanaMapa.moveToFront(capaQueEscuchaClicks);
	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}

}
