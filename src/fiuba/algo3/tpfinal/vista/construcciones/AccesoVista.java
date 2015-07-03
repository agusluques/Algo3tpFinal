package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.AccionCrearDragon;
import fiuba.algo3.tpfinal.controlador.AccionCrearZealot;
import fiuba.algo3.tpfinal.modelo.construcciones.Acceso;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

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
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Acceso");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAcceso.getCantidadDeVida() + "  " + "Escudo: " + miAcceso.getCantidadDeEscudo());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
			
		if(miJuego.jugadorActual.equals(miAcceso.getJugador())){
			if(miAcceso.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(enConstruccion);
			}else{
				crearControladores();
				mostrarUnidadesEnFabricacion();
			}
		}
	}
	
	private void mostrarUnidadesEnFabricacion() {
		for (Fabricable unidadActual : miAcceso.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}
	
	private void crearControladores() {
		AccionCrearZealot controladorZealot = new AccionCrearZealot(miAcceso);
		JButton botonZealot = new JButton("Construir Zealot");
		botonZealot.addActionListener(controladorZealot);
		botonZealot.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonZealot);
		
		AccionCrearDragon controladorDragon = new AccionCrearDragon(miAcceso);
		JButton botonDragon = new JButton("Construir Dragon");
		botonDragon.addActionListener(controladorDragon);
		botonDragon.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonDragon);
	}

	@Override
	public void actualizar() {
		if (miAcceso.estaMuerto()){
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miPanel.setVisible(true);
			miVentanaDeAccion.add(miPanel);
			
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miAcceso.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
