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
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ZealotVista extends Vista implements Observador {

	private Zealot miZealot;
	private Image img;
	private Image fondo;

	public ZealotVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void actualizar() {
		if (miZealot.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	@Override
	public void setObservable(Observable zealot) {
		img = (new ImageIcon("imagenes/zealot.png")).getImage();
		fondo = (new ImageIcon("imagenes/tierra.png")).getImage();
		
		miZealot = (Zealot) zealot;
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Zealot");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miZealot.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miZealot.getEscudo());
		miPanel.add(capaEscudo);
		
		ControladorAtaque controladorAtaque = new ControladorAtaque(miZealot);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miZealot);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		miPanel.setVisible(false);
		
	}
	
	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miZealot.estaMuerto())
			g.drawImage(img, 0, 0, 40, 40, null);

	}
}
