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
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class AltoTemplarioVista extends Vista {
	
	private AltoTemplario miAltoTemplario;
	private Image img;
	private Image fondo;
	//private String urlAtaque = "ataqueAltoTemplario.wav";//TODO: para las magias
	private String urlTraslado = "trasladoAltoTemplario.wav";
	private HashImagenesConColor imagenes;
	
	public AltoTemplarioVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}
	
	@Override
	public void setObservable(Observable altoTemplario) {
		
		
		if (miAltoTemplario == null){
			miAltoTemplario = (AltoTemplario) altoTemplario;
			imagenes = new HashImagenesConColor(miAltoTemplario.getJugador().getColor());
		}
		img = imagenes.get("AltoTemplario");
		crearPanel();
						
		miPanel.setVisible(false);
	
	}

	private void crearControladores() {
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miAltoTemplario, urlTraslado);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Alto templario");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miAltoTemplario.getVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miAltoTemplario.getEscudo());
		miPanel.add(capaEscudo);
		
		JLabel capaEnergia = new JLabel("Energia: " + miAltoTemplario.getEnergia());
		miPanel.add(capaEnergia);
		
		if(miJuego.jugadorActual.equals(miAltoTemplario.getJugador())){
			crearControladores();
		}
	}
	
	public void actualizar() {
		if (miAltoTemplario.estaMuerto()) {
			System.out.println("Me mori");
			ventanaMapa.repaint();
		} else {
			crearPanel();
		}

	}

	public void paint(Graphics g) {
		g.drawImage(fondo, 0, 0, 40, 40, null);
		g.drawImage(img, 0, 0, 40, 40, null);
	}

}
