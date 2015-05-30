package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PuertoEstelarTerranTest {

	private PuertoEstelarTerran puertoEstelar;

	@Before
	public void arrange(){
		this.puertoEstelar = new PuertoEstelarTerran();
	}

	@Test
	public void debeTener1300DeVida(){
		Assert.assertTrue(this.puertoEstelar.getVida() == 1300);
		
	}
	
	@Test
	public void debeTardar10TurnosEnCrearse(){
		Assert.assertTrue(this.puertoEstelar.getTiempo() == 10);
	}
	
	@Test
	public void debeCostar150MineralesY100DeGas(){
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 100);
	}

}

