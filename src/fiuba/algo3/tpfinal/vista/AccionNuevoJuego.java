package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class AccionNuevoJuego implements ActionListener {
	
	JLabel miCapa;
	
	public AccionNuevoJuego(JLabel capa) {
		miCapa = capa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Creo la ventanita chiquita, le seteo el tamanio, la posicion y la visibilidad
		JInternalFrame frame = new JInternalFrame("Creacion de los jugadores");
		frame.setSize(500,500);
		frame.setLocation(10,10);
		frame.setVisible(true);
		
		//Creo division
		JSplitPane splitPane = new JSplitPane();
	    frame.getContentPane().add(splitPane, BorderLayout.CENTER);
	    
	    //Creo las opciones de as razas
	    String[] razas = {"Terran", "Protoss"};
	    
		//Creo el ingreso de nombre Jugador Uno
		JPanel panelUno = new JPanel();
	    JLabel nombreJugadorUno = new JLabel("Nombre Jugador Uno:");
	    JTextField nombreUno = new JTextField(21);
	    JLabel razaJugadorUno = new JLabel("Raza Jugador Uno:");
	    JComboBox<String> razaUno = new JComboBox<String>(razas);
	    panelUno.add(nombreJugadorUno);
	    panelUno.add(nombreUno);
	    panelUno.add(razaJugadorUno);
	    panelUno.add(razaUno);
	    splitPane.setLeftComponent(panelUno);
	    
	        
		//Creo el ingreso de nombre Jugador Dos
		JPanel panelDos = new JPanel();
	    JLabel nombreJugadorDos = new JLabel("Nombre Jugador Dos:");
	    JTextField nombreDos = new JTextField(21);
	    JLabel razaJugadorDos = new JLabel("Raza Jugador Dos:");
	    JComboBox<String> razaDos = new JComboBox<String>(razas);
	    panelDos.add(nombreJugadorDos);
	    panelDos.add(nombreDos);
	    panelDos.add(razaJugadorDos);
	    panelDos.add(razaDos);
	    splitPane.setRightComponent(panelDos);
	    
		
		
		
		
		
		
		
		//Agrego la ventanita chiquita a la capa
	    frame.pack();
		miCapa.add(frame);
		    try {
		        frame.setSelected(true);
		        
		       
		        
		    } catch (java.beans.PropertyVetoException e1) {}
	}

}
