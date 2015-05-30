package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class PilonTest {
	
	private Pilon pilon;

	@Before
	public void arrange(){
		this.pilon = new Pilon();
	}
	
	@Test
	public void unPilonDebeTener300DeVidaInicial() {
		Assert.assertTrue(this.pilon.getVida() == 300);
	}
	
	@Test
	public void unPilonDebeTener300DeEscudoInicial() {
		Assert.assertTrue(this.pilon.getEscudo() == 300);
	}
	
	@Test
	public void unPilonDebeCostar100Minerales() {
		Assert.assertTrue(this.pilon.getCostoMineral() == 100);
	}
	
	@Test
	public void unNexoDebeCrearseEn5Turnos() {
		Assert.assertTrue(this.pilon.getTiempo() == 5);
	}

}
