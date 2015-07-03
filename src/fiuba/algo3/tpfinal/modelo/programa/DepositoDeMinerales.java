package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.unidades.Trasladable;

public class DepositoDeMinerales extends Superficie {

	private int mineralesRestantes;

	public DepositoDeMinerales() {
		mineralesRestantes = 1000;

	}

	public int extraerRecursos() {
		if (this.mineralesRestantes > 0) {
			this.mineralesRestantes -= 10;
			return 10;
		}
		return 0;
	}

	public int getRecursos() {
		return this.mineralesRestantes;
	}

	@Override
	public boolean puedeRecibir(Trasladable unidad) {
		return unidad.sePuedeMoverA(this);
	}

}
