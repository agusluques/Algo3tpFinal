package fiuba.algo3.tpfinal.programa;

public class Juego {
	public Jugador jugadorUno;
	public Jugador jugadorDos;
	
	public Juego(Jugador jugadorUno, Jugador jugadorDos){
		this.jugadorUno = jugadorUno;
		this.jugadorDos = jugadorDos;
	}
	
	public void pasarTurno(Jugador jugador){
		Jugador otroJugador = jugadorUno;
		if (jugador == jugadorUno) {
			otroJugador = jugadorDos;
		}
		jugador.pasarTurno();
		if (otroJugador.estaExtinto() || jugador.estaExtinto()){
			Jugador ganador = jugador;
			if(jugador.estaExtinto()) {
				ganador = otroJugador;
			}
			System.out.print("GANOOOOO: ");
			System.out.println(ganador.nombre);
		} else{
			otroJugador.empezarTurno();
		}
	}
	
	public void empezarTurno(Jugador jugador){
		jugador.empezarTurno();
	}

}
