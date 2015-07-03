package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.excepciones.EnergiaInsuficiente;

public class Energia {

	private int cantidadDeEnergia;

	public Energia(int cantidadInicial) {
		this.cantidadDeEnergia = cantidadInicial;
	}

	public int getEnergia() {
		return cantidadDeEnergia;
	}

	public void gastarEnergia(int cantidad) throws EnergiaInsuficiente {
		if (cantidad > cantidadDeEnergia) {
			throw new EnergiaInsuficiente();
		}
		this.cantidadDeEnergia -= cantidad;
	}

	public void aumentarEnergia(int cantidad) {
		this.cantidadDeEnergia += cantidad;
		if (cantidadDeEnergia > 200) {
			cantidadDeEnergia = 200;
		}
	}

}
