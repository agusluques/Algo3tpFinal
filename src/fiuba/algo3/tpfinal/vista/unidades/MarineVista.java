package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Atacante;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.vista.AccionAtacar;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista implements Observador {

	private Marine miMarine;
	private Image img;
	private Image fondo;

	public MarineVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable marine) {
		img = (new ImageIcon("imagenes/marine.png")).getImage();
		fondo = (new ImageIcon("imagenes/tierra.png")).getImage();
		miMarine = (Marine) marine;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Marine");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miMarine.getVida());
		miPanel.add(capaVida);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(new AccionAtacar((Atacante) miMarine));
		miPanel.add(botonAtacar);
		miPanel.setVisible(false);

	}

	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}
}
