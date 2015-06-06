package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Superficie;

public abstract class ConstruccionesProtoss extends Protoss implements Constructible {

	protected Costo costo;
	protected int tiempo;
	protected Collection<Constructible> construccionesNecesarias;
	protected Superficie superficieNecesaria;
	
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
		
		return (this.getClass() == o.getClass());
	}
	
	@Override
	public int hashCode(){
		return this.hashCode();
		
	}
	
	@Override
	public Collection<Constructible> construccionesNecesarias() {
		return this.construccionesNecesarias;
	}
	
	@Override
	public Superficie superficieNecesaria() {
		return this.superficieNecesaria;
	}

}
