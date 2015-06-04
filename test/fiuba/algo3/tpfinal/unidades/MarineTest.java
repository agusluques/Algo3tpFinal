package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class MarineTest {

	@Test
	public void siSeCreaUnMarineDebeTener40DeVida(){
		Marine marine = new Marine();
		Assert.assertTrue(marine.getVida() == 40);
	}
	
	@Test
	public void siAUnMarineLePegan30DebeTener10(){
		Marine marine = new Marine();
		Danio danio = new Danio(0,30);
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
	
	@Test
	public void siUnMarineAtacaAOtroAlSegundoLeBajaLaVidaA36() {
		
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		unMarine.atacar(otroMarine);
		Assert.assertTrue(otroMarine.getVida() == 34);
	}

}
