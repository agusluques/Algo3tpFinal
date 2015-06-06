package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteTerran extends UnidadesTerran {

	public NaveTransporteTerran(){
		this.vida.inicializarVida(150);
		this.miDanio = new Danio(0,0);
		this.rango = new Rango(0,0);
		this.tiempoDeConstruccion = 3;
		this.suministro = 1;
		
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);
	}
	
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
}
