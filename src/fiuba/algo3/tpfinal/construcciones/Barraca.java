package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class Barraca extends ConstruccionesTerran {

	public Barraca(){
		this.vida.inicializarVida(1000);
		this.costo = new Costo(150);
		this.tiempo = 12;
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

}
