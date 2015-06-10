package fiuba.algo3.tpfinal.construcciones;

import java.util.ArrayList;

import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Parcela;
import fiuba.algo3.tpfinal.programa.Presupuesto;
import fiuba.algo3.tpfinal.unidades.Rango;

public class Asimilador extends ConstruccionProtoss implements RecolectorDeGas{
	
	public Asimilador(Coordenada coord) {
		this.vida.inicializarVida(450);
		this.escudo.inicializarEscudo(450);
		this.tiempoDeConstruccion = 6;
		this.costo = new Costo(100);
		this.superficieNecesaria = new DepositoDeGas();
		this.setConstruccionesNecesarias();
		this.posicion = coord;
	}
	
	@Override
	public void recolectarPara(Jugador jugador, Mapa mapa) {
		int gasRecolectado = recolectarGas(mapa);
		Presupuesto presupuestoJugador = jugador.getPresupuesto();
		presupuestoJugador.agregarGas(gasRecolectado);
		
	}

	@Override
	public int recolectarGas(Mapa mapa) {
		Parcela parcela = mapa.getParcela(posicion);
		DepositoDeGas superficie = (DepositoDeGas) parcela.getSuperficie();
		return superficie.extraerRecursos();
	}
	
	private void setConstruccionesNecesarias() {
		this.construccionesNecesarias = new ArrayList<Constructible>();
		
	}
	
	public void pasarTurno(Jugador jugador, Mapa mapa) {
		this.recolectarPara(jugador, mapa);
		super.pasarTurno(jugador, mapa);
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}

}
