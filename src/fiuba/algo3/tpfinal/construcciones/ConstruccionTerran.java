package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Terran;

public abstract class ConstruccionTerran extends Terran implements
		Constructible {

	protected Costo costo;
	protected int tiempoDeConstruccion;
	protected Superficie superficieNecesaria;

	@Override
	public Costo getCosto() {
		return this.costo;
	}

	@Override
	public int getTiempoRestante() {
		return tiempoDeConstruccion;
	}

	@Override
	public boolean equals(Object o) {
		return (this.getClass() == o.getClass());
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode();

	}

	@Override
	public void avanzarConstruccion() {
		if (this.tiempoDeConstruccion > 0) {
			this.tiempoDeConstruccion -= 1;
		}
	}

	@Override
	public int aumentoDePoblacion() {
		return 0;
	}

	protected boolean esValidaLaUbicacion(Parcela ubicacion) {
		return (ubicacion.estaVacia() && ubicacion.getSuperficie().equals(
				superficieNecesaria));
	}

	protected boolean construccionesRequeridasEncontradas(
			Collection<Constructible> construccionesNecesarias) {
		boolean aux = true;
		for (Constructible construccionRequerida : construccionesNecesarias) {
			if (!this.jugador.getConstrucciones().contains(
					construccionRequerida)) {
				aux = false;
			}
		}
		return aux;
	}

	@Override
	public boolean puedeConstruirseEn(Parcela ubicacion) {
		return this.esValidaLaUbicacion(ubicacion);
	}
	
	@Override
	public Coordenada getPosicion() {
		return this.posicion;
	}

}
