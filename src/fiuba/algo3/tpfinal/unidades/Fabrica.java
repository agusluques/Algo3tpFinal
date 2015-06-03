package fiuba.algo3.tpfinal.unidades;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class Fabrica extends ConstruccionesTerran {

	public Fabrica() {
		this.vida = 1250;
		this.tiempo = 12;
		this.costo = new Costo (200, 100);
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Barraca());
	}
}
