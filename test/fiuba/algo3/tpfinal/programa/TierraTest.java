package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

public class TierraTest {
	
	@Test
	public void dosTierrasSonIguales() {
		Tierra tierra = new Tierra();
		Tierra otraTierra = new Tierra();
		
		Assert.assertTrue(tierra.equals(otraTierra));
	}
	
	@Test
	public void dosTierrasTienenElMismoHashCode() {
		Tierra tierra = new Tierra();
		Tierra otraTierra = new Tierra();
		
		Assert.assertEquals(tierra.hashCode(), otraTierra.hashCode());
	}

}
