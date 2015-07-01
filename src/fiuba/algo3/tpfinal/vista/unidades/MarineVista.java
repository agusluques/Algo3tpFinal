package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista {

	private Marine miMarine;
	private Image img;
	private Image fondo;
	private String urlAtaque = "ataqueMarine.wav";
	private String urlTraslado = "trasladoMarine.wav";
	private HashImagenesConColor imagenes;
	
	public MarineVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable marine) {
		
		
		if (miMarine == null){
			miMarine = (Marine) marine;
			imagenes = new HashImagenesConColor(miMarine.getJugador().getColor());
		}
		img = imagenes.get("Marine");
		crearPanel();
		miPanel.setVisible(false);
	
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Marine");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miMarine.getVida());
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miMarine.getJugador())){
			crearControladores();
		}
	
	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque((Observable) miMarine, urlAtaque);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miMarine, urlTraslado);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}
	
	@Override
	public void actualizar() {
		if (miMarine.estaMuerto()){
			System.out.println("Me mori");
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
		if (!miMarine.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}
}
