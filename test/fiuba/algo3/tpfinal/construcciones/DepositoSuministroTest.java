package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Constructible;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

public class DepositoSuministroTest {

	private DepositoSuministro depositoSuministro;

	@Before
	public void arrange() {
		this.depositoSuministro = new DepositoSuministro();
	}

	@Test
	public void debeTenerVidaIgualA500() {
		Assert.assertTrue(this.depositoSuministro.getVida() == 500);
	}

	@Test
	public void debeTardar6TurnosEnCrearse() {
		Assert.assertTrue(this.depositoSuministro.getTiempoRestante() == 6);
	}

	@Test
	public void debeCostar100Minerales() {
		Assert.assertTrue(this.depositoSuministro.getCosto().getMinerales() == 100);
	}

	@Test
	public void dosDepositosDeberianSerIguales() {
		Constructible otroDeposito = new DepositoSuministro();
		Assert.assertTrue(this.depositoSuministro.equals(otroDeposito));
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1,
				this.depositoSuministro.rangoDeAtaqueCorrespondiente(rango));
	}
}
