package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class DragonVista extends Vista{
	
	private Dragon miDragon;
	private Image img;
	private Image fondo;
	private String url = "ataqueDragon.wav";
	
	public DragonVista() {
		setPreferredSize(new Dimension(40, 40));
	}
	
	@Override
	public void setObservable(Observable dragon) {
		img = (new ImageIcon("imagenes/unidades/dragon.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		if (miDragon == null){
			miDragon = (Dragon) dragon;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Dragon");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miDragon.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miDragon.getEscudo());
		miPanel.add(capaEscudo);
		
		ControladorAtaque controladorAtaque = new ControladorAtaque(dragon, url );
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) dragon);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miDragon.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);
	}

}
