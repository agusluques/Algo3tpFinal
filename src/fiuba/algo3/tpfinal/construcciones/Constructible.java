package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Superficie;

public interface Constructible {

	Collection<Constructible> construccionesNecesarias();

	Superficie superficieNecesaria();

	int getCostoMineral();

	int getCostoGas();

	int getTiempoRestante();

	boolean equals(Object o);

	void setJugador(Jugador jugador);

	void avanzarConstruccion();
}
