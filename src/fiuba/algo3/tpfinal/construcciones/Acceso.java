package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.programa.VidaConEscudo;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class Acceso extends ConstruccionProtoss {

	
	private ArrayList<Fabricable> unidadesEnConstruccion;;

	public Acceso() {
		this.vida = new VidaConEscudo(500,500);
		this.tiempoDeConstruccion = 8;
		this.costo = new Costo(150);
		this.superficieNecesaria = new Tierra();
		this.unidadesEnConstruccion = new ArrayList<Fabricable>();
	}

	public void fabricarZealot() {
		this.fabricar(new Zealot());
	}

	public void fabricarDragon() {
		this.fabricar(new Dragon());
	}

	public void fabricar(Fabricable unidad) {
		if (unidadesEnConstruccion.size() < 6) {
			try {
				jugador.getPresupuesto().gastar(unidad.getCosto());
				unidadesEnConstruccion.add(unidad);
			} catch (MineralInsuficiente e) {
				throw e;
			} catch (GasInsuficiente e) {
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

}
