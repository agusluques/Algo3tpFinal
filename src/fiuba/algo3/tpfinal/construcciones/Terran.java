package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Danio;

public abstract class Terran implements Atacable {

	protected Vida vida = new Vida();
	
	public int getVida() {
		return this.vida.getVida();
	}
	
	
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioTierra());
	}
			
	
}
