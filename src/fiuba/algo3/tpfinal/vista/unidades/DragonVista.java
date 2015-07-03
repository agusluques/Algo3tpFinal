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
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DragonVista extends Vista{
	
	private Dragon miDragon;
	private Image img;
	private Image fondo;
	private String urlAtaque = "ataqueDragon.wav";
	private String urlTraslado = "trasladoDragon.wav";
	private HashImagenesConColor imagenes;
	
	public DragonVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}
	
	@Override
	public void setObservable(Observable dragon) {
		
		
		if (miDragon == null){
			miDragon = (Dragon) dragon;
			imagenes = new HashImagenesConColor(miDragon.getJugador().getColor());
		}
		img = imagenes.get("Dragon");

	
	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque((Observable) miDragon, urlAtaque );
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miDragon, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Dragon");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miDragon.getCantidadDeVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miDragon.getCantidadDeEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miDragon.getJugador())){
			crearControladores();
		}
	}
	
	@Override
	public void actualizar() {
		if (miDragon.estaMuerto()){
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
		if (!miDragon.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}
	}

}
