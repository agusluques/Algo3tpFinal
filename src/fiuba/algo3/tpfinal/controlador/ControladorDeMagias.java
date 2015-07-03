package fiuba.algo3.tpfinal.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;

public class ControladorDeMagias implements ActionListener {

	private JLayeredPane ventanaMapa;
	private AccionMagia accionMagia;
	private Atacable unidad;
	
	public ControladorDeMagias(AccionMagia accionMagia, Atacable unidad){
		this.accionMagia = accionMagia;
		this.unidad = unidad;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		JPanel capaQueEscuchaClicks = new JPanel();
		capaQueEscuchaClicks.setBounds(0, 0, 4000, 4000);
		capaQueEscuchaClicks.setBackground(new Color(0,0,0,0));
		
		this.accionMagia.setCapaEscuchable(capaQueEscuchaClicks);
			
		
		capaQueEscuchaClicks.addMouseListener(this.accionMagia);
		capaQueEscuchaClicks.addMouseMotionListener(this.accionMagia);
		capaQueEscuchaClicks.setVisible(true);
		
	
		ventanaMapa.add(capaQueEscuchaClicks);
		ventanaMapa.moveToFront(capaQueEscuchaClicks);
		
	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		this.accionMagia.setUnidad(this.unidad);
		this.accionMagia.setVentanaMapa(this.ventanaMapa);
			
	}
	
	

}
