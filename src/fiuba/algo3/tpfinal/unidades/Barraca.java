package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Barraca extends ConstruccionesTerran implements Constructible{

	public Barraca(){
		this.vida = 1000;
		this.costo = new Costo(150);
		this.tiempo = 12;
	}
	

}
