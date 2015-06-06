package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Superficie;

public abstract class ConstruccionesTerran extends Terran implements Constructible{
	
	protected Costo costo;
	protected int tiempo;
	protected Collection<Constructible> construccionesNecesarias;
	protected Superficie superficieNecesaria;
	protected Jugador jugador;
	
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


}
