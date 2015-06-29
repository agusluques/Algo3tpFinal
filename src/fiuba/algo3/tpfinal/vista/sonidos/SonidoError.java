package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoError {
	public AudioClip clip;
	
	public SonidoError() throws MalformedURLException {

		URL urlClip = SonidoError.class
				.getResource("sonidoError.wav");
		clip = Applet.newAudioClip(urlClip);
		clip.play();
	}
}
