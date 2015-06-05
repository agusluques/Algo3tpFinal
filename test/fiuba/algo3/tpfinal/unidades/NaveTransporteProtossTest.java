package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteProtossTest {

	@Test
	public void siSeCreaUnaNaveTransporteProtossDebeTener80DeVidaY60DeEscudo(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Assert.assertTrue(nave.getVida() == 80);
		Assert.assertTrue(nave.getEscudo() == 60);
		
	}
	
	@Test
	public void siAUnaNaveTransporteProtossLePegan100DebeTener40DeVida(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(100,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 40);
	}
	
	@Test
	public void siAUnaNaveTransporteProtossLePegan800DebeTener0(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(800,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 0);
	}
	
	@Test
	public void siUnDragonAtacaAUnaNaveTransporteProtossAlSegundoLeBajaElEscudoA40YNoBajaVida() {
		
		Dragon unDragon = new Dragon();
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		unDragon.atacar(nave);
		Assert.assertTrue(nave.getVida() == 80);
		Assert.assertTrue(nave.getEscudo() == 40);
		
	}
	
	
	

}
