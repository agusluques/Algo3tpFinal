package fiuba.algo3.tpfinal.vista;

import javax.swing.JInternalFrame;

public interface Observador {

	void actualizar();

	void imprimirMenuObservador();

	void setObservable(Observable observable);

	void setVentanaDeAccion(JInternalFrame ventana);

	void ocultarMenuObservador();
}
