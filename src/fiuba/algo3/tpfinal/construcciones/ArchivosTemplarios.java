package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class ArchivosTemplarios extends ConstruccionesProtoss {
	
	public ArchivosTemplarios() {
		this.vida = 500;
		this.escudo = 500;
		this.tiempo = 9;
		this.costo = new Costo(150, 200);
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new PuertoEstelarProtoss());
	}

}
