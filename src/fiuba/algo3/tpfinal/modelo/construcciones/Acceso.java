package fiuba.algo3.tpfinal.modelo.construcciones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class Acceso extends ConstruccionProtoss {

	private ArrayList<Fabricable> unidadesEnConstruccion;;

	public Acceso() {
		this.vida = new VidaConEscudo(500, 500);
		this.tiempoDeConstruccion = 8;
		this.costo = new Costo(150);
		this.superficieNecesaria = new Tierra();
		this.unidadesEnConstruccion = new ArrayList<Fabricable>();
	}

	public void fabricarZealot() throws MineralInsuficiente, GasInsuficiente {
		this.fabricar(new Zealot());
	}

	public void fabricarDragon() throws MineralInsuficiente, GasInsuficiente {
		this.fabricar(new Dragon());
	}

	private void fabricar(Fabricable unidad) throws MineralInsuficiente, GasInsuficiente {
		if (unidadesEnConstruccion.size() < 6) {
			try {
				jugador.getPresupuesto().gastar(unidad.getCosto());
				unidadesEnConstruccion.add(unidad);
				jugador.notificarObservador();
				this.notificarObservador();
			} catch (MineralInsuficiente e) {
				throw e;
			} catch (GasInsuficiente e) {
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
					this.jugador
							.agregarUnidad(
									(UnidadProtoss) unidadEnConstruccion,
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

	//Solo para usar en la vista
		public ArrayList<Fabricable> getUnidadesEnConstruccion(){
			return this.unidadesEnConstruccion;
		}
}
