package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveCienciaVista extends Vista {
	
	private NaveCiencia miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlTraslado = "trasladoNaveCiencia.wav";

	public NaveCienciaVista() {
		setPreferredSize(new Dimension(40, 40));
	}


	@Override
	public void actualizar() {
		if (miNave.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
			crearControladores();
		}

	}

	@Override
	public void setObservable(Observable nave) {
		img = (new ImageIcon("imagenes/unidades/NaveCiencia.png")).getImage();
		if (miNave == null){
			miNave = (NaveCiencia) nave;
		}
		crearPanel();
		
		crearControladores();
		miPanel.setVisible(false);
		
	}


	private void crearControladores() {
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miNave, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}


	private void crearPanel() {
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Nave ciencia");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		JLabel capaEnergia = new JLabel("Energia: " + miNave.getEnergia());
		miPanel.add(capaEnergia);
	}

	
	public void paint(Graphics g) {
		Coordenada miCoord = miNave.getCoordenada();
		Class<?> sup = miNave.getJugador().getMapa().getParcela(miCoord)
				.getSuperficie().getClass();

		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);

	}

}
