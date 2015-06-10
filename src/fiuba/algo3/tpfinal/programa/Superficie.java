package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;

public abstract class Superficie {

	protected String nombre;

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean equals(Object o) {
		Superficie sup = (Superficie) o;
		return (this.nombre == sup.getNombre());
	}

	@Override
	public int hashCode() {
		return this.nombre.hashCode();
	}

	public abstract boolean puedeRecibir(Trasladable unidad);
}
