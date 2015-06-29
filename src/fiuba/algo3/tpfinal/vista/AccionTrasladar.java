package fiuba.algo3.tpfinal.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.unidades.Trasladable;

public class AccionTrasladar implements MouseListener {
	
	private Trasladable miUnidad;
	private JPanel capaQueEscucho;
	private JLayeredPane ventanaMapa;
	
	
	public AccionTrasladar(JPanel capaQueEscuchaClicks, Trasladable miUnidad,
			JLayeredPane ventanaMapa) {
		this.miUnidad = miUnidad;
		this.capaQueEscucho = capaQueEscuchaClicks;
		this.ventanaMapa = ventanaMapa;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = (arg0.getY()/40)+1;
		int columna = (arg0.getX()/40)+1;
		
		try { 
			miUnidad.trasladarA(new Coordenada(fila, columna), miUnidad.getJugador().getMapa());
			ventanaMapa.repaint();
		} catch (MovimientoInvalido error) {
			lanzarVentanaDeError();
		}
		capaQueEscucho.setVisible(false);
		ventanaMapa.remove(capaQueEscucho);
	}

	private void lanzarVentanaDeError() {
		JInternalFrame frame = new JInternalFrame("Error!");
		frame.setBackground(Color.RED);
		frame.getContentPane().setBackground(Color.RED);
		frame.setSize(1000, 1000);
		frame.setLocation(ventanaMapa.getWidth() / 2, ventanaMapa.getHeight() / 2);
		frame.setClosable(true);
		frame.setVisible(true);

		JButton aceptar = new JButton("OK");
		aceptar.addActionListener(new AccionCerrarVentanaEmergente(frame));
		frame.getContentPane().add(aceptar, BorderLayout.AFTER_LAST_LINE);

		JLabel label = new JLabel(
				"Movimiento invalido");
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.pack();
		ventanaMapa.add(frame);
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
