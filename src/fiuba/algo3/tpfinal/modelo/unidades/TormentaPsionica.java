package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.Jugador;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;

public class TormentaPsionica extends Magia {

	protected Mapa mapa;
	protected Jugador lanzador;
	protected Coordenada posicion;
	protected int duracion = 2;

	public TormentaPsionica(Jugador lanzador, Mapa mapa, Coordenada posicion) {
		this.mapa = mapa;
		this.posicion = posicion;
		this.lanzador = lanzador;
	}

	public boolean estaMuerto() {
		return (duracion <= 0);
	}

	public void pasarTurno() {
		if (!estaMuerto()) {
			for (Atacable unidadActual : mapa.unidadesEnUnRadio(posicion, 1)) {
				if (!this.lanzador.equals(unidadActual.getJugador())) {
					unidadActual.atacado(new Danio(100, 100));
				}
			}
			duracion--;
		}
	}
}
