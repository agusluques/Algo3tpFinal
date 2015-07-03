package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaVacia;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class ParcelaTest {

	@Test
	public void unaParcelaSeCreaVacia() {

		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Assert.assertTrue(parcela.estaVacia());

	}

	@Test
	public void siAgregoUnaUnidadLaParcelaNoEstaVacia() throws ParcelaOcupada {

		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot = new Zealot();
		parcela.ocupar(zealot);
		Assert.assertFalse(parcela.estaVacia());

	}

	@Test
	public void siAgregoUnaUnidadYLuegoLaPidoMeDevuelveLaMisma() throws ParcelaOcupada {

		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot = new Zealot();
		parcela.ocupar(zealot);
		Assert.assertEquals(zealot, parcela.getOcupante());

	}

	@Test(expected = ParcelaOcupada.class)
	public void siAgregoUnaUnidadAUnaParcelaOcupadaRetornaUnaExcepcion()
			throws ParcelaOcupada {

		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot1 = new Zealot();
		Zealot zealot2 = new Zealot();
		parcela.ocupar(zealot1);
		parcela.ocupar(zealot2);

	}

	@Test(expected = ParcelaVacia.class)
	public void siLePidoSuOcupanteAUnaParcelaVaciaRetornaUnaExcepcion()
			throws ParcelaVacia {

		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		parcela.getOcupante();

	}

	@Test
	public void siDesocupoUnaParcelaMeDevuelteSuOcupante() throws ParcelaOcupada {
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot1 = new Zealot();
		parcela.ocupar(zealot1);

		Atacable desocupado = parcela.desocupar();

		Assert.assertEquals(zealot1, desocupado);
	}

	@Test
	public void siDesocupoUnaParcelaQuedaVacia() throws ParcelaOcupada {
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot1 = new Zealot();
		parcela.ocupar(zealot1);

		@SuppressWarnings("unused")
		Atacable desocupado = parcela.desocupar();

		Assert.assertTrue(parcela.estaVacia());
	}

	@Test(expected = ParcelaVacia.class)
	public void siDesocupoUnaParcelaVaciaLanzaUnaExcepcion() {
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);

		@SuppressWarnings("unused")
		Atacable desocupado = parcela.desocupar();
	}

}
