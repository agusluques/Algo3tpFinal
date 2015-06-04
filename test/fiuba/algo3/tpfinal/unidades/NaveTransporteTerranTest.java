package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteTerranTest {

	@Test
	public void siSeCreaUnaNaveTansporteTerranDebeTener150DeVida(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Assert.assertTrue(nave.getVida() == 150);
	}
	
	@Test
	public void siAUnaNaveTansporteTerranLePegan100DebeTener50(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(100,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 50);
	}
	
	@Test
	public void siAUnaNaveTansporteTerranLePegan800DebeTener0(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(800,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 0);
	}

}
