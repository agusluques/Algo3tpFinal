package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.UnidadInvalida;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;

public class NaveCiencia extends UnidadTerran {

	protected Energia miEnergia = new Energia(50);

	public NaveCiencia() {
		this.vida = new VidaSimple(200);
		this.miDanio = new Danio(0, 0);
		this.rangoDeAtaque = new RangoDeAtaque(10, 10);
		this.tiempoDeConstruccion = 10;
		this.suministro = 2;
		this.costo = new Costo(100, 225);
		this.transporte = 9;

	}

	@Override
	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioAire());
		this.notificarObservador();
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoAire();
	}

	public void pasarTurno() {
		this.miEnergia.aumentarEnergia(10);
	}

	public void irradiar(Atacable unidad) throws UnidadInvalida,
			EnergiaInsuficiente {
		if (unidad.getJugador().equals(this.jugador)) {
			throw new UnidadInvalida();
		} else {
			if (this.estaEnRangoDeAtaque(unidad)) {
				try {
					this.miEnergia.gastarEnergia(75);
					this.notificarObservador();
					Radiacion radiacion = new Radiacion(unidad);
					this.jugador.agregarMagia(radiacion);
				} catch (EnergiaInsuficiente e) {
					throw e;
				}

			}
		}
	}

	// ojo
	public int getEnergia() {
		return this.miEnergia.getEnergia();
	}

	public void lanzarEMP(Coordenada posicion) throws EnergiaInsuficiente {
		if (this.posicion.distancia(posicion) <= this.rangoDeAtaque
				.getRangoAire()) {
			try {
				this.miEnergia.gastarEnergia(100);
				this.notificarObservador();
				for (Atacable unidadActual : this.getJugador().getMapa()
						.unidadesEnUnRadio(posicion, 1)) {
					if (!this.jugador.equals(unidadActual.getJugador())) {
						((AfectablePorEMP) unidadActual).recibirImpactoEMP();
					}
				}
			} catch (EnergiaInsuficiente e) {
				throw e;
			}
		}

	}

	@Override
	public void recibirImpactoEMP() {
		this.miEnergia = new Energia(0);
		this.notificarObservador();
	}
}
