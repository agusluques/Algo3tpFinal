package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteTerran extends UnidadesTerran {

	public NaveTransporteTerran(){
		this.vida.inicializarVida(150);
		this.miDanio = new Danio(0,0);
	}
	
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
}
