package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class MarineTest {

	@Test
	public void siSeCreaUnMarineDebeTener50DeVida(){
		Marine marine = new Marine();
		Assert.assertTrue(marine.getVida() == 50);
	}
	
	@Test
	public void siAUnMarineLePegan40DebeTener10(){
		Marine marine = new Marine();
		Danio danio = new Danio(0,40);
		marine.atacado(danio);
		Assert.assertTrue(marine.getVida() == 10);
	}
	
	@Test
	public void siAUnMarineLePegan60DebeTener0(){
		Marine marine = new Marine();
		Danio danio = new Danio(0,60);
		marine.atacado(danio);
		Assert.assertTrue(marine.getVida() == 0);
	}

}
