package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public class NaveCiencia extends UnidadesTerran {

	public NaveCiencia(){
		this.vida.inicializarVida(200);
		this.miDanio = new Danio(0,0);
		this.rango = new Rango(0,0);
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);
	}
	
	@Override
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
}
