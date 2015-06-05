package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Presupuesto;

public class CentroDeMineral extends ConstruccionesTerran implements RecolectorDeMinerales {

	public CentroDeMineral(Coordenada coordenada){
		this.vida.inicializarVida(500);
		this.costo = new Costo(50);
		this.tiempo = 4; 
		this.setConstruccionesNecesarias();
		this.posicion = coordenada;
	}
	
	@Override
	public void recolectarPara(Jugador jugador, Mapa mapa) {
		int mineralesRecolectados = recolectarMinerales(mapa);
		Presupuesto presupuestoJugador = jugador.getPresupuesto();
		presupuestoJugador.agregarMineral(mineralesRecolectados);
	}

	@Override
	public int recolectarMinerales(Mapa mapa) {
		Parcela parcela = mapa.getParcela(posicion);
		DepositoDeMinerales superficie = (DepositoDeMinerales) parcela.getSuperficie();
		return superficie.extraerRecursos();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}
	
}
