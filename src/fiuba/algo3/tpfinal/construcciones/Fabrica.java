package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;

public class Fabrica extends ConstruccionesTerran {

	public Fabrica() {
		this.vida.inicializarVida(1250);
		this.tiempo = 12;
		this.costo = new Costo (200, 100);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Barraca());
	}
}
