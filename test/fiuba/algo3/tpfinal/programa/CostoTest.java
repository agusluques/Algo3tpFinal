package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

public class CostoTest {

	@Test
	public void siAlgoCuesta20DeMineralesGetCostoMineralesDevuelve20() {
		Costo costo = new Costo(20, 0);
		Assert.assertEquals(20, costo.getMinerales());
	}

	@Test
	public void siAlgoCuesta20DeGasGetCostoGasDevuelve20() {
		Costo costo = new Costo(0, 20);
		Assert.assertEquals(20, costo.getGas());
	}
}
