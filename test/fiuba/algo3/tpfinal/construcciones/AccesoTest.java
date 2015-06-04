package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.unidades.Acceso;
import fiuba.algo3.tpfinal.unidades.Constructible;

public class AccesoTest {
	
	private Acceso acceso;

	@Before
	public void arrenge() {
		this.acceso = new Acceso();
	}

	@Test
	public void unAccesoDebeTener500DeVidaInicial() {
		Assert.assertTrue(this.acceso.getVida() == 500);
	}

	@Test
	public void unAccesoDebeTener500DeEscudoInicial() {
		Assert.assertTrue(this.acceso.getEscudo() == 500);
	}

	@Test
	public void unAccesoDebeCostar150Minerales() {
		Assert.assertTrue(this.acceso.getCostoMineral() == 150);
	}
	
	@Test
	public void unAccesoDebeCostar0Gases() {
		Assert.assertTrue(this.acceso.getCostoGas() == 0);
	}

	@Test
	public void unAccesoDebeCrearseEn8Turnos() {
		Assert.assertTrue(this.acceso.getTiempo() == 8);
	}
	
	@Test
	public void dosAccesosDeberianSerIguales() {
		Constructible otroAcceso = new Acceso();
		Assert.assertTrue(this.acceso.equals(otroAcceso));
	}

}
