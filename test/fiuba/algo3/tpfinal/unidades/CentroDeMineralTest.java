package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.unidades.CentroDeMineral;

public class CentroDeMineralTest {

	private CentroDeMineral centroMineral;
	
	@Before
	public void arrange(){
		this.centroMineral = new CentroDeMineral();
	}
	
	@Test
	public void siSeCreaUnCentroDeMineralDeberiaTener500DeVida() {
		Assert.assertTrue(this.centroMineral.getVida() == 500);
	}
	
	@Test
	public void siSeCreaUnCentroDeMineralesSeDeberiaTener50MineralesMinimo(){
		Assert.assertTrue(this.centroMineral.getCostoMineral() == 50);
	}
	
	@Test
	public void elTiempoDeConstruccionDeberiaSer4Turnos(){
		Assert.assertTrue(this.centroMineral.getTiempo() == 4);
	}

}
