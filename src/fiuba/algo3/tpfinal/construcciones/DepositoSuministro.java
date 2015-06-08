package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;

public class DepositoSuministro extends ConstruccionesTerran {
	
	public DepositoSuministro(){
		this.vida.inicializarVida(500);
		this.costo = new Costo(100);
		this.tiempoDeConstruccion = 6;
		this.superficieNecesaria = new Tierra();
		this.setConstruccionesNecesarias();
		
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

}
