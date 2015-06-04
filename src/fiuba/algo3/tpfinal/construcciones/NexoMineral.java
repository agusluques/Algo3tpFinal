package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class NexoMineral extends ConstruccionesProtoss implements RecolectorDeMinerales{

	
	public NexoMineral() {
		this.vida.inicializarVida(250);
		this.escudo.inicializarEscudo(250);
		this.tiempo = 4;
		this.costo = new Costo(50);
		this.setConstruccionesNecesarias();
	}

	@Override
	public void recolectarPara(Jugador jugador) {
		jugador.recolectar(this);
		
	}

	@Override
	public int recolectarMinerales() {
		return 10;
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

	
	
	
	

}
