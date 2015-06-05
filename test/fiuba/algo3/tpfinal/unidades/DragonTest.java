package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class DragonTest {

	@Test
	public void siSeCreaUnDragonDebeTener100DeVidaY80DeEscudo(){
		Dragon dragon = new Dragon();
		Assert.assertTrue(dragon.getVida() == 100);
		Assert.assertTrue(dragon.getEscudo() == 80);
		
	}
	
	@Test
	public void siAUnDragonLePegan110DebeTener70DeVida(){
		Dragon dragon = new Dragon();
		Danio danio = new Danio(0,110);
		dragon.atacado(danio);
		Assert.assertTrue(dragon.getVida() == 70);
	}
	
	@Test
	public void siAUnDragonLePegan800DebeTener0(){
		Dragon dragon = new Dragon();
		Danio danio = new Danio(0,800);
		dragon.atacado(danio);
		Assert.assertTrue(dragon.getVida() == 0);
	}
	
	@Test
	public void siUnDragonAtacaAOtroAlSegundoLeBajaElEscudoA80YNoBajaVida() {
		
		Dragon unDragon = new Dragon();
		Dragon otroDragon = new Dragon();
		unDragon.atacar(otroDragon);
		Assert.assertTrue(otroDragon.getVida() == 100);
		Assert.assertTrue(otroDragon.getEscudo() == 60);
		
	}

}
