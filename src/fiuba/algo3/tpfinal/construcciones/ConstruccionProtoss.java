package fiuba.algo3.tpfinal.construcciones;

import java.util.Collection;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Protoss;
import fiuba.algo3.tpfinal.programa.Superficie;

public abstract class ConstruccionProtoss extends Protoss implements
		Constructible {


	protected Superficie superficieNecesaria;
	protected Costo costo;
	protected int tiempoDeConstruccion;

	@Override
	public Costo getCosto(){
		return this.costo;
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
	public int aumentoDePoblacion(){
		return 0;
	}
	
	protected boolean esValidaLaUbicacion(Parcela ubicacion){
		return (ubicacion.estaVacia()&& ubicacion.getSuperficie().equals(superficieNecesaria));
	}
	
	protected boolean construccionesRequeridasEncontradas(Collection<Constructible> construccionesNecesarias){
		boolean aux = true;
		for (Constructible construccionRequerida : construccionesNecesarias){
			if(!this.jugador.getConstrucciones().contains(construccionRequerida)){
				aux = false;
			}
		}
		return aux;
	}
	
	@Override
	public boolean puedeConstruirseEn(Parcela ubicacion){
		return this.esValidaLaUbicacion(ubicacion);
	}

}
