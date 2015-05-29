package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class JuegoTest {

	private Juego juego;	
	
	@Before
	public void arrange(){
		this.juego = new Juego();
	}
	
	@Test
	public void siCreoUnJuegoElMapaNoEstaVacioPorqueSeCreaConIslas() {
		Assert.assertFalse(juego.mapaEstaVacio());
	}
	
	@Test
	public void siCreoUnJuegoElMapaNoDeberiaTenerPoblacionInicial(){
		Assert.assertTrue(juego.cantidadDePoblacion() == 0);
	}

}
