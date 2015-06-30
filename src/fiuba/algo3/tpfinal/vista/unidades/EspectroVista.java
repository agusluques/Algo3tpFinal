package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Espectro;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class EspectroVista extends Vista {
	
	private Espectro miEspectro;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	
	public EspectroVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable espectro) {
		img = (new ImageIcon("imagenes/unidades/Espectro.png")).getImage();
		if (miEspectro == null){
			miEspectro = (Espectro) espectro;
		}
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Espectro");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miEspectro.getVida());
		miPanel.add(capaVida);
		
		ControladorAtaque controladorAtaque = new ControladorAtaque(espectro);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) espectro);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		miPanel.setVisible(false);
	
	}
	
	public void actualizar() {
		if (miEspectro.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}

	public void paint(Graphics g) {
		Coordenada miCoord = miEspectro.getCoordenada();
		Class<?> sup = miEspectro.getJugador().getMapa().getParcela(miCoord).getSuperficie().getClass();
		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
