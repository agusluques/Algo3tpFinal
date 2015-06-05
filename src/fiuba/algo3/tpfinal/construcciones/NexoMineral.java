package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Presupuesto;

public class NexoMineral extends ConstruccionesProtoss implements RecolectorDeMinerales{

	
	public NexoMineral(Coordenada coord) {
		this.vida.inicializarVida(250);
		this.escudo.inicializarEscudo(250);
		this.tiempo = 4;
		this.costo = new Costo(50);
		this.setConstruccionesNecesarias();
		this.posicion = coord;
	}

	@Override
	public void recolectarPara(Jugador jugador, Mapa mapa) {
		int mineralesRecolectados = recolectarMinerales(mapa);
		Presupuesto presupuestoJugador = jugador.getPresupuesto();
		presupuestoJugador.agregarMineral(mineralesRecolectados);
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}

	@Override
	public int recolectarMinerales(Mapa mapa) {
		Parcela parcela = mapa.getParcela(posicion);
		DepositoDeMinerales superficie = (DepositoDeMinerales) parcela.getSuperficie();
		return superficie.extraerRecursos();
	}

	
	
	
	

}
