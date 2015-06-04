package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;

public class DepositoSuministro extends ConstruccionesTerran {
	
	public DepositoSuministro(){
		this.vida.inicializarVida(500);
		this.costo = new Costo(100);
		this.tiempo = 6;
		this.setConstruccionesNecesarias();
		
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

}
