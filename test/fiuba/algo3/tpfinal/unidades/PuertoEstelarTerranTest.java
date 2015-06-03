package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;

public class PuertoEstelarTerranTest {

	private PuertoEstelarTerran puertoEstelar;

	@Test
	public void debeTener1300DeVida() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getVida() == 1300);
		
	}
	
	@Test
	public void debeTardar10TurnosEnCrearse() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getTiempo() == 10);
	}
	
	@Test
	public void debeCostar150MineralesY100DeGas() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 100);
	}
	
	@Test
	public void dosPuertosEstelaresDeberianSerIguales() {
		this.puertoEstelar = new PuertoEstelarTerran();
		Constructible otroPuerto = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.equals(otroPuerto));
	}

}

