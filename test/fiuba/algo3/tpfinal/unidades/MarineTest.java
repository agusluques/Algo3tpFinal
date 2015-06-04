package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

public class MarineTest {

	@Test
	public void siSeCreaUnMarineDebeTener50DeVida(){
		Marine marine = new Marine();
		Assert.assertTrue(marine.getVida() == 50);
	}

}
