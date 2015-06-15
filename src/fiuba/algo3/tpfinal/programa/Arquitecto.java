package fiuba.algo3.tpfinal.programa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;

public class Arquitecto {

	protected  Mapa mapa;
	protected Presupuesto presupuesto;
	protected  Collection<Constructible> construcciones;
	protected Jugador jugador;
	protected  Collection<Constructible> construccionesEnConstruccion;

	public Arquitecto(Presupuesto presupuesto,
			Collection<Constructible> construcciones, Mapa mapa, Jugador jugador) {
		this.mapa = mapa;
		this.presupuesto = presupuesto;
		this.construcciones = construcciones;
		this.jugador = jugador;
		this.construccionesEnConstruccion = new ArrayList<Constructible>();
	}



	public void construir(Constructible construccion, Coordenada posicion)
			throws ConstruccionRequeridaInexistente {
		
		try {
			if (construccion.podesConstruirte(mapa.getParcela(posicion),construcciones)){
				this.cobrarConstruccion(construccion);
				this.construccionesEnConstruccion.add(construccion);
				this.mapa.getParcela(posicion).ocupar((Atacable) construccion);
				((Atacable) construccion).setCoordenada(posicion);
			}
			
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		} catch (TerrenoInapropiado e) {
			throw e;
		} catch (ParcelaOcupada e) {
			throw e;
		}

	}
	protected void cobrarConstruccion(Constructible construccion) {
		try {
			this.presupuesto.gastar(construccion.getCosto());
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}

	public void pasarTurno() {
		Iterator<Constructible> iterador = construccionesEnConstruccion
				.iterator();
		while (iterador.hasNext()) {
			Constructible construccionEnConstruccion = iterador.next();
			construccionEnConstruccion.avanzarConstruccion();
			if (construccionEnConstruccion.getTiempoRestante() == 0) {
				construcciones.add(construccionEnConstruccion);
				iterador.remove();
			}
		}
	}

}
