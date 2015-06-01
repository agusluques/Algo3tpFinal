package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class ConstruccionesTerran implements Constructible{
	
	protected int vida;
	protected Costo costo;
	protected int tiempo;
	protected static String unidadesHechas = new String();
	
	public int getVida() {
		return this.vida;
	}
	public int getCostoMineral() {
		return costo.getMinerales();
	}
	
	public int getCostoGas() {
		return costo.getGas();
	}
	
	public int getTiempo() {
		return tiempo;
	}
}
