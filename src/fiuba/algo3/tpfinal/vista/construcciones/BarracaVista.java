package fiuba.algo3.tpfinal.vista.construcciones;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.vista.HashImagenesConColor;
import fiuba.algo3.tpfinal.vista.AccionCrearMarine;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class BarracaVista extends Vista{

	private Barraca miBarraca;
	private Image img;
	private Image fondo;
	private HashImagenesConColor imagenes;
	
	public BarracaVista() {
		setPreferredSize(new Dimension(40, 40));
		fondo = (new ImageIcon("imagenes/superficies/tierra.png")).getImage();
	}

	@Override
	public void setObservable(Observable barraca) {
		
		
		if (miBarraca == null){
			miBarraca = (Barraca) barraca;
			imagenes = new HashImagenesConColor(miBarraca.getJugador().getColor());
		}
		if(miBarraca.estaEnContruccion()){
				img = imagenes.get("EdificioEnConstruccionTerran");
		}else{
				img = imagenes.get("Barraca");
		}
		
	
	}
	@Override
	protected void crearPanel() {
		miPanel = new JPanel();
		
		JLabel capaNombre = new JLabel("Barraca");
		miPanel.add(capaNombre);
		
		JLabel capaVida = new JLabel("Vida: " + miBarraca.getVida());
		miPanel.add(capaVida);
		
		if(miJuego.jugadorActual.equals(miBarraca.getJugador())){
			crearControladores();
		}
	}
	
	private void crearControladores() {
		AccionCrearMarine controladorMarine = new AccionCrearMarine(miBarraca);
		JButton botonMarine = new JButton("Construir Marine");
		botonMarine.addActionListener(controladorMarine);
		miPanel.add(botonMarine);
	}
	
	@Override
	public void actualizar() {
		if (miBarraca.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
			miPanel.setVisible(false);
			miVentanaDeAccion.remove(miPanel);
		} else {
			crearPanel();
		}
	}

	public void paint(Graphics g) {

		g.drawImage(fondo, 0, 0, 40, 40, null);
		if (!miBarraca.estaMuerto()){
			g.drawImage(img, 0, 0, 40, 40, null);
		}

	}
}
