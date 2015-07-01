package fiuba.algo3.tpfinal.vista.unidades;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.Atacable;

public class AccionMagia implements MouseListener {

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
