package fiuba.algo3.tpfinal.vista.sonidos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SonidoTraslado {

	public AudioClip clip;
	
	public SonidoTraslado(String url) throws MalformedURLException {

		URL urlClip = SonidoTraslado.class
				.getResource(url);
		clip = Applet.newAudioClip(urlClip);
		clip.play();
	}
}