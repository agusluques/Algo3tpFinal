package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Scout;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class ScoutVista extends Vista implements Observador {

	private Scout miScout;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlAtaque = "ataqueScout.wav";
	private String urlTraslado = "trasladoScout.wav";
	private HashImagenesConColor imagenesUnidades;

	public ScoutVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable scout) {
		
		if (miScout == null){
			miScout = (Scout) scout;
			imagenesUnidades = new HashImagenesConColor(miScout.getJugador().getColor());
		}
		img = imagenes.get("Scout");
		crearPanel();
		
		miPanel.setVisible(false);

	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque(miScout, urlAtaque);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miScout, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}

	private void crearPanel() {
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Scout");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miScout.getVida());
		miPanel.add(capaVida);
		JLabel capaEscudo = new JLabel("Escudo: " + miScout.getEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miScout.getJugador())){
			crearControladores();
		}
	}
	
	@Override
	public void actualizar() {
		if (miScout.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {
		Coordenada miCoord = miScout.getCoordenada();
		Class<?> sup = miScout.getJugador().getMapa().getParcela(miCoord)
				.getSuperficie().getClass();

		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}
}
