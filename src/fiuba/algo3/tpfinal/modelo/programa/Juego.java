package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;

public class Juego {
	public Jugador jugadorUno;
	public Jugador jugadorDos;
	public Jugador jugadorActual;
	public Jugador ganador;
	private Mapa mapa;

	public Juego(Jugador jugadorUno, Jugador jugadorDos, Mapa mapa) {
		this.mapa = mapa;
		this.jugadorUno = jugadorUno;
		jugadorUno.inicializarEnPrimeraBase();
		this.jugadorDos = jugadorDos;
		jugadorDos.inicializarEnUltimaBase();
		this.jugadorActual = jugadorUno;
	}

	public void pasarTurno(Jugador jugador) throws ParcelaOcupada {
		Jugador otroJugador = jugadorUno;
		if (jugador.nombre == jugadorUno.nombre) {
			otroJugador = jugadorDos;
		}
		jugadorActual.pasarTurno();
		otroJugador.empezarTurno();
		if (otroJugador.estaExtinto() || jugador.estaExtinto()) {
			ganador = jugador;
			if (jugador.estaExtinto()) {
				ganador = otroJugador;
			}
			System.out.print("GANOOOOO: ");
			System.out.println(ganador.nombre);
		}
		jugadorActual = otroJugador;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public boolean hayGanador() {
		return (jugadorUno.estaExtinto() || jugadorDos.estaExtinto());
	}
	
	public Jugador getGanador() {
		return ganador;
	}

}
