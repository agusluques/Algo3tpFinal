package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.programa.Danio;

public class CentroDeMineralTest {

	private CentroDeMineral centroMineral;

	@Before
	public void arrange() {
		this.centroMineral = new CentroDeMineral();
	}

	@Test
	public void siSeCreaUnCentroDeMineralDeberiaTener500DeVida() {
		Assert.assertTrue(this.centroMineral.getVida() == 500);
	}

	@Test
	public void siSeCreaUnCentroDeMineralesSeDeberiaTener50MineralesMinimo() {
		Assert.assertTrue(this.centroMineral.getCostoMineral() == 50);
	}

	@Test
	public void elTiempoDeConstruccionDeberiaSer4Turnos() {
		Assert.assertTrue(this.centroMineral.getTiempo() == 4);
	}
	
	@Test
	public void siAtacanUnCentroCon100DeDanioLaVidaQuedaEn400() {
		Danio danio = new Danio(100);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(400, centroMineral.getVida());
	}
	
	@Test
	public void siAtacanUnCentroCon500DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(500);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(0, centroMineral.getVida());
	}
	
	@Test
	public void siAtacanUnCentroCon1000DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(1000);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(0, centroMineral.getVida());
	}
	
	@Test
	public void dosCentroDeMineralDeberianSerIguales() {
		Constructible otroCentro = new CentroDeMineral();
		Assert.assertTrue(this.centroMineral.equals(otroCentro));
	}

}
