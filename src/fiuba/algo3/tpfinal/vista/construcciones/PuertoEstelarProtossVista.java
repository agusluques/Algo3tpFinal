package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.AccionCrearNaveDeTransporteProtoss;
import fiuba.algo3.tpfinal.controlador.AccionCrearScout;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class PuertoEstelarProtossVista extends Vista {
	
	private PuertoEstelarProtoss miPuertoEstelar;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public PuertoEstelarProtossVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable puertoEstelar) {
		
		
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarProtoss) puertoEstelar;
			imagenes = new HashImagenesConColor(miPuertoEstelar.getJugador().getColor());
		}
		if(miPuertoEstelar.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionProtoss");
		}else{
			img = imagenes.get("PuertoEstelarProtoss");
		}
		
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Puerto Estelar");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getCantidadDeVida());
		miPanel.add(capaVida);
		
		JLabel capaEscudo = new JLabel("Escudo: " + miPuertoEstelar.getCantidadDeEscudo());
		miPanel.add(capaEscudo);
		
		if(miJuego.jugadorActual.equals(miPuertoEstelar.getJugador())){
			if(miPuertoEstelar.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				miPanel.add(enConstruccion);
			}else{
				crearControladores();
			}
		}
		
	
	}
	
	private void crearControladores() {
		AccionCrearScout controladorScout = new AccionCrearScout(miPuertoEstelar);
		JButton botonScout = new JButton("Construir Scout");
		botonScout.addActionListener(controladorScout);
		miPanel.add(botonScout);
		
		AccionCrearNaveDeTransporteProtoss controladorNaveTransporte = new AccionCrearNaveDeTransporteProtoss(miPuertoEstelar);
		JButton botonNaveTransporte = new JButton("Construir nave de transporte");
		botonNaveTransporte.addActionListener(controladorNaveTransporte);
		miPanel.add(botonNaveTransporte);
	}

	@Override
	public void actualizar() {
		if (miPuertoEstelar.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} 
		if (miPanel.isVisible()){
			
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
			crearPanel();
			miPanel.setVisible(true);
			miVentanaDeAccion.add(miPanel);
			
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miPuertoEstelar.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
