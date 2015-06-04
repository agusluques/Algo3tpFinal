package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;

public abstract class ConstruccionesTerran extends Terran implements Constructible{
	
	protected Costo costo;
	protected int tiempo;
	protected Collection<Constructible> construccionesNecesarias;
	
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
		return (this.getClass() == construccion.getClass());
	}
	
	@Override
	public int hashCode(){
		return this.hashCode();
		
	}
	
	@Override
	public Collection<Constructible> construccionesNecesarias() {
		return this.construccionesNecesarias;
	}
}
