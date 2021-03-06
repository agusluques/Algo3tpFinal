package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.ControladorAtaque;
import fiuba.algo3.tpfinal.controlador.ControladorTraslado;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class GolliatVista extends Vista{

	private Golliat miGolliat;
	private Image img;
	private Image fondo;
	private String urlAtaque = "ataqueGolliat.wav";
	private String urlTraslado = "trasladoGolliat.wav";
	private HashImagenesConColor imagenes;
	
	public GolliatVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable golliat) {
				
		if (miGolliat == null){
			miGolliat = (Golliat) golliat;
			imagenes = new HashImagenesConColor(miGolliat.getJugador().getColor());
		}
		img = imagenes.get("Golliat");
	
	
	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque((Observable) miGolliat, urlAtaque);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miGolliat, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Golliat");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miGolliat.getVida());
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miGolliat.getJugador())){
			crearControladores();
		}
	}
	
	@Override
	public void actualizar() {
		if (miGolliat.estaMuerto()){
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miVentanaDeAccion.add(miPanel);
			miPanel.setVisible(true);
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miGolliat.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}
}
