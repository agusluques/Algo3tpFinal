package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;

public class DepositoDeMineralesTest {

	@Test
	public void losDepositosDeMineralesSeCreanCon1000Minerales() {

		DepositoDeMinerales deposito = new DepositoDeMinerales();
		Assert.assertTrue(deposito.getRecursos() == 1000);

	}

	@Test
	public void siExtraigoMineralesDeUnDepositoMeDevuelve10() {
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		int cantidadExtraida = 0;
		cantidadExtraida += deposito.extraerRecursos();

		Assert.assertEquals(10, cantidadExtraida);

	}

	@Test
	public void siExtraigoGasDeUnDeposito100VecesMeDevuelve1000() {
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		int cantidadExtraida = 0;
		for (int i = 0; i < 100; i++) {
			cantidadExtraida += deposito.extraerRecursos();
		}

		Assert.assertEquals(1000, cantidadExtraida);

	}

	@Test
	public void siExtraigoMineralesDeUnDepositoMasDe100VecesMeDevuelve1000() {
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		int cantidadExtraida = 0;
		for (int i = 0; i < 101; i++) {
			cantidadExtraida += deposito.extraerRecursos();
		}

		Assert.assertEquals(1000, cantidadExtraida);

	}

	@Test
	public void dosDepositoDeMineralesSonIguales() {
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		DepositoDeMinerales otroDeposito = new DepositoDeMinerales();

		Assert.assertTrue(deposito.equals(otroDeposito));
	}

	@Test
	public void dosDepositoDeMineralesTienenElMismoHashCode() {
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		DepositoDeMinerales otroDeposito = new DepositoDeMinerales();

		Assert.assertEquals(deposito.hashCode(), otroDeposito.hashCode());
	}
}
