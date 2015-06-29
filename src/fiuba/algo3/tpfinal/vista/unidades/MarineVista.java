package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorAtaque;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class MarineVista extends Vista {

	private Marine miMarine;
	private Image img;
	private Image fondo;
	private JLayeredPane ventanaMapa;
	
	public MarineVista() {
		setPreferredSize(new Dimension(40, 40));
	}

	@Override
	public void setObservable(Observable marine) {
		img = (new ImageIcon("imagenes/marine.png")).getImage();
		fondo = (new ImageIcon("imagenes/tierra.png")).getImage();
		miMarine = (Marine) marine;
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Marine");
		miPanel.add(capaNombre);
		
		//Creo un controlador de Marine pasando como parametro el marine
		//y despues le seteo la ventana mapa, que es el layeredPane donde se
		//imprime el mapa
		ControladorAtaque controladorMarine = new ControladorAtaque(marine);
		controladorMarine.setVentanaMapa(ventanaMapa); 
		//Creo el boton de atacar y lo agrego
		JButton botonAtacar = new JButton("Atacar");
		botonAtacar.addActionListener(controladorMarine);
		miPanel.add(botonAtacar);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) marine);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		
		
		
		JLabel capaVida = new JLabel("Vida: " + miMarine.getVida());
		miPanel.add(capaVida);
		miPanel.setVisible(false);
	
	}

	public void setVentanaMapa(JLayeredPane mapa){
		this.ventanaMapa = mapa;
	}
	
	public void actualizar() {
		if (miMarine.estaMuerto()){
			System.out.println("Me mori");
			ventanaMapa.repaint();
		}

	}


   public void paint(Graphics g) {
	   
	   
	
	   g.drawImage(fondo,0,0,40,40,null);
	   g.drawImage(img,0,0,40,40, null);

   }
}
