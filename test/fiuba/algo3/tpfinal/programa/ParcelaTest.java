package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.ParcelaVacia;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class ParcelaTest {

	@Test
	public void unaParcelaSeCreaVacia(){
		
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Assert.assertTrue(parcela.estaVacia());
		
	}
	
	@Test
	public void siAgregoUnaUnidadLaParcelaNoEstaVacia(){
		
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot = new Zealot();
		parcela.ocupar(zealot);
		Assert.assertFalse(parcela.estaVacia());
		
	}
	
	@Test
	public void siAgregoUnaUnidadYLuegoLaPidoMeDevuelveLaMisma(){
		
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot = new Zealot();
		parcela.ocupar(zealot);
		Assert.assertEquals(zealot,parcela.getOcupante());
		
	}
	
	@Test (expected=ParcelaOcupada.class)
	public void siAgregoUnaUnidadAUnaParcelaOcupadaRetornaUnaExcepcion() throws ParcelaOcupada{
		
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		Zealot zealot1 = new Zealot();
		Zealot zealot2 = new Zealot();
		parcela.ocupar(zealot1);
		parcela.ocupar(zealot2);
		
	}
	
	@Test (expected=ParcelaVacia.class)
	public void siLePidoSuOcupanteAUnaParcelaVaciaRetornaUnaExcepcion() throws ParcelaVacia{
		
		Tierra tierra = new Tierra();
		Parcela parcela = new Parcela(tierra);
		parcela.getOcupante();
		
	}
	
	
}
