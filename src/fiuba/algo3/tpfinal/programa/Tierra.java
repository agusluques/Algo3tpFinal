package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;


public class Tierra extends Superficie {
	
	public Tierra() {
		nombre = "tierra";
	}
	
	@Override
	public boolean puedeRecibir(Trasladable unidad) {
		return unidad.sePuedeMoverA(this);
	}
	
	
}
