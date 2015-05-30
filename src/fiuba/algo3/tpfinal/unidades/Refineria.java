package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class Refineria extends ConstruccionesTerran implements RecolectorDeGas {

	public Refineria(){
		unidadesHechas = unidadesHechas.concat("refineria");
		this.vida = 750;
		this.tiempo = 6;
		this.costo = new Costo(100);
	}

	@Override
	public void recolectarPara(Jugador jugador) {
		jugador.recolectar(this);
		
	}

	@Override
	public int recolectarGas() {
		return 10;
	}
	
	
}
