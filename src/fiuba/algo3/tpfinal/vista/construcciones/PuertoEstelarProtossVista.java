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

import fiuba.algo3.tpfinal.controlador.AccionCrearNaveDeTransporteProtoss;
import fiuba.algo3.tpfinal.controlador.AccionCrearScout;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

@SuppressWarnings("serial")
public class PuertoEstelarProtossVista extends Vista {
	
	private PuertoEstelarProtoss miPuertoEstelar;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public PuertoEstelarProtossVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable puertoEstelar) {
		
		
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarProtoss) puertoEstelar;
			imagenes = new HashImagenesConColor(miPuertoEstelar.getJugador().getColor());
		}
		if(miPuertoEstelar.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("PuertoEstelarProtoss");
		}
		
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.PAGE_AXIS));
		
		JLabel capaNombre = new JLabel("Puerto Estelar");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getCantidadDeVida() + "  " + "Escudo: " + miPuertoEstelar.getCantidadDeEscudo());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
	
		if(miJuego.jugadorActual.equals(miPuertoEstelar.getJugador())){
			if(miPuertoEstelar.getTiempoRestante()>0){
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
		for (Fabricable unidadActual : miPuertoEstelar.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}
	private void crearControladores() {
		AccionCrearScout controladorScout = new AccionCrearScout(miPuertoEstelar);
		JButton botonScout = new JButton("Construir Scout");
		botonScout.addActionListener(controladorScout);
		botonScout.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonScout);
		
		AccionCrearNaveDeTransporteProtoss controladorNaveTransporte = new AccionCrearNaveDeTransporteProtoss(miPuertoEstelar);
		JButton botonNaveTransporte = new JButton("Construir nave de transporte");
		botonNaveTransporte.addActionListener(controladorNaveTransporte);
		botonNaveTransporte.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonNaveTransporte);
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
