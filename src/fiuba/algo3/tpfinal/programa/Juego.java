package fiuba.algo3.tpfinal.programa;

public class Juego {
	public Jugador jugadorUno;
	public Jugador jugadorDos;
	public Jugador jugadorActual;
	public Jugador jugadorEnEspera;
	private Mapa mapa;

	public Juego(Jugador jugadorUno, Jugador jugadorDos, Mapa mapa) {
		this.mapa = mapa;
		this.jugadorUno = jugadorUno;
		jugadorUno.inicializarEnPrimeraBase();
		this.jugadorDos = jugadorDos;
		jugadorDos.inicializarEnUltimaBase();
		this.jugadorActual = jugadorUno;
		this.jugadorEnEspera = jugadorDos;
	}

	public void pasarTurno(Jugador jugador) {
		Jugador otroJugador = jugadorUno;
		if (jugador.nombre == jugadorUno.nombre) {
			otroJugador = jugadorDos;
		}
		jugadorActual.pasarTurno();
		otroJugador.empezarTurno();
		if (otroJugador.estaExtinto() || jugador.estaExtinto()) {
			Jugador ganador = jugador;
			if (jugador.estaExtinto()) {
				ganador = otroJugador;
			}
			System.out.print("GANOOOOO: ");
			System.out.println(ganador.nombre);
		}
		jugadorEnEspera = jugadorActual;
		jugadorActual = otroJugador;
	}

	public Mapa getMapa() {
		return mapa;
	}

}
