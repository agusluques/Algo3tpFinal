package fiuba.algo3.tpfinal.controlador;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoTraslado;

public class AccionTrasladar implements MouseListener, MouseMotionListener {
	
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
	public void mouseDragged(MouseEvent arg0) {
			
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		capaQueEscucho.scrollRectToVisible(new Rectangle(arg0.getX()-50,arg0.getY()-50,100,100));
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY()/40)+1;
		int columna = (arg0.getX()/40)+1;
		
		try { 
			try {
				miUnidad.trasladarA(new Coordenada(fila, columna), miUnidad.getJugador().getMapa());
			} catch (ParcelaOcupada e) {
				JOptionPane.showMessageDialog(null, "El lugar esta ocupado",
						"Error",
				    	JOptionPane.ERROR_MESSAGE);
			}
			ventanaMapa.repaint();
			new SonidoTraslado(urlTraslado );
		} catch (MovimientoInvalido | MalformedURLException error) {
			lanzarVentanaDeError();
		}
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
	}

	private void lanzarVentanaDeError() {
		JOptionPane.showMessageDialog(null, "Movimiento Invalido!",
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
