package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JugadorProtossVista extends JugadorVista {

	protected void crearControladores() {
		JButton botonCrearNexoMineral = new JButton("Construir nexo mineral");
		miPanel.add(botonCrearNexoMineral);
		
		super.crearControladores();
	}
}
