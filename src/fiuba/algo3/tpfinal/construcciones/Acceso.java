package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;

public class Acceso extends ConstruccionesProtoss {
	
	public Acceso() {
		this.vida.inicializarVida(500);
		this.escudo.inicializarEscudo(500);
		this.tiempo = 8;
		this.costo = new Costo(150);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
		
	}

	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
	}
	
	

}
