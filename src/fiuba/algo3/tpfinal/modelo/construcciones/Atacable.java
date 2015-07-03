package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.Jugador;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

public interface Atacable {

	void atacado(Danio danio);

	Coordenada getCoordenada();

	boolean estaMuerto();

	void setCoordenada(Coordenada posicion);

	Jugador getJugador();

	int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango);

	void pasarTurno() throws ParcelaOcupada;

}
