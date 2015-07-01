package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Espectro;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class EspectroVista extends Vista {
	
	private Espectro miEspectro;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlAtaque = "ataqueEspectro.wav";
	private String urlTraslado = "trasladoEspectro.wav";
	private HashImagenesConColor imagenesUnidades;
	
	public EspectroVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable espectro) {
		
		if (miEspectro == null){
			miEspectro = (Espectro) espectro;
			imagenesUnidades = new HashImagenesConColor(miEspectro.getJugador().getColor());
		}
		img = imagenesUnidades.get("Espectro");
		crearPanel();
				
		miPanel.setVisible(false);
	
	}

	private void crearControladores() {
		ControladorAtaque controladorAtaque = new ControladorAtaque((Observable) miEspectro, urlAtaque);
		controladorAtaque.setVentanaMapa(ventanaMapa);
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorAtaque);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miEspectro, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}

	private void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Espectro");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miEspectro.getVida());
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miEspectro.getJugador())){
			crearControladores();
		}
	}
	
	@Override
	public void actualizar() {
		if (miEspectro.estaMuerto()){
			System.out.println("Me mori");
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
		Coordenada miCoord = miEspectro.getCoordenada();
		Class<?> sup = miEspectro.getJugador().getMapa().getParcela(miCoord).getSuperficie().getClass();
		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		if (!miEspectro.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
