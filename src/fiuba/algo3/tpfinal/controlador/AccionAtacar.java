package fiuba.algo3.tpfinal.controlador;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.Atacante;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoAtaque;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoErrorAtaque;

public class AccionAtacar implements MouseListener, MouseMotionListener {

	private Atacante miUnidad;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;
	private String urlAtaque;

	public AccionAtacar(JPanel capaQueEscuchaClicks, Atacante miUnidad,
			JLayeredPane ventanaMapa, String url) {
		this.miUnidad = miUnidad;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
		this.urlAtaque = url;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
			
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		capaQueEscucho.scrollRectToVisible(new Rectangle(arg0.getX()-50,arg0.getY()-50,100,100));
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			Atacable unidad = ((Atacable) miUnidad).getJugador().getMapa()
					.getParcela(new Coordenada(fila, columna)).getOcupante();
			//esto se deberia verificar en el modelo
			if (!unidad.getJugador().equals(((Atacable) miUnidad).getJugador()) && ((Atacante) miUnidad).getCantidadDeAtaques() == 0){ 
				miUnidad.atacar(unidad);
				new SonidoAtaque(urlAtaque);
			}else{new SonidoErrorAtaque();}
		} catch (Exception e) {
			try {
				new SonidoErrorAtaque();
			} catch (MalformedURLException e1) {
				// si no encuentra el archivo
				e1.printStackTrace();
			}
		}

		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
