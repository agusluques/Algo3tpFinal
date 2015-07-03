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

import fiuba.algo3.tpfinal.controlador.AccionCrearGolliat;
import fiuba.algo3.tpfinal.modelo.construcciones.Fabrica;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

@SuppressWarnings("serial")
public class FabricaVista extends Vista{
	
	private Fabrica miFabrica;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public FabricaVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable refineria) {
		
		
		if (miFabrica == null){
			miFabrica = (Fabrica) refineria;
			imagenes = new HashImagenesConColor(miFabrica.getJugador().getColor());
		}
		if(miFabrica.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("Fabrica");
		}
		
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.PAGE_AXIS));
		
		JLabel capaNombre = new JLabel("Fabrica");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miFabrica.getVida());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miFabrica.getJugador())){
			if(miFabrica.getTiempoRestante()>0){
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
		for (Fabricable unidadActual : miFabrica.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}
	
	private void crearControladores() {
		AccionCrearGolliat controladorGolliat = new AccionCrearGolliat(miFabrica);
		JButton botonGolliat = new JButton("Construir Golliat");
		botonGolliat.addActionListener(controladorGolliat);
		botonGolliat.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonGolliat);
	}
	
	@Override
	public void actualizar() {
		if (miFabrica.estaMuerto()){
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
		if (!miFabrica.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
