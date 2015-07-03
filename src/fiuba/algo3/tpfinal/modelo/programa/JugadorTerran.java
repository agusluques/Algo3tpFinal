package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;

public class JugadorTerran extends Jugador {

	public JugadorTerran(String nombre, Mapa mapa) {
		super(nombre, mapa);

	}

	public void construir(ConstruccionTerran construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {
		construccion.setJugador(this);
		this.arquitecto.construir(construccion, posicion);

	}

	public void agregarUnidad(UnidadTerran unidad, Coordenada coord)
			throws LimitePoblacionalAlcanzado, ParcelaOcupada {
		if ((this.contarPoblacion() + unidad.getSuministro()) <= this
				.limitePoblacional()) {
			this.unidades.add((Atacable) unidad);
			this.mapa.ubicarCercaDe((Atacable) unidad, coord);
			((Terran) unidad).setJugador(this);
		} else {
			throw new LimitePoblacionalAlcanzado();
		}

	}

	@Override
	protected void agregarUnidadBasica() {
		Atacable unidadBasica = new Marine();

		this.unidades.add(unidadBasica);
		try {
			this.mapa.ubicarCercaDe(unidadBasica, this.baseInicial);
		} catch (ParcelaOcupada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Terran) unidadBasica).setJugador(this);
	}
}
