package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.AfectablePorEMP;

public abstract class Terran implements Atacable, AfectablePorEMP {

	protected Vida vida = new Vida();
	protected Coordenada posicion;
	protected Jugador jugador;
	
	public void recibirImpactoEMP(){};
	
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

			
	
}
