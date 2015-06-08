package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;

public abstract class Protoss implements Atacable{
	
	protected Escudo escudo = new Escudo();
	protected Vida vida = new Vida();
	protected Coordenada posicion;
	protected Jugador jugador;
	
	
	public int getVida() {
		return this.vida.getVida();
	}
	
	public int getEscudo() {
		return this.escudo.getEscudo();
	}
	
	public void atacado(Danio danio) {
		this.escudo.bajarEscudo(danio.getDanioTierra(), this.vida);
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
	
	@Override
	public boolean estaMuerto() {
		return ((this.vida.getVida() == 0) && (this.escudo.getEscudo() == 0));
	}

}
