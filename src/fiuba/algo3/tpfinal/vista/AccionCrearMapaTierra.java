package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.unidades.MarineVista;

public class AccionCrearMapaTierra implements ActionListener {
	
	private JLabel miCapa;

	public AccionCrearMapaTierra(JLabel capa) {
		miCapa = capa;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JInternalFrame frame = new JInternalFrame("Mapa");
		frame.setSize(250, 250);
		frame.setLocation(10, 10);
		frame.setClosable(true);
		frame.setVisible(true);
		
		
		Mapa mapa;
		try {
			mapa = new Mapa("mapaTierra.txt");
			
			JInternalFrame ventanita = new JInternalFrame("Info de unidades");
			ventanita.setSize(300, 300);
			ventanita.setLocation(1000, 500);
			ventanita.setResizable(true);
			ventanita.setVisible(true);
			
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(2,2),marine);
			MarineVista vistaMarine = new MarineVista();
			vistaMarine.setVentanaDeAccion(ventanita);
			
			vistaMarine.setObservable(marine);
			((Observable)marine).agregarObservador(vistaMarine);
		
		
			JPanel panelMapa = new MapaVista(mapa);
			frame.getContentPane().add(panelMapa, BorderLayout.WEST);
			frame.pack();
			miCapa.add(frame);
			miCapa.add(ventanita);
			frame.setSelected(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
