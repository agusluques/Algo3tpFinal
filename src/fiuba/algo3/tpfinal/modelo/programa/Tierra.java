package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;

public class Tierra extends Superficie {

	@Override
	public boolean puedeRecibir(Trasladable unidad) {
		return unidad.sePuedeMoverA(this);
	}

}
