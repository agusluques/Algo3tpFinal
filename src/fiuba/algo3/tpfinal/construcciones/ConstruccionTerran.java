package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Terran;

public abstract class ConstruccionTerran extends Terran implements
		Constructible {

	protected Costo costo;
	protected int tiempoDeConstruccion;
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
		return tiempoDeConstruccion;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public boolean equals(Object o) {
		return (this.getClass() == o.getClass());
	}

	@Override
	public int hashCode() {
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
		if (this.tiempoDeConstruccion > 0) {
			this.tiempoDeConstruccion -= 1;
		}
	}

}
