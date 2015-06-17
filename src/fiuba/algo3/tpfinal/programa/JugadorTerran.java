package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.UnidadTerran;

public class JugadorTerran extends Jugador {

	public JugadorTerran(String nombre, Mapa mapa) {
		super(nombre, mapa);
		Atacable unidadBasica = new Marine();

		// TODO: hay que inicializar esta coordenada en donde arranque el
		// jugador
		unidadBasica.setCoordenada(new Coordenada(0, 0));
		this.unidades.add(unidadBasica);

	}

	public void construir(ConstruccionTerran construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente {
		construccion.setJugador(this);
		this.arquitecto.construir(construccion, posicion);

	}

	public void agregarUnidad(UnidadTerran unidad, Coordenada coord)
			throws LimitePoblacionalAlcanzado {
		if ((this.contarPoblacion() + unidad.getSuministro()) <= this
				.limitePoblacional()) {
			this.unidades.add((Atacable) unidad);
			this.mapa.ubicarCercaDe((Atacable) unidad, coord);
			((Terran) unidad).setJugador(this);
		} else {
			throw new LimitePoblacionalAlcanzado();
		}

	}
}
