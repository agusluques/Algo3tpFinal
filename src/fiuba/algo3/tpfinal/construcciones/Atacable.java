package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Rango;

public interface Atacable {

	void atacado(Danio danio);

	Coordenada getCoordenada();

	boolean estaMuerto();

	void setCoordenada(Coordenada posicion);

	Jugador getJugador();

	int rangoDeAtaqueCorrespondiente(Rango rango);

	void pasarTurno(Jugador jugador, Mapa mapa);
}
