package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;

public class Aire extends Superficie {
	
	public Aire() {
		nombre = "aire";
	}
	
	@Override
	public boolean puedeRecibir(Trasladable unidad) {
		return unidad.sePuedeMoverA(this);
	}
		
	
}
