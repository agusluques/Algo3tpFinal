package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Espectro extends UnidadesTerran {

	public Espectro(){
		this.vida.inicializarVida(120);
	}
	
	@Override
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
}
