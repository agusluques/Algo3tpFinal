package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Presupuesto;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

public class Refineria extends ConstruccionTerran implements RecolectorDeGas {

	public Refineria() {
		this.vida = new VidaSimple(750);
		this.tiempoDeConstruccion = 6;
		this.costo = new Costo(100);
		this.superficieNecesaria = new DepositoDeGas();
	}

	@Override
	public void recolectar(Mapa mapa) {
		int gasRecolectado = recolectarGas(mapa);
		Presupuesto presupuestoJugador = this.jugador.getPresupuesto();
		presupuestoJugador.agregarGas(gasRecolectado);

	}

	@Override
	public int recolectarGas(Mapa mapa) {
		Parcela parcela = mapa.getParcela(this.posicion);
		DepositoDeGas superficie = (DepositoDeGas) parcela.getSuperficie();
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
