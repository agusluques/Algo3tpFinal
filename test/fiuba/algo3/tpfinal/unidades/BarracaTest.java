package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class BarracaTest {

	private Barraca barraca;

	@Before
	public void arrange(){
		this.barraca = new Barraca();
	}
	
	@Test
	public void unaBarracaDebeTener1000DeVida() {
		Assert.assertTrue(this.barraca.getVida() == 1000);
	}
	
	@Test
	public void unaBarracaDebeCostar150Minerales() {
		Assert.assertTrue(this.barraca.getCostoMineral() == 150);
	}
	
	@Test
	public void unaBarracaDebeCrearseEn12Turnos() {
		Assert.assertTrue(this.barraca.getTiempo() == 12);
	}

}
