package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.AccionBajarPasajerosTerran;
import fiuba.algo3.tpfinal.vista.ControladorSubirPasajeroTerran;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Observador;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveTransporteTerranVista extends Vista implements Observador {

	private NaveTransporteTerran miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlTraslado = "trasladoNaveTTerran.wav";
	private HashImagenesConColor imagenesUnidades;

	public NaveTransporteTerranVista() {
		setPreferredSize(new Dimension(40, 40));

	}

	@Override
	public void setObservable(Observable nave) {
		
		if (miNave == null){
			miNave = (NaveTransporteTerran) nave;
			imagenesUnidades = new HashImagenesConColor(miNave.getJugador().getColor());
		}
		img = imagenesUnidades.get("NaveTransporteTerran");
		crearPanel();

		miPanel.setVisible(false);

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

	private void crearControladores() {
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miNave, urlTraslado);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		ControladorSubirPasajeroTerran controladorSubir = new ControladorSubirPasajeroTerran(miNave);
		controladorSubir.setVentanaMapa(ventanaMapa);
		JButton botonSubir = new JButton("Subir pasajero");
		botonSubir.addActionListener(controladorSubir);
		miPanel.add(botonSubir);
		
		AccionBajarPasajerosTerran controladorBajar = new AccionBajarPasajerosTerran(miNave);
		JButton botonBajar = new JButton("Bajar pasajero");
		botonBajar.addActionListener(controladorBajar);
		miPanel.add(botonBajar);
	}

	private void crearPanel() {
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("NaveDeTransporteTerran");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		JLabel capaCapacidad = new JLabel("Capacidad restante: "+miNave.getCapacidad());
		miPanel.add(capaCapacidad);
		
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
