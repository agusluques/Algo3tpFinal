package fiuba.algo3.tpfinal.programa;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;

public class Arquitecto {
	
	public void construir(Collection<Constructible> construcciones, Constructible construccion, Presupuesto presupuesto) throws ConstruccionRequeridaInexistente {
		try {
			this.verificarNecesidades(construcciones, construccion);
			this.cobrarConstruccion(presupuesto, construccion);
			construcciones.add(construccion);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		} catch (ConstruccionRequeridaInexistente e) {
			throw e;
		}
		
	}

	private void verificarNecesidades(Collection<Constructible> construcciones, Constructible construccion) throws ConstruccionRequeridaInexistente {
		Collection<Constructible> unidadesNecesarias = construccion.construccionesNecesarias();
		Iterator<Constructible> iterador = unidadesNecesarias.iterator();
		while (iterador.hasNext()) {
			if (!construcciones.contains(iterador.next())) {
				throw new ConstruccionRequeridaInexistente();
			}
		}
		
	}

	private void cobrarConstruccion(Presupuesto presupuesto, Constructible construccion) {
		try {
			int costoConstruccionMineral = construccion.getCostoMineral();
			int costoConstruccionGas = construccion.getCostoGas();
			presupuesto.removerMineral(costoConstruccionMineral);
			presupuesto.removerGas(costoConstruccionGas);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}
	

}
