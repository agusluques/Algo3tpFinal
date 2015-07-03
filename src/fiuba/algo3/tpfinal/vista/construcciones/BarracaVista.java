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

import fiuba.algo3.tpfinal.controlador.AccionCrearMarine;
import fiuba.algo3.tpfinal.modelo.construcciones.Barraca;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

@SuppressWarnings("serial")
public class BarracaVista extends Vista{

	private Barraca miBarraca;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public BarracaVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable barraca) {
		
		
		if (miBarraca == null){
			miBarraca = (Barraca) barraca;
			imagenes = new HashImagenesConColor(miBarraca.getJugador().getColor());
		}
		if(miBarraca.estaEnContruccion()){
				img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
				img = imagenes.get("Barraca");
		}
		
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.PAGE_AXIS));
		
		JLabel capaNombre = new JLabel("Barraca");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miBarraca.getVida());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
				
		if(miJuego.jugadorActual.equals(miBarraca.getJugador())){
			if(miBarraca.getTiempoRestante()>0){
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
		for (Fabricable unidadActual : miBarraca.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}

	private void crearControladores() {
		AccionCrearMarine controladorMarine = new AccionCrearMarine(miBarraca);
		JButton botonMarine = new JButton("Construir Marine");
		botonMarine.addActionListener(controladorMarine);
		botonMarine.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonMarine);
	}
	
	@Override
	public void actualizar() {
		if (miBarraca.estaMuerto()){
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
		if (!miBarraca.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}
}
