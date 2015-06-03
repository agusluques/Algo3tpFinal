package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Constructible;

public class Arquitecto {
	
	public Arquitecto() {
	}

	public void construir(Jugador jugador, Constructible construccion) {
		try {
			int costoConstruccionMineral = construccion.getCostoMineral();
			int costoConstruccionGas = construccion.getCostoGas();
			jugador.gastarMineral(costoConstruccionMineral);
			jugador.gastarGas(costoConstruccionGas);
			jugador.agregarConstruccion(construccion);
		} catch (MineralInsuficiente e) {
			throw e;
		} catch (GasInsuficiente e) {
			throw e;
		}
		
	}
	

}
