package fiuba.algo3.tpfinal.vista;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class HiloSonido extends Thread {

	private Clip sonido;
	private boolean seguir;

	public HiloSonido(String rutaArchivo) throws LineUnavailableException,
			IOException, UnsupportedAudioFileException {

		seguir = true;
		sonido = AudioSystem.getClip();
		sonido.open(AudioSystem.getAudioInputStream(new File(rutaArchivo)));

	}

	@Override
	public void run() {

		sonido.start();

		// Espera mientras se este reproduciendo.
		do {
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				/*
				 * Logger.getLogger(ReproduceSonido.class.getName()).log(
				 * Level.SEVERE, null, ex);
				 */
			}

		} while (seguir && sonido.isActive());

		if (sonido.isActive()) {
			sonido.stop();
		}

		// Se cierra el clip.
		sonido.close();

	}

	public void parar() {
		seguir = false;
	}

	public boolean estaActivo() {
		return sonido.isActive();
	}
}
