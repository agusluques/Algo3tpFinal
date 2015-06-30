package fiuba.algo3.tpfinal.vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.programa.JugadorTerran;

public class ControladorConstruccionTerran implements ActionListener {

	private Class<?> construccionAConstruir;
	private JugadorTerran miJugador;
	private JLayeredPane ventanaMapa;

	public ControladorConstruccionTerran(JugadorTerran jugador, Class<?> construccion) {
		construccionAConstruir = construccion;
		miJugador = jugador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			JPanel capaQueEscuchaClicks = new JPanel();
			capaQueEscuchaClicks.setBounds(0, 0, 4000, 4000);
			capaQueEscuchaClicks.setBackground(new Color(0, 0, 0, 0));
			
			AccionConstruirTerran accion = new AccionConstruirTerran(capaQueEscuchaClicks, miJugador,
					(ConstruccionTerran) construccionAConstruir.newInstance(), ventanaMapa);

			capaQueEscuchaClicks.addMouseListener(accion);
			capaQueEscuchaClicks.setVisible(true);
			
			ventanaMapa.add(capaQueEscuchaClicks);
			ventanaMapa.moveToFront(capaQueEscuchaClicks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setVentanaMapa(JLayeredPane ventanaMapa) {
		this.ventanaMapa = ventanaMapa;
	}

}
