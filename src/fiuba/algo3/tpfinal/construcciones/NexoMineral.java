package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Presupuesto;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class NexoMineral extends ConstruccionProtoss implements
		RecolectorDeMinerales {

	public NexoMineral() {
		this.vida.inicializarVida(250);
		this.escudo.inicializarEscudo(250);
		this.tiempoDeConstruccion = 4;
		this.costo = new Costo(50);
		this.superficieNecesaria = new DepositoDeMinerales();
	}

	@Override
	public void recolectar(Mapa mapa) {
		int mineralesRecolectados = recolectarMinerales(mapa);
		Presupuesto presupuestoJugador = this.jugador.getPresupuesto();
		presupuestoJugador.agregarMineral(mineralesRecolectados);
	}

	@Override
	public int recolectarMinerales(Mapa mapa) {
		Parcela parcela = mapa.getParcela(this.posicion);
		DepositoDeMinerales superficie = (DepositoDeMinerales) parcela
				.getSuperficie();
		return superficie.extraerRecursos();
	}

	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.recolectar(mapa);
		super.pasarTurno(jugador, mapa);
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

}
