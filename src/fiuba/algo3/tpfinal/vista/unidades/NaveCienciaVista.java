package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.ControladorTraslado;
import fiuba.algo3.tpfinal.vista.HashImagenes;
import fiuba.algo3.tpfinal.vista.Observable;
import fiuba.algo3.tpfinal.vista.Vista;

@SuppressWarnings("serial")
public class NaveCienciaVista extends Vista {
	
	private NaveCiencia miNave;
	private Image img;
	private HashImagenes imagenes = new HashImagenes();

	public NaveCienciaVista() {
		setPreferredSize(new Dimension(40, 40));
	}


	@Override
	public void actualizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setObservable(Observable nave) {
		img = (new ImageIcon("imagenes/unidades/NaveCiencia.png")).getImage();
		if (miNave == null){
			miNave = (NaveCiencia) nave;
		}
		miPanel = new JPanel();
		JLabel capaNombre = new JLabel("Nave ciencia");
		miPanel.add(capaNombre);
		JLabel capaVida = new JLabel("Vida: " + miNave.getVida());
		miPanel.add(capaVida);
		JLabel capaEnergia = new JLabel("Energia: " + miNave.getEnergia());
		miPanel.add(capaEnergia);
		
		ControladorTraslado controladorTraslado = new ControladorTraslado((Trasladable) miNave);
		controladorTraslado.setVentanaMapa(ventanaMapa);
		JButton botonMover = new JButton("Trasladar");
		botonMover.addActionListener(controladorTraslado);
		miPanel.add(botonMover);
		miPanel.setVisible(false);
		
	}

	@Override
	public void setVentanaDeAccion(JInternalFrame ventana) {
		miVentanaDeAccion = ventana;

	}
	   public void paint(Graphics g) {
		   Coordenada miCoord = miNave.getCoordenada();
		   Class<?> sup = miNave.getJugador().getMapa().getParcela(miCoord).getSuperficie().getClass();
			
		   g.drawImage(imagenes.get(sup),0,0,40,40,null);
		   g.drawImage(img,0,0,40,40, null);

	   }

}
