package fiuba.algo3.tpfinal.programa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.programa.Vida;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;

public class VidaSimpleTest {

	@Test
	public void laVidaSeInicializaCorrectamente() {
		Vida vida = new VidaSimple(50);

		assertEquals(50, vida.getCantidadDeVida());
	}

	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon10Quedan40() {
		Vida vida = new VidaSimple(50);

		vida.recibirDanio(10);

		assertEquals(40, vida.getCantidadDeVida());
	}

	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon50Quedan0() {
		Vida vida = new VidaSimple(50);

		vida.recibirDanio(50);

		assertEquals(0, vida.getCantidadDeVida());
	}

	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon50EstaMuerta() {
		Vida vida = new VidaSimple(50);

		vida.recibirDanio(50);

		assertTrue(vida.estaMuerto());
	}

	@Test
	public void laVidaNoBajaDe0AunqueLaAtaquenConMasDeLoQueTiene() {
		Vida vida = new VidaSimple(50);

		vida.recibirDanio(150);

		assertEquals(0, vida.getCantidadDeVida());
	}

}
