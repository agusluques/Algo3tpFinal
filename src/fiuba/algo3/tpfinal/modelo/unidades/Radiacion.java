package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.Jugador;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;

public class Radiacion extends Magia {

	protected Atacable afectado;
	protected Mapa mapa;
	protected Jugador jugador;

	public Radiacion(Atacable afectado) {
		this.afectado = afectado;
		this.jugador = afectado.getJugador();
		this.mapa = afectado.getJugador().getMapa();

	}

	public boolean estaMuerto() {
		return this.afectado.estaMuerto();
	}

	public void pasarTurno() {
		if (!estaMuerto()) {
			for (Atacable unidadActual : mapa.unidadesEnUnRadio(
					afectado.getCoordenada(), 1)) {
				if (afectado.getJugador().equals(unidadActual.getJugador())) {
					unidadActual.atacado(new Danio(30, 30));
				}
			}
		}
	}
}
