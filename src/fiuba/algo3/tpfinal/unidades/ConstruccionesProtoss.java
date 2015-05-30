package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public abstract class ConstruccionesProtoss extends Protoss implements ConstructibleProtoss {

	protected int vida;
	protected int escudo;
	protected Costo costo;
	protected int tiempo;
	
	@Override
	public int getVida() {
		return this.vida;
	}
	
	@Override
	public int getEscudo() {
		return this.escudo;
	}

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
