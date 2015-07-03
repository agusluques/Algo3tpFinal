package fiuba.algo3.tpfinal.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;

public class ControladorConstruccionProtoss implements ActionListener{
	
	private Class<?> construccionAConstruir;
	private JugadorProtoss miJugador;
	private JLayeredPane ventanaMapa;

	public ControladorConstruccionProtoss(JugadorProtoss jugador, Class<?> construccion) {
		construccionAConstruir = construccion;
		miJugador = jugador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			JPanel capaQueEscuchaClicks = new JPanel();
			capaQueEscuchaClicks.setBounds(0, 0, 4000, 4000);
			capaQueEscuchaClicks.setBackground(new Color(0, 0, 0, 0));
			
			AccionConstruirProtoss accion = new AccionConstruirProtoss(capaQueEscuchaClicks, miJugador,
					(ConstruccionProtoss) construccionAConstruir.newInstance(), ventanaMapa);

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
