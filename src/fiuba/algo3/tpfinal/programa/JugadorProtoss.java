package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class JugadorProtoss extends Jugador {

	public JugadorProtoss(String nombre, Mapa mapa) {
		super(nombre, mapa);
		Atacable unidadBasica = new Zealot();

		// TODO: hay que inicializarla donde arranque el jugador
		unidadBasica.setCoordenada(new Coordenada(0, 0));
		this.unidades.add(unidadBasica);

	}

	public void construir(ConstruccionProtoss construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente {
		construccion.setJugador(this);
		this.arquitecto.construir(construccion, posicion);

	}

	public void agregarUnidad(UnidadProtoss unidad, Coordenada coord)
			throws LimitePoblacionalAlcanzado {
		if ((this.contarPoblacion() + unidad.getSuministro()) <= this
				.limitePoblacional()) {
			this.unidades.add((Atacable) unidad);
			this.mapa.ubicarCercaDe((Atacable) unidad, coord);
			((Protoss) unidad).setJugador(this);
		} else {
			throw new LimitePoblacionalAlcanzado();
		}

	}
}
