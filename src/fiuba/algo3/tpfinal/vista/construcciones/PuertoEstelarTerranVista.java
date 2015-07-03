package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.controlador.AccionCrearEspectro;
import fiuba.algo3.tpfinal.controlador.AccionCrearNaveCiencia;
import fiuba.algo3.tpfinal.controlador.AccionCrearNaveDeTransporteTerran;
import fiuba.algo3.tpfinal.modelo.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class PuertoEstelarTerranVista extends Vista{
	
	private PuertoEstelarTerran miPuertoEstelar;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public PuertoEstelarTerranVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable refineria) {
		
		
		if (miPuertoEstelar == null){
			miPuertoEstelar = (PuertoEstelarTerran) refineria;
			imagenes = new HashImagenesConColor(miPuertoEstelar.getJugador().getColor());
		}
		if(miPuertoEstelar.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("PuertoEstelarTerran");
		}
	
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Puerto estelar");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miPuertoEstelar.getVida());
		miPanel.add(capaVida);
		
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
		
		AccionCrearEspectro controladorEspectro = new AccionCrearEspectro(miPuertoEstelar);
		JButton botonEspectro = new JButton("Construir Espectro");
		botonEspectro.addActionListener(controladorEspectro);
		miPanel.add(botonEspectro);
		
		AccionCrearNaveDeTransporteTerran controladorNaveTransporte = new AccionCrearNaveDeTransporteTerran(miPuertoEstelar);
		JButton botonNaveTransporte = new JButton("Construir Nave De Transporte");
		botonNaveTransporte.addActionListener(controladorNaveTransporte);
		miPanel.add(botonNaveTransporte);
		
		AccionCrearNaveCiencia controladorNaveCiencia = new AccionCrearNaveCiencia(miPuertoEstelar);
		JButton botonNaveCiencia = new JButton("Construir Nave De Ciencia");
		botonNaveCiencia.addActionListener(controladorNaveCiencia);
		miPanel.add(botonNaveCiencia);
		
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
