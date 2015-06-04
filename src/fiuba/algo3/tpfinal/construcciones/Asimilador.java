package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Jugador;

public class Asimilador extends ConstruccionesProtoss implements RecolectorDeGas{
	
	public Asimilador() {
		this.vida.inicializarVida(450);
		this.escudo.inicializarEscudo(450);
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
