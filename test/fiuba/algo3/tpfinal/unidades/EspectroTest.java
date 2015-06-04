package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class EspectroTest {

	@Test
	public void siSeCreaUnEspectroDebeTener120DeVida(){
		Espectro espectro = new Espectro();
		Assert.assertTrue(espectro.getVida() == 120);
	}
	
	@Test
	public void siAUnEspectroLePegan100DebeTener20(){
		Espectro espectro = new Espectro();
		Danio danio = new Danio(100,0);
		espectro.atacado(danio);
		Assert.assertTrue(espectro.getVida() == 20);
	}
	
	@Test
	public void siAUnEspectroLePegan800DebeTener0(){
		Espectro espectro = new Espectro();
		Danio danio = new Danio(800,0);
		espectro.atacado(danio);
		Assert.assertTrue(espectro.getVida() == 0);
	}

}
