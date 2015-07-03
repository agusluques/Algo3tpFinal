package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;

public class ControladorSubirPasajeroProtoss implements ActionListener {
	
	private NaveTransporteProtoss miNave;
	private JLayeredPane ventanaMapa;
	
	public ControladorSubirPasajeroProtoss(NaveTransporteProtoss nave) {
		miNave = nave;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JPanel capaQueEscuchaClicks = new JPanel();
		capaQueEscuchaClicks.setBounds(0, 0, 4000, 4000);
		capaQueEscuchaClicks.setBackground(new Color(0,0,0,0));
		
		AccionSubirPasajeroProtoss accion = new AccionSubirPasajeroProtoss(capaQueEscuchaClicks, miNave, ventanaMapa);
		
		capaQueEscuchaClicks.addMouseListener(accion);
		capaQueEscuchaClicks.setVisible(true);
		
		ventanaMapa.add(capaQueEscuchaClicks);
		ventanaMapa.moveToFront(capaQueEscuchaClicks);
	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}

}
