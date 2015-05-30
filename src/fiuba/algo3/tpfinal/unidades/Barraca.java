package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Barraca implements Constructible{

	private Costo costo;
	private int vida;
	private int tiempo;

	public Barraca(){
		this.vida = 1000;
		this.costo = new Costo(150);
		this.tiempo = 12;
	}
	
	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public int getCostoMineral() {
		return this.costo.getMinerales();
	}

	@Override
	public int getCostoGas() {
		return this.getCostoGas();
	}

	@Override
	public int getTiempo() {
		return this.tiempo;
	}

	
	

}
