package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PuertoEstelarTest {
	
	private PuertoEstelar puertoEstelar;

	@Before
	public void arrange() {
		this.puertoEstelar = new PuertoEstelar();
	}

	@Test
	public void unPuertoEstelarDebeTener600DeVidaInicial() {
		Assert.assertTrue(this.puertoEstelar.getVida() == 600);
	}

	@Test
	public void unPuertoEstelarDebeTener600DeEscudoInicial() {
		Assert.assertTrue(this.puertoEstelar.getEscudo() == 600);
	}

	@Test
	public void unPuertoEstelarDebeCostar150Minerales() {
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
	}
	
	@Test
	public void unPuertoEstelarDebeCostar150Gases() {
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 150);
	}

	@Test
	public void unPuertoEstelarDebeCrearseEn10Turnos() {
		Assert.assertTrue(this.puertoEstelar.getTiempo() == 10);
	}

}
