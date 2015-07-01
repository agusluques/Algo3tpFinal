package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveTransporteProtossVista extends Vista {

	private NaveTransporteProtoss miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();
	private String urlTraslado = "trasladoNaveTProtoss.wav";
	private HashImagenesConColor imagenesUnidades;

	public NaveTransporteProtossVista() {
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
			miNave = (NaveTransporteProtoss) nave;
			imagenesUnidades = new HashImagenesConColor(miNave.getJugador().getColor());
		}
		img = imagenesUnidades.get("NaveTransporteProtoss");
		crearPanel();

		
		miPanel.setVisible(false);
		
	}


	private void crearControladores() {
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miNave, urlTraslado);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
	}


	private void crearPanel() {
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Nave De Transporte Protoss");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		JLabel capaEscudo = new JLabel("Escudo: " + miNave.getEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miNave.getJugador())){
			crearControladores();
		}
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;

	}
	   public void paint(Graphics g) {
		   Coordenada miCoord = miNave.getCoordenada();
		   Class<?> sup = miNave.getJugador().getMapa().getParcela(miCoord).getSuperficie().getClass();
			
		   g.drawImage(imagenes.get(sup),0,0,40,40,null);
		   if (!miNave.estaMuerto()){
			   g.drawImage(img,0,0,40,40, null);
		   }

	   }

}
