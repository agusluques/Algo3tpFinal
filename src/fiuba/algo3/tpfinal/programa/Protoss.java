package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;

public abstract class Protoss implements Atacable, AfectablePorEMP {

	protected Escudo escudo = new Escudo();
	protected Vida vida = new Vida();
	protected Coordenada posicion;
	protected JugadorProtoss jugador;

	public int getVida() {
		return this.vida.getVida();
	}

	public int getEscudo() {
		return this.escudo.getEscudo();
	}

	public void atacado(Danio danio) {
		this.escudo.bajarEscudo(danio.getDanioTierra(), this.vida);
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
		return this.vida.getVida() == 0;
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.escudo.pasarTurno(jugador, mapa);
	}

	public void recibirImpactoEMP() {
		escudo.destruirEscudo();

	}
}
