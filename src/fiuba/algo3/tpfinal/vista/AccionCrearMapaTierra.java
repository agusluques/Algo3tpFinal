package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
			ventanita.setLocation(0, 0);
			ventanita.setResizable(true);
			ventanita.setVisible(true);
			miCapa.add(ventanita);
			
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(2,2),marine);
			MarineVista vistaMarine = new MarineVista();
			vistaMarine.setVentanaDeAccion(ventanita);
			
			vistaMarine.setObservable(marine);
			((Observable)marine).agregarObservador(vistaMarine);
		
		
			JPanel panelMapa = new MapaVista(mapa);
			JScrollPane panelMapaConScroll = new JScrollPane(panelMapa);
			panelMapaConScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			panelMapaConScroll.setBounds(miCapa.getMaximumSize().width/5, 0, 2*miCapa.getMaximumSize().width/5, miCapa.getMaximumSize().height/2);
			
			
	        frame.pack();
	        frame.setVisible(true);
	        miCapa.add(panelMapaConScroll);
			frame.setSelected(true);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
