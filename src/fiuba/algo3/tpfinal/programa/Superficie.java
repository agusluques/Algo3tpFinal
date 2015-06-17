package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;

public abstract class Superficie {

	@Override
	public boolean equals(Object o) {
		return (this.getClass() == o.getClass());
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();
	}

	public abstract boolean puedeRecibir(Trasladable unidad);
}
