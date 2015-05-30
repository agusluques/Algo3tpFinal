package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class NexoMineralTest {

	private NexoMineral nexo;

	@Before
	public void arrange() {
		this.nexo = new NexoMineral();
	}

	@Test
	public void unNexoDebeTener250DeVidaInicial() {
		Assert.assertTrue(this.nexo.getVida() == 250);
	}

	@Test
	public void unNexoDebeTener250DeEscudoInicial() {
		Assert.assertTrue(this.nexo.getEscudo() == 250);
	}

	@Test
	public void unNexoDebeCostar50Minerales() {
		Assert.assertTrue(this.nexo.getCostoMineral() == 50);
	}
	
	@Test
	public void unNexoDebeCostar0Gases() {
		Assert.assertTrue(this.nexo.getCostoGas() == 0);
	}

	@Test
	public void unNexoDebeCrearseEn4Turnos() {
		Assert.assertTrue(this.nexo.getTiempo() == 4);
	}
	
	@Test
	public void siAtacanUnNexoCon100LaVidaQuedaIntactaYElEscudoEn150() {
		nexo.atacado(100);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 150);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon250LaVidaQuedaIntactaYElEscudoEn0() {
		nexo.atacado(250);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon300LaVidaQuedaEn200YElEscudoEn0() {
		nexo.atacado(300);
		boolean resultado = (nexo.getVida() == 200 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon600LaVidaQuedaEn0YElEscudoEn0() {
		nexo.atacado(600);
		boolean resultado = (nexo.getVida() == 0 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}

}