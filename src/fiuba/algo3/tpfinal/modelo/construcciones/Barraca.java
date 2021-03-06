package fiuba.algo3.tpfinal.modelo.construcciones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;

public class Barraca extends ConstruccionTerran {

	private ArrayList<Fabricable> unidadesEnConstruccion;

	public Barraca() {
		this.vida = new VidaSimple(1000);
		this.costo = new Costo(150);
		this.tiempoDeConstruccion = 12;
		this.superficieNecesaria = new Tierra();
		this.unidadesEnConstruccion = new ArrayList<Fabricable>();
	}

	public void fabricarMarine() throws GasInsuficiente, MineralInsuficiente {
		if (unidadesEnConstruccion.size() < 6) {
			try {
				jugador.getPresupuesto().gastar(new Marine().getCosto());
				unidadesEnConstruccion.add(new Marine());
				jugador.notificarObservador();
				this.notificarObservador();
			} catch (MineralInsuficiente e) {
				throw e;
			}
		}
	}

	public void pasarTurno() throws ParcelaOcupada {
		if (unidadesEnConstruccion.size() > 0) {
			Iterator<Fabricable> iterador = unidadesEnConstruccion.iterator();
			Fabricable unidadEnConstruccion = iterador.next();
			unidadEnConstruccion.avanzarFabricacion();
			if (unidadEnConstruccion.getTiempoRestante() == 0) {
				try {
					this.jugador.agregarUnidad(
							(UnidadTerran) unidadEnConstruccion, this.posicion);
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
	
	//Solo para usar en la vista
	public ArrayList<Fabricable> getUnidadesEnConstruccion(){
		return this.unidadesEnConstruccion;
	}
}
