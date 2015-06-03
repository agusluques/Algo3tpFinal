package fiuba.algo3.tpfinal.programa;

import org.junit.Test;

import junit.framework.Assert;

public class CostoTest {
	
	@Test
	public void siAlgoCuesta20DeMineralesGetCostoMineralesDevuelve20() {
		Costo costo = new Costo(20,0);
		Assert.assertEquals(20, costo.getMinerales());
	}
	
	@Test
	public void siAlgoCuesta20DeGasGetCostoGasDevuelve20() {
		Costo costo = new Costo(0,20);
		Assert.assertEquals(20, costo.getGas());
	}
}
