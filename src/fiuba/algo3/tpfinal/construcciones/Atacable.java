package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;

public interface Atacable {
	
	void atacado(Danio danio);

	Coordenada getCoordenada();

	boolean estaMuerto();

	void setCoordenada(Coordenada posicion);

	void setJugador(Jugador jugador);
}
