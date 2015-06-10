package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;

public abstract class Terran implements Atacable, AfectablePorEMP {

	protected Vida vida = new Vida();
	protected Coordenada posicion;
	protected Jugador jugador;
	
	public int getVida() {
		return this.vida.getVida();
	}
	
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioTierra());
	}
	
	public Coordenada getCoordenada(){
		return posicion;
	}
	
	public void setCoordenada(Coordenada posicion){
		this.posicion = posicion;
	}
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	public Jugador getJugador(){
		return this.jugador;
	}
	@Override
	public boolean estaMuerto() {
		return (this.vida.getVida() == 0);
	}
	
	public void pasarTurno(Jugador jugador, Mapa mapa) {
	}
	
	public void recibirImpactoEMP(){};
			
	
}
