package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public class Golliat extends UnidadesTerran {
	
	public Golliat(){
		this.vida.inicializarVida(125);
		this.miDanio = new Danio(10,12);
		this.rango = new Rango(5,6);
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);
	}
}
