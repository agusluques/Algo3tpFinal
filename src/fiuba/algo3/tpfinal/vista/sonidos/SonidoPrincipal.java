package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoPrincipal {

	public AudioClip clip;
	public boolean activo;

	public SonidoPrincipal() throws MalformedURLException {

		URL urlClip = SonidoPrincipal.class
				.getResource("sonidoPantallaPrincipal.wav");
		clip = Applet.newAudioClip(urlClip);
		this.run();
	}

	public boolean estaActivo() {
		return activo;
	}

	public void parar() throws InterruptedException {
		clip.stop();
		activo = false;
	}

	public void run() {
		clip.loop();
		activo = true;

	}

}
