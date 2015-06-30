package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorTerran;

public class AccionConstruirTerran implements MouseListener {
	
	private ConstruccionTerran miConstruccion;
	private JugadorTerran miJugador;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;

	public AccionConstruirTerran(JPanel capaQueEscuchaClicks,
			JugadorTerran jugador, ConstruccionTerran construccion, JLayeredPane ventanaMapa) {
		this.miConstruccion = construccion;
		this.miJugador = jugador;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;

		try {
			Coordenada posicion = new Coordenada(fila, columna);
			miJugador.construir(miConstruccion, posicion);

		} catch (Exception e) {
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
