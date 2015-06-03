package fiuba.algo3.tpfinal.unidades;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class PuertoEstelarProtoss extends ConstruccionesProtoss {
	
	public PuertoEstelarProtoss() {
		
		this.vida = 600;
		this.escudo = 600;
		this.tiempo = 10;
		this.costo = new Costo(150, 150);
		this.setConstruccionesNecesarias();
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Acceso());
	}

}
