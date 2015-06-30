package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoAtaque {

	public AudioClip clip;
	
	public SonidoAtaque(String url) throws MalformedURLException {

		URL urlClip = SonidoAtaque.class
				.getResource(url);
		clip = Applet.newAudioClip(urlClip);
		clip.play();
	}
}
