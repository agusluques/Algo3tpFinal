package fiuba.algo3.tpfinal.vista.programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.Jugador;

public class AccionPasarTurno implements ActionListener {
	
	private Juego miJuego;
	private Jugador miJugador;

	public AccionPasarTurno(Juego juego, Jugador jugador) {
		miJuego = juego;
		miJugador = jugador;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		miJuego.pasarTurno(miJugador);
		miJugador.notificarObservadorSobreSeleccion();
		miJuego.jugadorActual.notificarObservadorSobreSeleccion();
	}

}
