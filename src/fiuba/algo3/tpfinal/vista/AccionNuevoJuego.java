package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class AccionNuevoJuego implements ActionListener {
	
	JLabel miCapa;
	
	public AccionNuevoJuego(JLabel capa) {
		miCapa = capa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Creo la ventanita chiquita, le seteo el tamanio, la posicion y la visibilidad
		JInternalFrame frame = new JInternalFrame("Nombres y razas de los jugadores");
		frame.setSize(300,300);
		frame.setLocation(10,10);
		frame.setVisible(true);
		//Agrego la ventanita chiquita a la capa
		miCapa.add(frame);
		    try {
		        frame.setSelected(true);
		    } catch (java.beans.PropertyVetoException e1) {}
	}

}
