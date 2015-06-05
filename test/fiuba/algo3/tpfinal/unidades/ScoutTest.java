package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class ScoutTest {

	@Test
	public void siSeCreaUnScoutDebeTener150DeVidaY100DeEscudo(){
		Scout scout = new Scout();
		Assert.assertTrue(scout.getVida() == 150);
		Assert.assertTrue(scout.getEscudo() == 100);
		
	}
	
	@Test
	public void siAUnScoutLePegan110DebeTener140DeVida(){
		Scout scout = new Scout();
		Danio danio = new Danio(110,0);
		scout.atacado(danio);
		Assert.assertTrue(scout.getVida() == 140);
	}
	
	@Test
	public void siAUnScoutLePegan110PorTierraNoLeBajanVidaNiEscudo(){
		Scout scout = new Scout();
		Danio danio = new Danio(0,110);
		scout.atacado(danio);
		Assert.assertTrue(scout.getVida() == 150);
		Assert.assertTrue(scout.getEscudo() == 100);
	}
	
	@Test
	public void siAUnScoutLePegan800DebeTener0(){
		Scout scout = new Scout();
		Danio danio = new Danio(800,0);
		scout.atacado(danio);
		Assert.assertTrue(scout.getVida() == 0);
	}
	
	@Test
	public void siUnScoutAtacaAOtroAlSegundoLeBajaElEscudoA86YNoBajaVida() {
		
		Scout unScout = new Scout();
		Scout otroScout = new Scout();
		unScout.atacar(otroScout);
		Assert.assertTrue(otroScout.getVida() == 150);
		Assert.assertTrue(otroScout.getEscudo() == 86);
		
	}
}
