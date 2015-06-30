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
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista {

	private Marine miMarine;
	private Image img;
	private Image fondo;
	private String urlAtaque = "ataqueMarine.wav";
	private String urlTraslado = "trasladoMarine.wav";
	
	public MarineVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable marine) {
		img = (new ImageIcon("imagenes/marine.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miMarine == null){
			miMarine = (Marine) marine;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Marine");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miMarine.getVida());
		miPanel.add(capaVida);
		
		ControladorAtaque controladorAtaque = new ControladorAtaque(marine, urlAtaque );
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) marine, urlTraslado);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miMarine.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}
}
