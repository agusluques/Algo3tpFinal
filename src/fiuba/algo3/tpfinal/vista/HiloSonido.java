package fiuba.algo3.tpfinal.vista;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class HiloSonido  {

	public AudioClip clip;
	public boolean activo;

	public HiloSonido(String rutaArchivo) throws MalformedURLException {
		
		URL urlClip = HiloSonido.class.getResource("sonidoPantallaPRincipal.wav");
	    clip = Applet.newAudioClip(urlClip);
	    clip.play();
		activo = true;
	}

	public boolean estaActivo() {
		return activo;
	}

	public void parar() throws InterruptedException {
		clip.stop();
		activo = false;
	}

	public void run() {
		clip.play();
		activo =true;
		
	}
	
	
}
	