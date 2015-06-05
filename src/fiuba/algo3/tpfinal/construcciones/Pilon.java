package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class Pilon extends ConstruccionesProtoss {

	public Pilon() {
		this.vida.inicializarVida(300);
		this.escudo.inicializarEscudo(300);
		this.tiempo = 5;
		this.costo = new Costo(100);
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

}