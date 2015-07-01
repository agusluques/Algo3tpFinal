package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoGanador {
	public AudioClip clip;
	
	public SonidoGanador() throws MalformedURLException {

		URL urlClip = SonidoGanador.class
				.getResource("sonidoGanador.wav");
		clip = Applet.newAudioClip(urlClip);
		clip.play();
	}
}