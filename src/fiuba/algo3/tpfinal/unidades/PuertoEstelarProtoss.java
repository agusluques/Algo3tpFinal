package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Costo;

public class PuertoEstelarProtoss extends ConstruccionesProtoss {
	
	public PuertoEstelarProtoss() throws ConstruccionRequeridaInexistente {
		
		if (!unidadesHechas.contains("acceso")) throw new ConstruccionRequeridaInexistente();
		unidadesHechas = unidadesHechas.concat("puertoEstelar");
		this.vida = 600;
		this.escudo = 600;
		this.tiempo = 10;
		this.costo = new Costo(150, 150);
	}


}
