package fiuba.algo3.tpfinal.vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LectorDeLetras implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent tecla) {
		char caracter = tecla.getKeyChar();

		if (!Character.isLetter(caracter)) {
			tecla.consume();

		}
	}

}
