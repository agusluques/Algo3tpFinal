package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;
import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Danio;


public class ZealotTest {

	@Test
	public void siUnZealotRecibeDanioLeBajaElEscudo() {
				
		Zealot unZealot = new Zealot();
		Danio unDanio = new Danio (30);
		unZealot.atacado(unDanio);
		Assert.assertTrue(unZealot.getEscudo() == 30);
		
	}
	
	@Test
	public void siUnZealotRecibeMasDe60DeDanioLeDestruyeElEscudoYLeBajaLaVida() {
		
		Zealot unZealot = new Zealot();
		Danio unDanio = new Danio (70);
		unZealot.atacado(unDanio);
		Assert.assertTrue(unZealot.getEscudo() == 0);
		Assert.assertTrue(unZealot.getVida() == 50);
	
	}

	@Test
	public void siUnZealotAtacaAOtroAlSegundoLeBajaElEscudo() {
		
		Zealot unZealot = new Zealot();
		Zealot otroZealot = new Zealot();
		unZealot.atacar(otroZealot);
		Assert.assertTrue(otroZealot.getEscudo() == 52);
	}
	
	
}