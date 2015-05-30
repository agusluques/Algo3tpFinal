package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {
	private Ambiente juego;

	@Before
	public void arrange() {
		this.juego = new Ambiente();
	}

	@Test
	public void siCreoUnJuegoElMapaNoEstaVacioPorqueSeCreaConIslas() {
		Assert.assertFalse(juego.mapaEstaVacio());
	}

	@Test
	public void siCreoUnJuegoElMapaNoDeberiaTenerPoblacionInicial() {
		Assert.assertTrue(juego.cantidadDePoblacion() == 0);
	}

}
	 


