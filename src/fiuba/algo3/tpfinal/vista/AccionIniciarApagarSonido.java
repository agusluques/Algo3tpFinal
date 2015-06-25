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
			try {
				miSonido.parar();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		} else {
			System.out.println("Inicia");
			miSonido.run();
		}

	}

}
