package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.AccionCrearGolliat;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class FabricaVista extends Vista{
	
	private Fabrica miFabrica;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public FabricaVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable refineria) {
		
		
		if (miFabrica == null){
			miFabrica = (Fabrica) refineria;
			imagenes = new HashImagenesConColor(miFabrica.getJugador().getColor());
		}
		if(miFabrica.estaEnContruccion()){
			img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
			img = imagenes.get("Fabrica");
		}
		
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Fabrica");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miFabrica.getVida());
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miFabrica.getJugador())){
			if(miFabrica.getTiempoRestante()>0){
				JLabel enConstruccion = new JLabel("Edificio en Construccion");
				miPanel.add(enConstruccion);
			}else{
				crearControladores();
			}
		}
	}
	
	private void crearControladores() {
		AccionCrearGolliat controladorGolliat = new AccionCrearGolliat(miFabrica);
		JButton botonGolliat = new JButton("Construir Golliat");
		botonGolliat.addActionListener(controladorGolliat);
		miPanel.add(botonGolliat);
	}
	
	@Override
	public void actualizar() {
		if (miFabrica.estaMuerto()){
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
		if (!miFabrica.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}

}
