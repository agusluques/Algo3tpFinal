package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;
import fiuba.algo3.tpfinal.vista.Observable;

public abstract class Terran extends Observable implements Atacable,
		AfectablePorEMP {

	protected Vida vida;
	protected Coordenada posicion;
	protected JugadorTerran jugador;

	public int getVida() {
		return this.vida.getCantidadDeVida();
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
		return (this.vida.getCantidadDeVida() == 0);
	}

	public void pasarTurno() throws ParcelaOcupada {
	}

	public void recibirImpactoEMP() {
	};

}
