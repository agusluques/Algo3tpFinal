package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Mapa;

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
			JPanel panelMapa = new MapaVista(mapa);
			frame.getContentPane().add(panelMapa, BorderLayout.WEST);
			frame.pack();
			
			miCapa.add(frame);
			frame.setSelected(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
