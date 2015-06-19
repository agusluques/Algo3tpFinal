package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;

public abstract class Protoss implements Atacable, AfectablePorEMP {

	protected VidaConEscudo vida;
	protected Coordenada posicion;
	protected JugadorProtoss jugador;

	public int getVida() {
		return this.vida.getVida();
	}

	public int getEscudo() {
		return this.vida.getEscudo();
	}

	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioTierra());
	}

	public Coordenada getCoordenada() {
		return posicion;
	}

	public void setCoordenada(Coordenada posicion) {
		this.posicion = posicion;
	}

	public void setJugador(JugadorProtoss jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	@Override
	public boolean estaMuerto() {
		return this.vida.estaMuerto();
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.vida.pasarTurno();
	}

	public void recibirImpactoEMP() {
		vida.destruirEscudo();

	}
}
