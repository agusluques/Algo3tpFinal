package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

public class AireTest {
	
	@Test
	public void dosAiresSonIguales() {
		Aire aire = new Aire();
		Aire otroAire = new Aire();
		
		Assert.assertTrue(aire.equals(otroAire));
	}
	
	@Test
	public void dosAiresTienenElMismoHashCode() {
		Aire aire = new Aire();
		Aire otroAire = new Aire();
		
		int hash1 = aire.hashCode();
		int hash2 = otroAire.hashCode();
		
		Assert.assertEquals(hash1, hash2);
	}

}
