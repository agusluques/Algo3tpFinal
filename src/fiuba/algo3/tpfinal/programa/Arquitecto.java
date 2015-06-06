package fiuba.algo3.tpfinal.programa;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;

public class Arquitecto {
	
	private Mapa mapa;
	private Presupuesto presupuesto;
	private Collection<Constructible> construcciones;
	
	public Arquitecto(Presupuesto presupuesto,Collection<Constructible> construcciones, Mapa mapa ){
		this.mapa = mapa;
		this.presupuesto = presupuesto;
		this.construcciones = construcciones; 
	}
	
	public void construir(Constructible construccion, Coordenada posicion) throws ConstruccionRequeridaInexistente {
		try {
			this.verificarTerreno(construccion, posicion);
			this.verificarConstruccionesNecesarias(construccion);
			this.cobrarConstruccion(construccion);
			this.construcciones.add(construccion);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		} catch (ConstruccionRequeridaInexistente e) {
			throw e;
		} catch (TerrenoInapropiado e){
			throw e;
		} catch (ParcelaOcupada e){
			throw e;
		}
		
	}

	private void verificarConstruccionesNecesarias(Constructible construccion) throws ConstruccionRequeridaInexistente {
		Collection<Constructible> unidadesNecesarias = construccion.construccionesNecesarias();
		Iterator<Constructible> iterador = unidadesNecesarias.iterator();
		while (iterador.hasNext()) {
			if (!this.construcciones.contains(iterador.next())) {
				throw new ConstruccionRequeridaInexistente();
			}
		}
		
	}
	
	private void verificarTerreno(Constructible construccion, Coordenada posicion){
		if(this.mapa.getParcela(posicion).estaVacia()){
			Superficie supRequerida = construccion.superficieNecesaria();
			Superficie supEnLaQueQuieroConstruir = this.mapa.getParcela(posicion).getSuperficie();
			if(!supRequerida.equals(supEnLaQueQuieroConstruir)){
				throw new TerrenoInapropiado();
			}
		}else{
			throw new ParcelaOcupada();
		}
	}

	private void cobrarConstruccion(Constructible construccion) {
		try {
			int costoConstruccionMineral = construccion.getCostoMineral();
			int costoConstruccionGas = construccion.getCostoGas();
			this.presupuesto.removerMineral(costoConstruccionMineral);
			this.presupuesto.removerGas(costoConstruccionGas);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}
	

}
