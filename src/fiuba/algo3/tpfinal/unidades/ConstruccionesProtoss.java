package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public abstract class ConstruccionesProtoss extends Protoss implements Constructible {

	protected Costo costo;
	protected int tiempo;
	protected static String unidadesHechas = new String();

	@Override
	public int getCostoMineral() {
		int mineralNecesario = this.costo.getMinerales();
		return mineralNecesario;
	}

	@Override
	public int getCostoGas() {
		int gasNecesario = this.costo.getGas();
		return gasNecesario;
	}

	@Override
	public int getTiempo() {
		return this.tiempo;
	}
}
