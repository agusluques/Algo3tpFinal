package fiuba.algo3.tpfinal.unidades;

public abstract class Protoss implements Atacable{
	
	protected int escudo;
	protected int vida;
	
	public int getVida() {
		return this.vida;
	}
	
	public int getEscudo() {
		return this.escudo;
	}
	
	public void atacado(int danio) {
		if (danio <= this.escudo) {
			this.escudo -= danio;
		} else {
			int danioAVida = danio - this.escudo;
			this.escudo = 0;
			this.vida -= danioAVida;
		}
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

}
