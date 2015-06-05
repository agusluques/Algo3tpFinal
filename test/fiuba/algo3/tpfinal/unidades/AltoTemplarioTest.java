package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class AltoTemplarioTest {

	@Test
	public void siSeCreaUnAltoTemplarioDebeTener40DeVidaY40DeEscudo(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 40);
		
	}
	
	@Test
	public void siAUnAltoTemplarioLePegan50DebeTener30DeVida(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0,50);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 30);
	}
	
	@Test
	public void siAUnAltoTemplarioLePegan800DebeTener0(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0,800);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 0);
	}
	
	@Test
	public void siUnDragonAtacaAUnAltoTemplarioAlSegundoLeBajaElEscudoA20YNoBajaVida() {
		
		Dragon unDragon = new Dragon();
		AltoTemplario altoTemplario = new AltoTemplario();
		unDragon.atacar(altoTemplario);
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 20);
		
	}

}
