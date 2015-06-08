package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.unidades.Trasladable;

public class DepositoDeMinerales extends Superficie {
	
	private int mineralesRestantes;
	
	public DepositoDeMinerales(){
		mineralesRestantes = 1000;
		nombre = "depositoDeMinerales";
	}
	

	public int extraerRecursos() {
		if (this.mineralesRestantes > 0) {
			this.mineralesRestantes -= 10;
			return 10;
		}
		return 0;
	}

	public int getRecursos(){
		return this.mineralesRestantes;
	}
	
	@Override
	public boolean puedeRecibir(Trasladable unidad) {
		return unidad.sePuedeMoverA(this);
	}

}
