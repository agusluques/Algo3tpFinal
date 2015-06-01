package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class CentroDeMineral extends ConstruccionesTerran implements RecolectorDeMinerales {

	public CentroDeMineral(){
		this.vida = 500;
		this.costo = new Costo(50);
		this.tiempo = 4; 
	}
	
	@Override
	public void recolectarPara(Jugador jugador) {
		jugador.recolectar(this);
		
	}

	@Override
	public int recolectarMinerales() {
		return 10;
	}
	
}
