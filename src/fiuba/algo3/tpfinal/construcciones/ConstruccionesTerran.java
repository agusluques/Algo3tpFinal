package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.unidades.Fabricable;

public abstract class ConstruccionesTerran extends Terran implements Constructible, Fabricable{
	
	protected Costo costo;
	protected int tiempo;
	protected Collection<Constructible> construccionesNecesarias;
	protected Superficie superficieNecesaria;
	protected Jugador jugador;
	
	@Override
	public int getCostoMineral() {
		return costo.getMinerales();
	}
	
	@Override
	public int getCostoGas() {
		return costo.getGas();
	}
	
	@Override
	public int getTiempoRestante() {
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
	
	@Override
	public void avanzarFabricacion() {
		tiempo -= 1;
	}
	
	@Override
	public int getSuministro() {
		return 0;
	}


}
