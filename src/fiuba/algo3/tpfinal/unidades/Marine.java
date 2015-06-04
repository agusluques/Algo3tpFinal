package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Marine extends UnidadesTerran{
	
	public Marine(){
		this.vida.inicializarVida(40);
		this.miDanio = new Danio(6,6);
	}
}
