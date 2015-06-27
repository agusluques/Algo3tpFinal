package fiuba.algo3.tpfinal.vista.unidades;


import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista implements Observador {
	
	private Marine miMarine;
	private JInternalFrame miVentanaDeAccion;
	private JPanel miPanel;
	
	public MarineVista() {
		setPreferredSize(new Dimension(40,40));
		setBackground(Color.WHITE);
	}
	
	/*public MarineVista() {
		super("/imagenes/unidades/Marine.png");
	}*/

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirMenuObservador() {
		miPanel.setVisible(true);
		System.out.println("Hiciste click en un marine fiera!");
	}
	
	@Override
	public void ocultarMenuObservador() {
		miPanel.setVisible(false);
		System.out.println("Clickeaste en otra cosa que no es un marine loco!");
		
	}
	
	@Override
	public void setObservable(Observable marine) {
		miMarine = (Marine) marine;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Zealot");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: "+miMarine.getVida());
		miPanel.add(capaVida);
		miPanel.setVisible(false);
		miVentanaDeAccion.add(miPanel);
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;
		
	}


}
