package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Fabricable;
import fiuba.algo3.tpfinal.unidades.Rango;
import fiuba.algo3.tpfinal.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class Acceso extends ConstruccionProtoss {

	private Fabricable unidadEnConstruccion;

	public Acceso() {
		this.vida.inicializarVida(500);
		this.escudo.inicializarEscudo(500);
		this.tiempoDeConstruccion = 8;
		this.costo = new Costo(150);
		this.superficieNecesaria = new Tierra();

	}


	public void fabricarZealot() {
		this.fabricar(new Zealot());
	}

	public void fabricarDragon() {
		this.fabricar(new Dragon());
	}

	private void fabricar(Fabricable unidad) {
		try {
			jugador.getPresupuesto().removerMineral(unidad.getCostoMineral());
			jugador.getPresupuesto().removerGas(unidad.getCostoGas());
			unidadEnConstruccion = unidad;
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		if (unidadEnConstruccion != null) {
			unidadEnConstruccion.avanzarFabricacion();
			if (this.unidadEnConstruccion.getTiempoRestante() == 0) {
				try {
					this.jugador.agregarUnidad((UnidadProtoss)unidadEnConstruccion,
							this.posicion);
					this.unidadEnConstruccion = null;
				} catch (LimitePoblacionalAlcanzado e) {
					throw e;
				}
			}
		}
	}

	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}

	

}
