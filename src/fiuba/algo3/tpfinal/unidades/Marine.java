package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Marine extends UnidadesTerran {
	
	
	public Marine(){
		this.vida.inicializarVida(40);
		this.miDanio = new Danio(6,6);
		this.rango = new Rango(4,0);
		this.tiempoDeConstruccion = 3;
		this.suministro = 1;
		this.costo = new Costo(50);
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);
	
	}
}
