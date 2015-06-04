package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.unidades.Constructible;
import fiuba.algo3.tpfinal.unidades.NexoMineral;

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
		Danio danio = new Danio(100);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 150);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon250LaVidaQuedaIntactaYElEscudoEn0() {
		Danio danio = new Danio(250);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon300LaVidaQuedaEn200YElEscudoEn0() {
		Danio danio = new Danio(300);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 200 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void siAtacanUnNexoCon600LaVidaQuedaEn0YElEscudoEn0() {
		Danio danio = new Danio(600);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 0 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void dosNexosDeberianSerIguales() {
		Constructible otroNexo = new NexoMineral();
		Assert.assertTrue(this.nexo.equals(otroNexo));
	}

}
