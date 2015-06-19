package fiuba.algo3.tpfinal.programa;

import static org.junit.Assert.*;

import org.junit.Test;

public class VidaSimpleTest {
	
	@Test
	public void laVidaSeInicializaCorrectamente() {
		VidaSimple vida = new VidaSimple(50);
		
		assertEquals(50, vida.getVida());
	}
	
	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon10Quedan40() {
		VidaSimple vida = new VidaSimple(50);
		
		vida.recibirDanio(10);
		
		assertEquals(40, vida.getVida());
	}
	
	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon50Quedan0() {
		VidaSimple vida = new VidaSimple(50);
		
		vida.recibirDanio(50);
		
		assertEquals(0, vida.getVida());
	}
	
	@Test
	public void siLaVidaSeIniciaEn50YLaDanioCon50EstaMuerta() {
		VidaSimple vida = new VidaSimple(50);
		
		vida.recibirDanio(50);
		
		assertTrue(vida.estaMuerto());
	}
	
	@Test
	public void laVidaNoBajaDe0AunqueLaAtaquenConMasDeLoQueTiene() {
		VidaSimple vida = new VidaSimple(50);
		
		vida.recibirDanio(150);
		
		assertEquals(0, vida.getVida());
	}

}
