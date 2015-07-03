package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;

import fiuba.algo3.tpfinal.controlador.ControladorConstruccionTerran;
import fiuba.algo3.tpfinal.modelo.construcciones.Barraca;
import fiuba.algo3.tpfinal.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.construcciones.Fabrica;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.modelo.construcciones.Refineria;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;

@SuppressWarnings("serial")
public class JugadorTerranVista extends JugadorVista {
	
	protected void crearControladores() {
		ControladorConstruccionTerran controladorCentroMineral = new ControladorConstruccionTerran((JugadorTerran) miJugador, CentroDeMineral.class);
		controladorCentroMineral.setVentanaMapa(ventanaMapa);
		JButton botonCrearCentroMineral = new JButton("Construir centro de mineral");
		botonCrearCentroMineral.addActionListener(controladorCentroMineral);
		miPanel.add(botonCrearCentroMineral);
		
		ControladorConstruccionTerran controladorBarraca = new ControladorConstruccionTerran((JugadorTerran) miJugador, Barraca.class);
		controladorBarraca.setVentanaMapa(ventanaMapa);
		JButton botonCrearBarraca = new JButton("Construir Barraca");
		botonCrearBarraca.addActionListener(controladorBarraca);
		miPanel.add(botonCrearBarraca);
		
		ControladorConstruccionTerran controladorDepositoSuministro = new ControladorConstruccionTerran((JugadorTerran) miJugador, DepositoSuministro.class);
		controladorDepositoSuministro.setVentanaMapa(ventanaMapa);
		JButton botonCrearDepositoSuministro = new JButton("Construir DepositoSuministro");
		botonCrearDepositoSuministro.addActionListener(controladorDepositoSuministro);
		miPanel.add(botonCrearDepositoSuministro);
		
		ControladorConstruccionTerran controladorRefineria = new ControladorConstruccionTerran((JugadorTerran) miJugador, Refineria.class);
		controladorRefineria.setVentanaMapa(ventanaMapa);
		JButton botonCrearRefineria = new JButton("Construir Refineria");
		botonCrearRefineria.addActionListener(controladorRefineria);
		miPanel.add(botonCrearRefineria);
		
		ControladorConstruccionTerran controladorFabrica = new ControladorConstruccionTerran((JugadorTerran) miJugador, Fabrica.class);
		controladorFabrica.setVentanaMapa(ventanaMapa);
		JButton botonCrearFabrica = new JButton("Construir Fabrica");
		botonCrearFabrica.addActionListener(controladorFabrica);
		miPanel.add(botonCrearFabrica);
		
		ControladorConstruccionTerran controladorPuertoEstelar = new ControladorConstruccionTerran((JugadorTerran) miJugador, PuertoEstelarTerran.class);
		controladorPuertoEstelar.setVentanaMapa(ventanaMapa);
		JButton botonCrearPuertoEstelar = new JButton("Construir PuertoEstelar");
		botonCrearPuertoEstelar.addActionListener(controladorPuertoEstelar);
		miPanel.add(botonCrearPuertoEstelar);
		
		super.crearControladores();
	}

}
