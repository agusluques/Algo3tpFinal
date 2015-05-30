package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Costo;

public class ArchivosTemplarios extends ConstruccionesProtoss {
	
	public ArchivosTemplarios() throws ConstruccionRequeridaInexistente {
		unidadesHechas = unidadesHechas.concat("archivosTemplarios");
		if (!unidadesHechas.contains("puertoEstelar")) throw new ConstruccionRequeridaInexistente();
		this.vida = 500;
		this.escudo = 500;
		this.tiempo = 9;
		this.costo = new Costo(150, 200);
	}

}
