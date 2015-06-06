package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;

public class PuertoEstelarTerran extends ConstruccionesTerran {

	public PuertoEstelarTerran() {
		this.vida.inicializarVida(1300);
		this.tiempo = 10;
		this.costo = new Costo (150, 100);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Fabrica());
	}
}
