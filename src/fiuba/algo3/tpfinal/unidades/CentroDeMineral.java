package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class CentroDeMineral extends ConstruccionesTerran implements Constructible {

	public CentroDeMineral(){
		this.vida = 500;
		this.costo = new Costo(50);
		this.tiempo = 4; 
	}
	
	
}
