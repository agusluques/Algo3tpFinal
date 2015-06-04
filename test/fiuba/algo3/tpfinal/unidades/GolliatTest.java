package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class GolliatTest {

	@Test
	public void siSeCreaUnGolliatDebeTener125DeVida(){
		Golliat golliat = new Golliat();
		Assert.assertTrue(golliat.getVida() == 125);
	}
	
	@Test
	public void siAUnGolliatLePegan100DebeTener25(){
		Golliat golliat = new Golliat();
		Danio danio = new Danio(0,100);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 25);
	}
	
	@Test
	public void siAUnGolliatLePegan800DebeTener0(){
		Golliat golliat = new Golliat();
		Danio danio = new Danio(0,800);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 0);
	}
	
	@Test
	public void siUnGolliatAtacaAOtroAlSegundoLeBajaLaVidaA113() {
		
		Golliat unGolliat = new Golliat();
		Golliat otroGolliat = new Golliat();
		unGolliat.atacar(otroGolliat);
		Assert.assertTrue(otroGolliat.getVida() == 113);
	}

}
