package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class CentroDeMineral implements Constructible {

	private int vida;
	private Costo costo;
	private int tiempo;
	
	public CentroDeMineral(){
		this.vida = 500;
		this.costo = new Costo();
		this.costo.setMinerales(50);
		this.tiempo = 4; 
	}
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
