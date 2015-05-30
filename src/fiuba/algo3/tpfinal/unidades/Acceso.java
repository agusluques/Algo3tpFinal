package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;

public class Acceso extends ConstruccionesProtoss {
	
	public Acceso() {
		unidadesHechas = unidadesHechas.concat("acceso");
		this.vida = 500;
		this.escudo = 500;
		this.tiempo = 8;
		this.costo = new Costo(150);
	}

}
