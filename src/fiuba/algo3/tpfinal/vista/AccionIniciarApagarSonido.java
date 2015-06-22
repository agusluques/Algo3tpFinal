package fiuba.algo3.tpfinal.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionIniciarApagarSonido implements ActionListener {

	private HiloSonido miSonido;

	public AccionIniciarApagarSonido(HiloSonido sonido) {
		miSonido = sonido;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (miSonido.estaActivo()) {
			miSonido.parar();
		} else {
			System.out.println("Inicia");
			miSonido.run();
		}

	}

}
