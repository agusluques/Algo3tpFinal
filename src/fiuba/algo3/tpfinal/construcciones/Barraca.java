package fiuba.algo3.tpfinal.construcciones;

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

	private Fabricable unidadEnConstruccion;

	public Barraca() {
		this.vida.inicializarVida(1000);
		this.costo = new Costo(150);
		this.tiempoDeConstruccion = 12;
		this.superficieNecesaria = new Tierra();
	
	}

	public void fabricarMarine() {
		try {
			jugador.getPresupuesto().gastar(new Marine().getCosto());
			//TODO : ¿Cómo van a hacer para encolar la construcción de 3 Marines ?
			unidadEnConstruccion = new Marine();
		} catch (MineralInsuficiente e) {
			throw e;
		}
	}

	
	public void pasarTurno(Jugador jugador, Mapa mapa) {
		if (unidadEnConstruccion != null) {
			unidadEnConstruccion.avanzarFabricacion();
			if (this.unidadEnConstruccion.getTiempoRestante() == 0) {
				try {
					this.jugador.agregarUnidad((UnidadTerran)unidadEnConstruccion,
							this.posicion);
					this.unidadEnConstruccion = null;
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
