package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Rango;

public class Pilon extends ConstruccionesProtoss {

	public Pilon() {
		this.vida.inicializarVida(300);
		this.escudo.inicializarEscudo(300);
		this.tiempoDeConstruccion = 5;
		this.costo = new Costo(100);
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}

}
