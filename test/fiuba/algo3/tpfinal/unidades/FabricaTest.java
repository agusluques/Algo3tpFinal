package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class FabricaTest {

	private Fabrica fabrica;

	@Before
	public void arrange(){
		this.fabrica = new Fabrica();
	}
	
	@Test
	public void debeTener1250DeVida(){
		Assert.assertTrue(this.fabrica.getVida() == 1250);
		
	}
	
	@Test
	public void debeTardar12TurnosEnCrearse(){
		Assert.assertTrue(this.fabrica.getTiempo() == 12);
	}
	
	@Test
	public void debeCostar200MineralesY100DeGas(){
		Assert.assertTrue(this.fabrica.getCostoMineral() == 200);
		Assert.assertTrue(this.fabrica.getCostoGas() == 100);
	}

}
