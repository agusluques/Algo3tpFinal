package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Presupuesto;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

public class CentroDeMineral extends ConstruccionTerran implements
		RecolectorDeMinerales {

	public CentroDeMineral() {
		this.vida = new VidaSimple(500);
		this.costo = new Costo(50);
		this.tiempoDeConstruccion = 4;
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

	public void pasarTurno() throws ParcelaOcupada {
		this.recolectar(jugador.getMapa());
		super.pasarTurno();
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

}