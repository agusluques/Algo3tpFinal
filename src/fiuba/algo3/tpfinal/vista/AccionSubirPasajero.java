package fiuba.algo3.tpfinal.vista;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.unidades.UnidadTerran;
import fiuba.algo3.tpfinal.vista.sonidos.SonidoError;

public class AccionSubirPasajero implements MouseListener {

	private NaveTransporteTerran miNave;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;

	public AccionSubirPasajero(JPanel capaQueEscuchaClicks,
			NaveTransporteTerran miNave, JLayeredPane ventanaMapa) {
		this.miNave = miNave;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY() / 40) + 1;
		int columna = (arg0.getX() / 40) + 1;
		
		Parcela parcelaActual = miNave.getJugador().getMapa().getParcela(new Coordenada(fila, columna));
		if(parcelaActual.estaVacia()) {
			try {
				new SonidoError();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(ventanaMapa, "Debes seleccionar una unidad",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
			capaQueEscucho.setVisible(false);
			ventanaMapa.remove(capaQueEscucho);
			return;
		}
		if(!parcelaActual.getOcupante().getJugador().equals(miNave.getJugador())) {
			try {
				new SonidoError();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(ventanaMapa, "Debes seleccionar una unidad propia",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
			capaQueEscucho.setVisible(false);
			ventanaMapa.remove(capaQueEscucho);
			return;
		}
		try {
			miNave.subirPasajero((UnidadTerran) parcelaActual.getOcupante());
		} catch (CapacidadInsuficiente e) {
			try {
				new SonidoError();
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(ventanaMapa, "No hay mas capacidad en la nave",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
		
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
		
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