package fiuba.algo3.tpfinal.modelo.programa;

import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;

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

	public void gastar(Costo costo) throws MineralInsuficiente, GasInsuficiente {
		if (this.cantidadDeMineral >= costo.getMinerales()) {
			if (this.cantidadDeGas >= costo.getGas()) {
				this.cantidadDeMineral -= costo.getMinerales();
				this.cantidadDeGas -= costo.getGas();
			} else {
				throw new GasInsuficiente();
			}
		} else {
			throw new MineralInsuficiente();
		}
	}

}
