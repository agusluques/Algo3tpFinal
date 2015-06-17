package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.unidades.UnidadTerran;

public class Barraca extends ConstruccionTerran {

	private ArrayList<Fabricable> unidadesEnConstruccion;

	public Barraca() {
		this.vida.inicializarVida(1000);
		this.costo = new Costo(150);
		this.tiempoDeConstruccion = 12;
		this.superficieNecesaria = new Tierra();
		this.unidadesEnConstruccion = new ArrayList<Fabricable>();
	}

	public void fabricarMarine() {
		if (unidadesEnConstruccion.size() < 6) {
			try {
				jugador.getPresupuesto().gastar(new Marine().getCosto());
				unidadesEnConstruccion.add(new Marine());
			} catch (MineralInsuficiente e) {
				throw e;
			}
		}
	}

	
	public void pasarTurno(Jugador jugador, Mapa mapa) {
		if (unidadesEnConstruccion.size() > 0) {
			Iterator<Fabricable> iterador = unidadesEnConstruccion.iterator();
			Fabricable unidadEnConstruccion = iterador.next();
			unidadEnConstruccion.avanzarFabricacion();
			if (unidadEnConstruccion.getTiempoRestante() == 0) {
				try {
					this.jugador.agregarUnidad((UnidadTerran)unidadEnConstruccion,
							this.posicion);
					iterador.remove();
				} catch (LimitePoblacionalAlcanzado e) {
					throw e;
				}
			}
		}
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}


}
