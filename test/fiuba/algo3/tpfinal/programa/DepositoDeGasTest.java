package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;

public class DepositoDeGasTest {

	@Test
	public void losDepositosDeGasSeCreanCon3000Minerales() {

		DepositoDeGas deposito = new DepositoDeGas();
		Assert.assertTrue(deposito.getRecursos() == 3000);

	}

	@Test
	public void siExtraigoGasDeUnDepositoMeDevuelve10() {
		DepositoDeGas deposito = new DepositoDeGas();
		int cantidadExtraida = 0;
		cantidadExtraida += deposito.extraerRecursos();

		Assert.assertEquals(10, cantidadExtraida);

	}

	@Test
	public void siExtraigoGasDeUnDeposito300VecesMeDevuelve3000() {
		DepositoDeGas deposito = new DepositoDeGas();
		int cantidadExtraida = 0;
		for (int i = 0; i < 300; i++) {
			cantidadExtraida += deposito.extraerRecursos();
		}

		Assert.assertEquals(3000, cantidadExtraida);

	}

	@Test
	public void siExtraigoGasDeUnDepositoMasDe300VecesMeDevuelve3000() {
		DepositoDeGas deposito = new DepositoDeGas();
		int cantidadExtraida = 0;
		for (int i = 0; i < 301; i++) {
			cantidadExtraida += deposito.extraerRecursos();
		}

		Assert.assertEquals(3000, cantidadExtraida);

	}

	@Test
	public void dosDepositosDeGasSonIguales() {
		DepositoDeGas deposito = new DepositoDeGas();
		DepositoDeGas otroDeposito = new DepositoDeGas();

		Assert.assertTrue(deposito.equals(otroDeposito));
	}

	@Test
	public void dosDepositosDeGasTienenElMismoHashCode() {
		DepositoDeGas deposito = new DepositoDeGas();
		DepositoDeGas otroDeposito = new DepositoDeGas();

		Assert.assertEquals(deposito.hashCode(), otroDeposito.hashCode());
	}
}
