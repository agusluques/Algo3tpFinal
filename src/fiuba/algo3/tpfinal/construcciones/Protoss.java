package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public abstract class Protoss implements Atacable{
	
	protected Escudo escudo = new Escudo();
	protected Vida vida = new Vida();
	protected Coordenada posicion;
	
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

}
