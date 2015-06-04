package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class NaveCienciaTest {

	@Test
	public void siSeCreaUnaNaveCienciaDebeTener200DeVida(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Assert.assertTrue(naveCiencia.getVida() == 200);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan100DebeTener100(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(100,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 100);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan800DebeTener0(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(800,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 0);
	}
	
	@Test
	public void siUnEspectroAtacaAUnaNaveCienciaAlSegundoLeBajaLaVidaA180() {
		
		Espectro unEspectro = new Espectro();
		NaveCiencia unaNaveCiencia = new NaveCiencia();
		unEspectro.atacar(unaNaveCiencia);
		Assert.assertTrue(unaNaveCiencia.getVida() == 180);
	}

}
