package fiuba.algo3.tpfinal.unidades;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class PuertoEstelarTerran extends ConstruccionesTerran {

	public PuertoEstelarTerran() {
		this.vida = 1300;
		this.tiempo = 10;
		this.costo = new Costo (150, 100);
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Fabrica());
	}
}
