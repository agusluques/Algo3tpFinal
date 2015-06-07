package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Espectro extends UnidadesTerran {

	public Espectro(){
		this.vida.inicializarVida(120);
		this.miDanio = new Danio (20,8);
		this.rango = new Rango(5,0);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(150,100);
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);
	}
	
	@Override
	public void atacado (Danio danio){
		this.vida.bajarVida(danio.getDanioAire());
	}
}
