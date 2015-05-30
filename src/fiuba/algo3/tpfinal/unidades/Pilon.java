package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Pilon extends ConstruccionesProtoss {

	public Pilon() {
		unidadesHechas = unidadesHechas.concat("pilon");
		this.vida = 300;
		this.escudo = 300;
		this.tiempo = 5;
		this.costo = new Costo(100);
	}

}