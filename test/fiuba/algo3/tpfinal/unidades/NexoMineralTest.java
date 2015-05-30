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
	public void unNexoDebeCrearseEn4Turnos() {
		Assert.assertTrue(this.nexo.getTiempo() == 4);
	}

}
