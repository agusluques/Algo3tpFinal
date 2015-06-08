package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.unidades.Fabricable;

public abstract class ConstruccionesProtoss extends Protoss implements Constructible{

	protected Collection<Constructible> construccionesNecesarias;
	protected Superficie superficieNecesaria;
	protected Jugador jugador;
	protected Costo costo;
	protected int tiempoDeConstruccion;
	
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
	public int getTiempoRestante() {
		return this.tiempoDeConstruccion;
	}
	
	@Override
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
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
	
	@Override
	public void avanzarConstruccion() {
		if (this.tiempoDeConstruccion > 0){
			this.tiempoDeConstruccion -= 1;
		}
	}
	
	
}
