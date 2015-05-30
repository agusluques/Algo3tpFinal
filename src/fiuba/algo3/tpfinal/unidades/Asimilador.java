package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class Asimilador extends ConstruccionesProtoss implements RecolectorDeGas{
	
	public Asimilador() {
		this.vida = 450;
		this.escudo = 450;
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
