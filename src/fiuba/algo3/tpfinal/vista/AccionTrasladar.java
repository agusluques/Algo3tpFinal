package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoTraslado;

public class AccionTrasladar implements MouseListener {
	
	private Trasladable miUnidad;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;
	private String urlTraslado;
	
	
	public AccionTrasladar(JPanel capaQueEscuchaClicks, Trasladable miUnidad,
			JLayeredPane ventanaMapa, String url) {
		this.miUnidad = miUnidad;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
		this.urlTraslado = url;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY()/40)+1;
		int columna = (arg0.getX()/40)+1;
		
		try { 
			miUnidad.trasladarA(new Coordenada(fila, columna), miUnidad.getJugador().getMapa());
			ventanaMapa.repaint();
			new SonidoTraslado(urlTraslado );
		} catch (MovimientoInvalido | MalformedURLException error) {
			lanzarVentanaDeError();
		}
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
	}

	private void lanzarVentanaDeError() {
		JOptionPane.showMessageDialog(ventanaMapa, "Movimiento Invalido!",
				"Ups!",
		    	JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
