package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Costo;

public class PuertoEstelarTerran extends ConstruccionesTerran implements
		Constructible {

	public PuertoEstelarTerran() throws ConstruccionRequeridaInexistente{
		unidadesHechas = unidadesHechas.concat("puertoEstelar");
		if (!unidadesHechas.contains("fabrica")) throw new ConstruccionRequeridaInexistente();
		this.vida = 1300;
		this.tiempo = 10;
		this.costo = new Costo (150, 100);
	}
}
