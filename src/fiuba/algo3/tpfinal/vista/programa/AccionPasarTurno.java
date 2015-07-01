package fiuba.algo3.tpfinal.vista.programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.vista.MapaVista;

public class AccionPasarTurno implements ActionListener {
	
	private Juego miJuego;
	private Jugador miJugador;
	private MapaVista miMapaVista;

	public AccionPasarTurno(Juego juego, Jugador jugador, MapaVista mapaVista) {
		miJuego = juego;
		miJugador = jugador;
		miMapaVista = mapaVista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			miJuego.pasarTurno(miJugador);
		} catch (ParcelaOcupada e) {
			JOptionPane.showMessageDialog(miMapaVista, "La posicion esta ocupada",
					"Error",
			    	JOptionPane.ERROR_MESSAGE);
		}
		
		miJugador.notificarObservadorSobreSeleccion();
		miJuego.jugadorActual.notificarObservadorSobreSeleccion();
		miMapaVista.actualizar();
		if(miJuego.hayGanador()) {
			JOptionPane.showMessageDialog(miMapaVista, "Ganador: "+miJuego.getGanador().getNombre(),
					"Felicitaciones!",
			    	JOptionPane.WARNING_MESSAGE);
		}
	}
	

}
