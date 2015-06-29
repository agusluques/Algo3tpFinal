package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AltoTemplarioVista extends Vista {
	
	private AltoTemplario miAltoTemplario;
	private Image img;
	private Image fondo;
	
	public AltoTemplarioVista() {
		setPreferredSize(new Dimension(40, 40));
	}
	
	@Override
	public void setObservable(Observable altoTemplario) {
		img = (new ImageIcon("imagenes/unidades/altoTemplario.png")).getImage();
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
		miAltoTemplario = (AltoTemplario) altoTemplario;
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Alto templario");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAltoTemplario.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miAltoTemplario.getEscudo());
		miPanel.add(capaEscudo);
		
		ControladorAtaque controladorAtaque = new ControladorAtaque(altoTemplario);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) altoTemplario);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miAltoTemplario.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);
	}

}
