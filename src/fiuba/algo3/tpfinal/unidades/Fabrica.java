package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Fabrica extends ConstruccionesTerran implements Constructible {

	public Fabrica(){
		this.vida = 1250;
		this.tiempo = 12;
		this.costo = new Costo (200, 100);
		
	}
}
