package fiuba.algo3.tpfinal.modelo.construcciones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;
import fiuba.algo3.tpfinal.modelo.unidades.Fabricable;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;

public class PuertoEstelarProtoss extends ConstruccionProtoss {

	private ArrayList<Fabricable> unidadesEnConstruccion;
	private ArrayList<Constructible> construccionesNecesarias;

	public PuertoEstelarProtoss() {
		this.vida = new VidaConEscudo(600, 600);
		this.tiempoDeConstruccion = 10;
		this.costo = new Costo(150, 150);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
		this.unidadesEnConstruccion = new ArrayList<Fabricable>();
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Acceso());
	}

	public void fabricarScout() throws MineralInsuficiente, GasInsuficiente {
		this.fabricar(new Scout());
	}

	public void fabricarNaveDeTransporte() throws MineralInsuficiente, GasInsuficiente {
		this.fabricar(new NaveTransporteProtoss());
	}

	// TODO: ¿Respeta esta clase el principio de única responsabilidad?
	private void fabricar(Fabricable unidad) throws MineralInsuficiente, GasInsuficiente {
		if (unidadesEnConstruccion.size() < 6) {
				jugador.getPresupuesto().gastar(unidad.getCosto());
				unidadesEnConstruccion.add(unidad);
				jugador.notificarObservador();
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

	@Override
	public boolean puedeConstruirseEn(Parcela ubicacion) throws TerrenoInapropiado, ParcelaOcupada, ConstruccionRequeridaInexistente {
		return (this.esValidaLaUbicacion(ubicacion) && this
				.construccionesRequeridasEncontradas(this.construccionesNecesarias));
	}
}
