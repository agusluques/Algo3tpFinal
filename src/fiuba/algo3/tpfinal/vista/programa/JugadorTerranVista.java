package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;

import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.vista.ControladorConstruccionTerran;

@SuppressWarnings("serial")
public class JugadorTerranVista extends JugadorVista {
	
	protected void crearControladores() {
		ControladorConstruccionTerran controladorCentroMineral = new ControladorConstruccionTerran((JugadorTerran) miJugador, CentroDeMineral.class);
		controladorCentroMineral.setVentanaMapa(ventanaMapa);
		JButton botonCrearCentroMineral = new JButton("Construir centro de mineral");
		botonCrearCentroMineral.addActionListener(controladorCentroMineral);
		miPanel.add(botonCrearCentroMineral);
		
		super.crearControladores();
	}

}
