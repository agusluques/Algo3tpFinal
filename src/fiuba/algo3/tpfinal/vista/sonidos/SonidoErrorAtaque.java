package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoErrorAtaque {
	public AudioClip clip;
	
	public SonidoErrorAtaque() throws MalformedURLException {

		URL urlClip = SonidoErrorAtaque.class
				.getResource("sonidoErrorAtaque.wav");
		clip = Applet.newAudioClip(urlClip);
		clip.play();
	}
}
