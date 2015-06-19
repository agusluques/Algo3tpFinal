package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;

public abstract class Terran implements Atacable, AfectablePorEMP {

	protected VidaSimple vida;
	protected Coordenada posicion;
	protected JugadorTerran jugador;

	public int getVida() {
		return this.vida.getVida();
	}

	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioTierra());
	}

	public Coordenada getCoordenada() {
		return posicion;
	}

	public void setCoordenada(Coordenada posicion) {
		this.posicion = new Coordenada(posicion.getFila(),
				posicion.getColumna());
	}

	public void setJugador(JugadorTerran jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	@Override
	public boolean estaMuerto() {
		return (this.vida.getVida() == 0);
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
	}

	public void recibirImpactoEMP() {
	};

}
