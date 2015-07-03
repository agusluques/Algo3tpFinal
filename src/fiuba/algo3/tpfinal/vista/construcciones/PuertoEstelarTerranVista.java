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

import fiuba.algo3.tpfinal.controlador.AccionCrearEspectro;
import fiuba.algo3.tpfinal.controlador.AccionCrearNaveCiencia;
import fiuba.algo3.tpfinal.controlador.AccionCrearNaveDeTransporteTerran;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

@SuppressWarnings("serial")
public class PuertoEstelarTerranVista extends Vista{
	
	private PuertoEstelarTerran miPuertoEstelar;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public PuertoEstelarTerranVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable refineria) {
		
		
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarTerran) refineria;
			imagenes = new HashImagenesConColor(miPuertoEstelar.getJugador().getColor());
		}
		if(miPuertoEstelar.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("PuertoEstelarTerran");
		}
	
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.PAGE_AXIS));
		
		JLabel capaNombre = new JLabel("Puerto estelar");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getVida());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miPuertoEstelar.getJugador())){
			if(miPuertoEstelar.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				enConstruccion.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(enConstruccion);
				
				JLabel tiempo = new JLabel("Tiempo restante: " + miPuertoEstelar.getTiempoRestante());
				tiempo.setAlignmentX(Component.CENTER_ALIGNMENT);
				miPanel.add(tiempo);
			}else{
				crearControladores();
				mostrarUnidadesEnFabricacion();
			}
		}
	}
	
	private void mostrarUnidadesEnFabricacion() {
		for (Fabricable unidadActual : miPuertoEstelar.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}
	
	private void crearControladores() {
		
		AccionCrearEspectro controladorEspectro = new AccionCrearEspectro(miPuertoEstelar);
		JButton botonEspectro = new JButton("Construir Espectro");
		botonEspectro.addActionListener(controladorEspectro);
		botonEspectro.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonEspectro);
		
		AccionCrearNaveDeTransporteTerran controladorNaveTransporte = new AccionCrearNaveDeTransporteTerran(miPuertoEstelar);
		JButton botonNaveTransporte = new JButton("Construir Nave De Transporte");
		botonNaveTransporte.addActionListener(controladorNaveTransporte);
		botonNaveTransporte.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonNaveTransporte);
		
		AccionCrearNaveCiencia controladorNaveCiencia = new AccionCrearNaveCiencia(miPuertoEstelar);
		JButton botonNaveCiencia = new JButton("Construir Nave De Ciencia");
		botonNaveCiencia.addActionListener(controladorNaveCiencia);
		botonNaveCiencia.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonNaveCiencia);
		
	}
	
	@Override
	public void actualizar() {
		if (miPuertoEstelar.estaMuerto()){
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
		if (!miPuertoEstelar.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
