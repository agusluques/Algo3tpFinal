package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.ControladorTraslado;
import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveCienciaVista extends Vista {
	
	private NaveCiencia miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlTraslado = "trasladoNaveCiencia.wav";
	private HashImagenesConColor imagenesUnidades;

	public NaveCienciaVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void actualizar() {
		if (miNave.estaMuerto()){
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

	@Override
	public void setObservable(Observable nave) {
		
		if (miNave == null){
			miNave = (NaveCiencia) nave;
			imagenesUnidades = new HashImagenesConColor(miNave.getJugador().getColor());
		}
		img = imagenesUnidades.get("NaveCiencia");
		
		
	}


	private void crearControladores() {
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miNave, urlTraslado );
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	
		AccionIrradiar irradiar = new AccionIrradiar();
		ControladorDeMagias controladorMagias = new ControladorDeMagias(irradiar,(Atacable)miNave);
		controladorMagias.setVentanaMapa(ventanaMapa);
		JButton botonIrradiar = new JButton("Irradiar");
		botonIrradiar.addActionListener(controladorMagias);
		miPanel.add(botonIrradiar);
		
		AccionLanzarEMP emp = new AccionLanzarEMP();
		ControladorDeMagias controlador = new ControladorDeMagias(emp,(Atacable)miNave);
		controlador.setVentanaMapa(ventanaMapa);
		JButton botonEMP = new JButton("Lanzar EMP");
		botonEMP.addActionListener(controlador);
		miPanel.add(botonEMP);
	}

	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Nave ciencia");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		JLabel capaEnergia = new JLabel("Energia: " + miNave.getEnergia());
		miPanel.add(capaEnergia);
		
		if(miJuego.jugadorActual.equals(miNave.getJugador())){
			crearControladores();
		}
	}

	
	public void paint(Graphics g) {
		Coordenada miCoord = miNave.getCoordenada();
		Class<?> sup = miNave.getJugador().getMapa().getParcela(miCoord)
				.getSuperficie().getClass();

		g.drawImage(imagenes.get(sup), 0, 0, 40, 40, null);
		if (!miNave.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	
	}

}
