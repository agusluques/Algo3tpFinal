package fiuba.algo3.tpfinal.vista.programa;

import javax.swing.JButton;

import fiuba.algo3.tpfinal.controlador.ControladorConstruccionProtoss;
import fiuba.algo3.tpfinal.modelo.construcciones.Acceso;
import fiuba.algo3.tpfinal.modelo.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.modelo.construcciones.Asimilador;
import fiuba.algo3.tpfinal.modelo.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;

@SuppressWarnings("serial")
public class JugadorProtossVista extends JugadorVista {

	protected void crearControladores() {
		ControladorConstruccionProtoss controladorNexoMineral = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, NexoMineral.class);
		controladorNexoMineral.setVentanaMapa(ventanaMapa);
		JButton botonCrearNexoMineral = new JButton("Construir NexoMineral");
		botonCrearNexoMineral.addActionListener(controladorNexoMineral);
		miPanel.add(botonCrearNexoMineral);
		
		ControladorConstruccionProtoss controladorPilon = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, Pilon.class);
		controladorPilon.setVentanaMapa(ventanaMapa);
		JButton botonCrearPilon = new JButton("Construir Pilon");
		botonCrearPilon.addActionListener(controladorPilon);
		miPanel.add(botonCrearPilon);
		
		ControladorConstruccionProtoss controladorAsimilador = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, Asimilador.class);
		controladorAsimilador.setVentanaMapa(ventanaMapa);
		JButton botonCrearAsimilador = new JButton("Construir Asimilador");
		botonCrearAsimilador.addActionListener(controladorAsimilador);
		miPanel.add(botonCrearAsimilador);
		
		ControladorConstruccionProtoss controladorAcceso = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, Acceso.class);
		controladorAcceso.setVentanaMapa(ventanaMapa);
		JButton botonCrearAcceso = new JButton("Construir Acceso");
		botonCrearAcceso.addActionListener(controladorAcceso);
		miPanel.add(botonCrearAcceso);
		
		ControladorConstruccionProtoss controladorPuertoEstelar = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, PuertoEstelarProtoss.class);
		controladorPuertoEstelar.setVentanaMapa(ventanaMapa);
		JButton botonCrearPuertoEstelar = new JButton("Construir PuertoEstelar");
		botonCrearPuertoEstelar.addActionListener(controladorPuertoEstelar);
		miPanel.add(botonCrearPuertoEstelar);
		
		ControladorConstruccionProtoss controladorArchivosTemplarios = new ControladorConstruccionProtoss((JugadorProtoss) miJugador, ArchivosTemplarios.class);
		controladorArchivosTemplarios.setVentanaMapa(ventanaMapa);
		JButton botonCrearArchivosTemplarios = new JButton("Construir ArchivosTemplarios");
		botonCrearArchivosTemplarios.addActionListener(controladorArchivosTemplarios);
		miPanel.add(botonCrearArchivosTemplarios);
		
		super.crearControladores();
	}
}
