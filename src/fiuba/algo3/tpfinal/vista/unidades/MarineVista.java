package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista implements Observador {
	
	private Marine miMarine;
	private JInternalFrame miVentanaDeAccion;
	private JLabel miCapa;
	
	public MarineVista() {
		setBackground(Color.WHITE);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirMenuObservador() {
		miCapa.setVisible(true);
		System.out.println("Hiciste click en un marine fiera!");
	}
	
	@Override
	public void ocultarMenuObservador() {
		miCapa.setVisible(false);
		System.out.println("Clickeaste en otra cosa que no es un marine loco!");
		
	}
	@Override
	public void setObservable(Observable marine) {
		miMarine = (Marine)marine;
		miCapa = new JLabel("Aca va toda la info y los botones");
		miCapa.setVisible(false);
		miVentanaDeAccion.add(miCapa);
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;
		
	}


}
