package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Golliat extends UnidadesTerran {
	
	public Golliat(){
		this.vida.inicializarVida(125);
		this.miDanio = new Danio(10,12);
	}
}
