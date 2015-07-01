package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class PilonTest {

	private Pilon pilon;

	@Before
	public void arrange() {
		this.pilon = new Pilon();
	}

	@Test
	public void unPilonDebeTener300DeVidaInicial() {
		Assert.assertTrue(this.pilon.getCantidadDeVida() == 300);
	}

	@Test
	public void unPilonDebeTener300DeEscudoInicial() {
		Assert.assertTrue(this.pilon.getCantidadDeEscudo() == 300);
	}

	@Test
	public void unPilonDebeCostar100Minerales() {
		Assert.assertTrue(this.pilon.getCosto().getMinerales() == 100);
	}

	@Test
	public void unPilonDebeCostar0Gases() {
		Assert.assertTrue(this.pilon.getCosto().getGas() == 0);
	}

	@Test
	public void unNexoDebeCrearseEn5Turnos() {
		Assert.assertTrue(this.pilon.getTiempoRestante() == 5);
	}

	@Test
	public void dosPilonesDeberianSerIguales() {
		Constructible otroPilon = new Pilon();
		Assert.assertTrue(this.pilon.equals(otroPilon));
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, this.pilon.rangoDeAtaqueCorrespondiente(rango));
	}

}
