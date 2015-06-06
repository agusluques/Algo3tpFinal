package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;

public class PuertoEstelarProtoss extends ConstruccionesProtoss {
	
	public PuertoEstelarProtoss() {
		
		this.vida.inicializarVida(600);
		this.escudo.inicializarEscudo(600);
		this.tiempo = 10;
		this.costo = new Costo(150, 150);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		this.construccionesNecesarias.add(new Acceso());
	}

}
