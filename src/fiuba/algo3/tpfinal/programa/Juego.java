package fiuba.algo3.tpfinal.programa;

public class Juego {
	public Jugador jugadorUno;
	public Jugador jugadorDos;
	
	public Juego(Jugador jugadorUno, Jugador jugadorDos){
		this.jugadorUno = jugadorUno;
		this.jugadorDos = jugadorDos;
	}
	
	public void pasarTurno(Jugador jugador){
		jugador.pasarTurno();
		if (jugador.estaExtinto()){
			System.out.print("GANOOOOO: ");
			System.out.println(jugadorDos.nombre);
		}
	}
	
	public void empezarTurno(Jugador jugador){
		jugador.empezarTurno();
	}

}
