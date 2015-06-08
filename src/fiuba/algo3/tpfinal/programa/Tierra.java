package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.UnidadesTerran;

public class Tierra extends Superficie {
	
	public Tierra() {
		nombre = "tierra";
	}
	
	@Override
	public boolean puedeRecibir(UnidadesTerran unidadesTerran) {
		return unidadesTerran.sePuedeMoverA(this);
	}
	
	
}
