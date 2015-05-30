package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class DepositoSuministro extends ConstruccionesTerran implements Constructible{
	
	public DepositoSuministro(){
		unidadesHechas = unidadesHechas.concat("depositoDeSuministros");
		this.vida = 500;
		this.costo = new Costo(100);
		this.tiempo = 6;
		
		
	}

}
