package fiuba.algo3.tpfinal.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.tpfinal.vista.sonidos.SonidoPrincipal;

public class AccionIniciarApagarSonido implements ActionListener {

	private SonidoPrincipal miSonido;

	public AccionIniciarApagarSonido(SonidoPrincipal sonido) {
		miSonido = sonido;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (miSonido.estaActivo()) {
			try {
				miSonido.parar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			miSonido.run();
		}

	}

}
