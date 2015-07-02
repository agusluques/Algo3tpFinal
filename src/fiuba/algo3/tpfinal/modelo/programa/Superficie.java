package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;
import fiuba.algo3.tpfinal.vista.Observable;

public abstract class Superficie extends Observable{

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
