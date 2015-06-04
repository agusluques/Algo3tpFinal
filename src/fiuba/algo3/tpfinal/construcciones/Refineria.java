package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class Refineria extends ConstruccionesTerran implements RecolectorDeGas {

	public Refineria(){
		this.vida.inicializarVida(750);
		this.tiempo = 6;
		this.costo = new Costo(100);
		this.setConstruccionesNecesarias();
	}

	@Override
	public void recolectarPara(Jugador jugador) {
		jugador.recolectar(this);
		
	}

	@Override
	public int recolectarGas() {
		return 10;
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}
	
	
}
