package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AmbienteTest {
	private Ambiente juego;

	@Before
	public void arrange() throws Exception {
		this.juego = new Ambiente();
	}
	
	@Test
	public void siEnLaPos5DelArchivoMapa1HayUn1DeberiaGuardarseUnaTierra() throws Exception{
		Assert.assertTrue(juego.getMapa().get(5).getNombre() == "tierra");
	}
	
	@Test
	public void siEnLaPos4DelArchivoHayUn1DeberiaGuardarseUnaTierra(){
		Assert.assertTrue(juego.getMapa().get(4).getNombre() == "aire");
	}
	

	@Test
	public void siCreoUnJuegoElMapaNoDeberiaTenerPoblacionInicial() {
		Assert.assertTrue(juego.cantidadDePoblacion() == 0);
	}

}
	 


