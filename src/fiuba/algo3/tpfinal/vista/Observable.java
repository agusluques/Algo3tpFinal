package fiuba.algo3.tpfinal.vista;

public class Observable {

	protected Observador miObservador;
	protected boolean seleccionado = false;

	public void agregarObservador(Observador observador) {
		this.miObservador = observador;
	}

	public void notificarObservador() {
		try {
			miObservador.actualizar();
		} catch (NullPointerException e) {
		}
		;
	}

	public void notificarObservadorSobreSeleccion() {
		if (seleccionado) {
			try {
				miObservador.ocultarMenuObservador();
				seleccionado = false;
			} catch (NullPointerException e) {
			}
			;
		} else {
			try {
				miObservador.imprimirMenuObservador();
				seleccionado = true;
			} catch (NullPointerException e) {
			}
			;
		}

	}
}
