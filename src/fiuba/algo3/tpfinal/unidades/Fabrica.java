package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Costo;

public class Fabrica extends ConstruccionesTerran implements Constructible {

	public Fabrica() throws ConstruccionRequeridaInexistente {
		System.out.println(unidadesHechas);
		
		if (!unidadesHechas.contains("barraca")) throw new ConstruccionRequeridaInexistente();
		unidadesHechas = unidadesHechas.concat("fabrica");
		this.vida = 1250;
		this.tiempo = 12;
		this.costo = new Costo (200, 100);
		
	}
}
