package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.vista.AccionCrearDragon;
import fiuba.algo3.tpfinal.vista.AccionCrearZealot;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AccesoVista extends Vista {
	
	private Acceso miAcceso;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public AccesoVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable acceso) {
		
		
		if (miAcceso == null){
			miAcceso = (Acceso) acceso;
			imagenes = new HashImagenesConColor(miAcceso.getJugador().getColor());
		}
		if(miAcceso.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("Acceso");
		}
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Acceso");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAcceso.getCantidadDeVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miAcceso.getCantidadDeEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miAcceso.getJugador())){
			crearControladores();
		}
	}
	
	private void crearControladores() {
		AccionCrearZealot controladorZealot = new AccionCrearZealot(miAcceso);
		JButton botonZealot = new JButton("Construir Zealot");
		botonZealot.addActionListener(controladorZealot);
		miPanel.add(botonZealot);
		
		AccionCrearDragon controladorDragon = new AccionCrearDragon(miAcceso);
		JButton botonDragon = new JButton("Construir Dragon");
		botonDragon.addActionListener(controladorDragon);
		miPanel.add(botonDragon);
	}

	@Override
	public void actualizar() {
		if (miAcceso.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		}else {
			crearPanel();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miAcceso.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
