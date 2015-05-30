package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;

public class FabricaTest {

	private Fabrica fabrica;
	

	
	
	@Test
	public void debeTener1250DeVida() throws ConstruccionRequeridaInexistente{
		@SuppressWarnings("unused")//sirve para que pase el test
		Barraca barracaHecha = new Barraca();
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getVida() == 1250);
		
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siNoSeCreaUnaBarracaAntesDeberiaLanzarExcepcion() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
	}
	
	@Test
	public void debeTardar12TurnosEnCrearse() throws ConstruccionRequeridaInexistente{
		@SuppressWarnings("unused")//sirve para que pase el test
		Barraca barracaHecha = new Barraca();
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getTiempo() == 12);
	}
	
	@Test
	public void debeCostar200MineralesY100DeGas() throws ConstruccionRequeridaInexistente{
		@SuppressWarnings("unused")//sirve para que pase el test
		Barraca barracaHecha = new Barraca();
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getCostoMineral() == 200);
		Assert.assertTrue(this.fabrica.getCostoGas() == 100);
	}

}
