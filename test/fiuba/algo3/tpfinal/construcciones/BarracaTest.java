package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.unidades.Barraca;
import fiuba.algo3.tpfinal.unidades.Constructible;

public class BarracaTest {

	private Barraca barraca;

	@Before
	public void arrange() {
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
	
	@Test
	public void dosBarracasDeberianSerIguales() {
		Constructible otraBarraca = new Barraca();
		Assert.assertTrue(this.barraca.equals(otraBarraca));
	}

}
