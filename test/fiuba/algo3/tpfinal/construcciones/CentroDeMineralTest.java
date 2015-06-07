package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Parcela;

public class CentroDeMineralTest {

	private CentroDeMineral centroMineral;
	private Mapa ambiente;

	@Before
	public void arrange() throws Exception {
		this.ambiente = new Mapa("mapaTierra.txt");
		this.centroMineral = new CentroDeMineral(new Coordenada(1,91));
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
		Assert.assertTrue(this.centroMineral.getTiempoRestante() == 4);
	}
	
	@Test
	public void siAtacanUnCentroCon100DeDanioLaVidaQuedaEn400() {
		Danio danio = new Danio(0,100);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(400, centroMineral.getVida());
	}
	
	@Test
	public void siAtacanUnCentroCon500DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(0,500);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(0, centroMineral.getVida());
	}
	
	@Test
	public void siAtacanUnCentroCon1000DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(0,1000);
		centroMineral.atacado(danio);
		
		Assert.assertEquals(0, centroMineral.getVida());
	}
	
	@Test
	public void dosCentroDeMineralDeberianSerIguales() {
		Constructible otroCentro = new CentroDeMineral(new Coordenada(6,26));
		Assert.assertTrue(this.centroMineral.equals(otroCentro));
	}
	
	@Test
	public void unCentroDeMineralPuedeExtraerDeUnDepositoDeMinerales() {
		Coordenada coord = new Coordenada(1, 91);
		ambiente.insertarUnidad(coord, this.centroMineral);
		Assert.assertEquals(10, this.centroMineral.recolectarMinerales(ambiente));
	}
	
	@Test
	public void siUnCentroDeMineralExtraeDeUnDepositoDeMineralesLeRestan990() {
		Coordenada coord = new Coordenada(1, 91);
		ambiente.insertarUnidad(coord, this.centroMineral);
		Parcela parcela = ambiente.getParcela(coord);
		DepositoDeMinerales deposito = (DepositoDeMinerales) parcela.getSuperficie();
		
		this.centroMineral.recolectarMinerales(ambiente);
		
		Assert.assertEquals(990, deposito.getRecursos());
	}

}
