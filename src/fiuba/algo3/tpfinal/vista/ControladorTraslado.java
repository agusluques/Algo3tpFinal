package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Trasladable;

public class ControladorTraslado implements ActionListener{
	
	private Trasladable miUnidad;
	private JLayeredPane ventanaMapa;

	public ControladorTraslado(Trasladable unidad) {
		miUnidad = unidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JPanel capaQueEscuchaClicks = new JPanel();
		capaQueEscuchaClicks.setBounds(0, 0, 1000, 1000);
		capaQueEscuchaClicks.setBackground(new Color(0,0,0,0));
		
		AccionTrasladar accion = new AccionTrasladar(capaQueEscuchaClicks, miUnidad, ventanaMapa);
		
		capaQueEscuchaClicks.addMouseListener(accion);
		capaQueEscuchaClicks.setVisible(true);
		
		ventanaMapa.add(capaQueEscuchaClicks);
		ventanaMapa.moveToFront(capaQueEscuchaClicks);
		
	}
	
	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}

}
