package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Presupuesto;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class Asimilador extends ConstruccionProtoss implements RecolectorDeGas {

	public Asimilador() {
		this.vida.inicializarVida(450);
		this.escudo.inicializarEscudo(450);
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


	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.recolectar(mapa);
		super.pasarTurno(jugador, mapa);
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

}
