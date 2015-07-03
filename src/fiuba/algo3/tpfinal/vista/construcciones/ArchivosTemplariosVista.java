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

import fiuba.algo3.tpfinal.controlador.AccionCrearAltoTemplario;
import fiuba.algo3.tpfinal.modelo.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;
import fiuba.algo3.tpfinal.vista.unidades.UnidadEnFabricacionVista;

@SuppressWarnings("serial")
public class ArchivosTemplariosVista extends Vista{
	
	private ArchivosTemplarios miArchivoTemplario;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public ArchivosTemplariosVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable archivoTemplario) {
		
	
		if (miArchivoTemplario == null){
			miArchivoTemplario = (ArchivosTemplarios) archivoTemplario;
			imagenes = new HashImagenesConColor(miArchivoTemplario.getJugador().getColor());
		}
		if(miArchivoTemplario.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("ArchivosTemplarios");
		}
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		miPanel.setLayout(new BoxLayout(miPanel,BoxLayout.Y_AXIS));
		
		JLabel capaNombre = new JLabel("Archivo Templario");
		capaNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miArchivoTemplario.getCantidadDeVida() + "  " + "Escudo: " + miArchivoTemplario.getCantidadDeEscudo());
		capaVida.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miArchivoTemplario.getJugador())){
			if(miArchivoTemplario.getTiempoRestante()>0){
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
		for (Fabricable unidadActual : miArchivoTemplario.getUnidadesEnConstruccion() ){
			UnidadEnFabricacionVista vistaUnidad = new UnidadEnFabricacionVista(unidadActual);
			vistaUnidad.setAlignmentX(Component.CENTER_ALIGNMENT);
			miPanel.add(vistaUnidad);
		}
		
	}
	
	private void crearControladores() {
		AccionCrearAltoTemplario controladorAltoTemplario = new AccionCrearAltoTemplario(miArchivoTemplario);
		JButton botonAltoTemplario = new JButton("Construir Alto Templario");
		botonAltoTemplario.addActionListener(controladorAltoTemplario);
		botonAltoTemplario.setAlignmentX(Component.CENTER_ALIGNMENT);
		miPanel.add(botonAltoTemplario);
		
	}

	@Override
	public void actualizar() {
		if (miArchivoTemplario.estaMuerto()){
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
		if (!miArchivoTemplario.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
