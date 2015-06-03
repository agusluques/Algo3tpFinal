package fiuba.algo3.tpfinal.programa;

import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Constructible;

public class Arquitecto {
	
	public void construir(Jugador jugador, Constructible construccion) throws ConstruccionRequeridaInexistente {
		try {
			this.verificarNecesidades(jugador, construccion);
			this.cobrarConstruccion(jugador, construccion);
			jugador.agregarConstruccion(construccion);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		} catch (ConstruccionRequeridaInexistente e) {
			throw e;
		}
		
	}

	private void verificarNecesidades(Jugador jugador,
			Constructible construccion) throws ConstruccionRequeridaInexistente {
		Collection<Constructible> unidadesNecesarias = construccion.construccionesNecesarias();
		Iterator<Constructible> iterador = unidadesNecesarias.iterator();
		while (iterador.hasNext()) {
			if (!jugador.posee(iterador.next())) {
				throw new ConstruccionRequeridaInexistente();
			}
		}
		
	}

	private void cobrarConstruccion(Jugador jugador, Constructible construccion) {
		try {
			int costoConstruccionMineral = construccion.getCostoMineral();
			int costoConstruccionGas = construccion.getCostoGas();
			jugador.gastarMineral(costoConstruccionMineral);
			jugador.gastarGas(costoConstruccionGas);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}
	

}
