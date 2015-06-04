package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Danio;

public abstract class Terran implements Atacable {

	protected int vida;
	
	public int getVida() {
		return this.vida;
	}
			
	public void atacado(Danio danio) {
		
		this.vida -= danio.getDanio();
		if (this.vida < 0) {
			this.vida = 0;
		}
	}

}
