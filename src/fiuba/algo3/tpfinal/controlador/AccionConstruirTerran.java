package fiuba.algo3.tpfinal.controlador;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;

public class AccionConstruirTerran implements MouseListener, MouseMotionListener {
	
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


			Coordenada posicion = new Coordenada(fila, columna);
			
				try {
					miJugador.construir(miConstruccion, posicion);
				} catch (ConstruccionRequeridaInexistente e) {
					JOptionPane.showMessageDialog(null, "Te faltan construcciones",
							"Error",
					    	JOptionPane.ERROR_MESSAGE);
				} catch (MineralInsuficiente e) {
					JOptionPane.showMessageDialog(null, "No te alcanza el mineral",
							"Error",
					    	JOptionPane.ERROR_MESSAGE);
				} catch (GasInsuficiente e) {
					JOptionPane.showMessageDialog(null, "No te alcanza el gas",
							"Error",
					    	JOptionPane.ERROR_MESSAGE);
				} catch (TerrenoInapropiado e) {
					JOptionPane.showMessageDialog(null, "No se puede construir aca",
							"Error",
					    	JOptionPane.ERROR_MESSAGE);
				} catch (ParcelaOcupada e) {
					JOptionPane.showMessageDialog(null, "El lugar esta ocupado",
							"Error",
					    	JOptionPane.ERROR_MESSAGE);
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
