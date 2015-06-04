package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class GolliatTest {

	@Test
	public void siSeCreaUnMarineDebeTener125DeVida(){
		Golliat golliat = new Golliat();
		Assert.assertTrue(golliat.getVida() == 125);
	}
	
	@Test
	public void siAUnMarineLePegan100DebeTener25(){
		Golliat golliat = new Golliat();
		Danio danio = new Danio(100);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 25);
	}
	
	@Test
	public void siAUnMarineLePegan800DebeTener0(){
		Golliat golliat = new Golliat();
		Danio danio = new Danio(800);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 0);
	}

}
