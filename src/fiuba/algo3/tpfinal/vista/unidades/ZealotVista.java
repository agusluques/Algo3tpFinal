package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.unidades.Zealot;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ZealotVista extends Vista implements Observador {

	private Zealot miZealot;
	private Image img;
	private Image fondo;
	private String urlAtaque = "ataqueZealot.wav";
	private String urlTraslado = "trasladoZealot.wav";
	private HashImagenesConColor imagenes;

	public ZealotVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void actualizar() {
		if (miZealot.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} else {
			crearPanel();
		}
	}

	@Override
	public void setObservable(Observable zealot) {
		
		if (miZealot == null){
			miZealot = (Zealot) zealot;
			imagenes = new HashImagenesConColor(miZealot.getJugador().getColor());
		}
		
		img = imagenes.get("Zealot");
		
		crearPanel();
		
		miPanel.setVisible(false);
		
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Zealot");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miZealot.getCantidadDeVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miZealot.getCantidadDeEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miZealot.getJugador())){
			crearControladores();
		}
		
	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque(miZealot, urlAtaque);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miZealot, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}
	
	public void paint(Graphics g) {
	
		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miZealot.estaMuerto())
			g.drawImage(img, 0, 0, 40, 40, null);

	}
}
