package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JugadorTerranVista extends JugadorVista {
	
	protected void crearControladores() {
		JButton botonCrearCentroMineral = new JButton("Construir centro de mineral");
		miPanel.add(botonCrearCentroMineral);
		
		super.crearControladores();
	}

}
