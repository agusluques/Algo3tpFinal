package fiuba.algo3.tpfinal.modelo.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Protoss;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;

public abstract class ConstruccionProtoss extends Protoss implements
		Constructible {

	protected Superficie superficieNecesaria;
	protected Costo costo;
	protected int tiempoDeConstruccion;

	@Override
	public Costo getCosto() {
		return this.costo;
	}

	public boolean estaEnContruccion(){
		return (tiempoDeConstruccion>0);
	}
	
	@Override
	public int getTiempoRestante() {
		return this.tiempoDeConstruccion;
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

	protected boolean esValidaLaUbicacion(Parcela ubicacion) throws TerrenoInapropiado, ParcelaOcupada {
		if(!ubicacion.estaVacia()) {
			throw new ParcelaOcupada();
		}
		if(!ubicacion.getSuperficie().equals(superficieNecesaria)) {
			throw new TerrenoInapropiado();
		}
		return true;
	}

	protected boolean construccionesRequeridasEncontradas(
			Collection<Constructible> construccionesNecesarias) throws ConstruccionRequeridaInexistente {
		for (Constructible construccionRequerida : construccionesNecesarias) {
			if (!this.jugador.getConstrucciones().contains(
					construccionRequerida)) {
				throw new ConstruccionRequeridaInexistente();
			}
		}
		return true;
	}

	@Override
	public boolean puedeConstruirseEn(Parcela ubicacion) throws ParcelaOcupada, TerrenoInapropiado, ConstruccionRequeridaInexistente {
		return this.esValidaLaUbicacion(ubicacion);
	}
	
	@Override
	public Coordenada getPosicion() {
		return this.posicion;
	}

	@Override
	public void recibirImpactoEMP(){}
}
