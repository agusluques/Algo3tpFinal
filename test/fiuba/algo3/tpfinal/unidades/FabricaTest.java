package fiuba.algo3.tpfinal.unidades;

import org.junit.Test;

import junit.framework.Assert;



import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;

public class FabricaTest {

	private Fabrica fabrica;
	
	@Test
	public void debeTener1250DeVida() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getVida() == 1250);
		
	}
	
	@Test
	public void debeTardar12TurnosEnCrearse() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getTiempo() == 12);
	}
	
	@Test
	public void debeCostar200MineralesY100DeGas() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getCostoMineral() == 200);
		Assert.assertTrue(this.fabrica.getCostoGas() == 100);
	}
	
	@Test
	public void dosFabricasDeberianSerIguales() {
		this.fabrica = new Fabrica();
		Constructible otraFabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.equals(otraFabrica));
	}

}
