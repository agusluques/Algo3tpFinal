package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DepositoSuministroTest {

	private DepositoSuministro depositoSuministro;

	@Before
	public void arrange(){
		this.depositoSuministro = new DepositoSuministro();
	}
	
	@Test
	public void debeTenerVidaIgualA500(){
		Assert.assertTrue (this.depositoSuministro.getVida() == 500);
	}
	
	@Test
	public void debeTardar6TurnosEnCrearse(){
		Assert.assertTrue(this.depositoSuministro.getTiempo() == 6);
	}
	
	@Test
	public void debeCostar100Minerales(){
		Assert.assertTrue(this.depositoSuministro.getCostoMineral() == 100);
	}

}