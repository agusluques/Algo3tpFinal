package fiuba.algo3.tpfinal.unidades;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;

public abstract class ConstruccionesTerran extends Terran implements Constructible{
	
	protected int vida;
	protected Costo costo;
	protected int tiempo;
	private Collection<Constructible> construccionesNecesarias;
	
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
	
	@Override
	public boolean equals(Object o) {
		ConstruccionesTerran construccion = (ConstruccionesTerran) o;
		System.out.println(this.getClass());
		System.out.println(construccion.getClass());
		return (this.getClass() == construccion.getClass());
	}
	
	@Override
	public Collection<Constructible> construccionesNecesarias() {
		return this.construccionesNecesarias;
	}
}
