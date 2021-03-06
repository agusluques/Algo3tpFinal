package fiuba.algo3.tpfinal.modelo.programa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.Constructible;
import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;

public class Arquitecto {

	protected Mapa mapa;
	protected Jugador jugador;
	protected Collection<Constructible> construccionesEnConstruccion;

	public Arquitecto(Mapa mapa, Jugador jugador) {
		this.mapa = mapa;
		this.jugador = jugador;
		this.construccionesEnConstruccion = new ArrayList<Constructible>();
	}

	public void construir(Constructible construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {

		if (construccion.puedeConstruirseEn(mapa.getParcela(posicion))) {
			this.cobrarConstruccion(construccion);
			this.jugador.notificarObservador();
			this.construccionesEnConstruccion.add(construccion);
			((Atacable) construccion).setCoordenada(posicion);
			this.mapa.insertarUnidad(posicion,(Atacable) construccion);
		}

	}

	private void cobrarConstruccion(Constructible construccion) throws MineralInsuficiente, GasInsuficiente {
		try {
			this.jugador.getPresupuesto().gastar(construccion.getCosto());
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}

	public void pasarTurno() throws ParcelaOcupada {
		Iterator<Constructible> iterador = construccionesEnConstruccion
				.iterator();
		while (iterador.hasNext()) {
			Constructible construccionEnConstruccion = iterador.next();
			construccionEnConstruccion.avanzarConstruccion();
			if (construccionEnConstruccion.getTiempoRestante() == 0) {
				this.jugador.getConstrucciones()
						.add(construccionEnConstruccion);
				this.mapa.notificarObservador(); 
				iterador.remove();
			}
		}
	}

}
