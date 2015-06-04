package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;

public abstract class ConstruccionesProtoss extends Protoss implements Constructible {

	protected Costo costo;
	protected int tiempo;
	protected Collection<Constructible> construccionesNecesarias;

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
	
	@Override
	public boolean equals(Object o) {
		ConstruccionesProtoss construccion = (ConstruccionesProtoss) o;
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
