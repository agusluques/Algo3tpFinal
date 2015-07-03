package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class JugadorProtoss extends Jugador {

	public JugadorProtoss(String nombre, Mapa mapa) {
		super(nombre, mapa);

	}

	public void construir(ConstruccionProtoss construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {
		construccion.setJugador(this);
		this.arquitecto.construir(construccion, posicion);

	}

	public void agregarUnidad(UnidadProtoss unidad, Coordenada coord)
			throws LimitePoblacionalAlcanzado, ParcelaOcupada {
		if ((this.contarPoblacion() + unidad.getSuministro()) <= this
				.limitePoblacional()) {
			((Protoss) unidad).setJugador(this);
			this.unidades.add((Atacable) unidad);
			this.mapa.ubicarCercaDe((Atacable) unidad, coord);
			((Protoss) unidad).setJugador(this);
		} else {
			throw new LimitePoblacionalAlcanzado();
		}

	}

	@Override
	protected void agregarUnidadBasica() {
		Atacable unidadBasica = new Zealot();

		this.unidades.add(unidadBasica);
		try {
			this.mapa.ubicarCercaDe(unidadBasica, this.baseInicial);
		} catch (ParcelaOcupada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Protoss) unidadBasica).setJugador(this);
	}
}
