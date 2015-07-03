package fiuba.algo3.tpfinal.controlador;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;

public class AccionMagia implements MouseListener, MouseMotionListener {

	protected JLayeredPane ventanaMapa;
	protected Atacable miUnidad;
	protected JPanel capaQueEscucho;

	public void setCapaEscuchable(JPanel capaQueEscuchaClicks) {
		this.capaQueEscucho = capaQueEscuchaClicks;
		
	}

	public void setUnidad(Atacable unidad) {
		this.miUnidad = unidad;
		
	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
			
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		capaQueEscucho.scrollRectToVisible(new Rectangle(arg0.getX()-50,arg0.getY()-50,100,100));
		
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
