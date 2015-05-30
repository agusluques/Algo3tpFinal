package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Refineria extends ConstruccionesTerran implements Constructible {

	public Refineria(){
		this.vida = 750;
		this.tiempo = 6;
		this.costo = new Costo(100);
	}
}
