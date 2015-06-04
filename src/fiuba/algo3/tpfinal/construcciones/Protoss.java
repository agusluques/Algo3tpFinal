package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Danio;

public abstract class Protoss implements Atacable{
	
	protected int escudo;
	protected int vida;
	
	public int getVida() {
		return this.vida;
	}
	
	public int getEscudo() {
		return this.escudo;
	}
	
	public void atacado(Danio danio) {
		if (danio.getDanio() <= this.escudo) {
			this.escudo -= danio.getDanio();
		} else {
			int danioAVida = danio.getDanio() - this.escudo;
			this.escudo = 0;
			this.vida -= danioAVida;
		}
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

}
