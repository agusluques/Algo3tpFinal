package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.UnidadesTerran;

public class Aire extends Superficie {
	
	public Aire() {
		nombre = "aire";
	}
	
	@Override
	public boolean puedeRecibir(UnidadesTerran unidadesTerran) {
		return unidadesTerran.sePuedeMoverA(this);
	}
		
	
}
