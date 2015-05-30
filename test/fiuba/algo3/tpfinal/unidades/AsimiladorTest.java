package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AsimiladorTest {

	private Asimilador asimilador;

	@Before
	public void arrange() {
		this.asimilador = new Asimilador();
	}

	@Test
	public void unAsimiladorDebeTener450DeVidaInicial() {
		Assert.assertTrue(this.asimilador.getVida() == 450);
	}

	@Test
	public void unAsimiladorDebeTener450DeEscudoInicial() {
		Assert.assertTrue(this.asimilador.getEscudo() == 450);
	}

	@Test
	public void unAsimiladorDebeCostar100Minerales() {
		Assert.assertTrue(this.asimilador.getCostoMineral() == 100);
	}

	@Test
	public void unAsimiladorDebeCostar0Gases() {
		Assert.assertTrue(this.asimilador.getCostoGas() == 0);
	}
	
	@Test
	public void unAsimiladorDebeCrearseEn6Turnos() {
		Assert.assertTrue(this.asimilador.getTiempo() == 6);
	}
	
}
