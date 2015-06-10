package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;

public class Presupuesto {

	private int cantidadDeGas;
	private int cantidadDeMineral;

	public Presupuesto(int mineral, int gas) {
		this.cantidadDeGas = gas;
		this.cantidadDeMineral = mineral;
	}

	public int cantidadDeGas() {
		return this.cantidadDeGas;
	}

	public int cantidadDeMineral() {
		return this.cantidadDeMineral;
	}

	public void agregarMineral(int cantidad) {
		this.cantidadDeMineral += cantidad;
	}

	public void agregarGas(int cantidad) {
		this.cantidadDeGas += cantidad;
	}

	public void removerMineral(int cantidad) throws MineralInsuficiente {
		if (this.cantidadDeMineral < cantidad) {
			throw new MineralInsuficiente();
		}
		this.cantidadDeMineral -= cantidad;
	}

	public void removerGas(int cantidad) throws GasInsuficiente {
		if (this.cantidadDeGas < cantidad) {
			throw new GasInsuficiente();
		}
		this.cantidadDeGas -= cantidad;
	}

}
