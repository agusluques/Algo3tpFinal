package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Atacante;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoAtaque;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoErrorAtaque;

public class AccionAtacar implements MouseListener {

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
	public void mouseClicked(MouseEvent arg0) {

		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			Atacable unidad = ((Atacable) miUnidad).getJugador().getMapa()
					.getParcela(new Coordenada(fila, columna)).getOcupante();
			if (!unidad.getJugador().equals(((Atacable) miUnidad).getJugador())){ 
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
