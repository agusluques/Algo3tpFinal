package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;

public class EnergiaTest {
	
	@Test
	public void laEnergiaSeIniciaConCantidadInicial() {
		Energia energia = new Energia(50);
		
		Assert.assertEquals(50, energia.getEnergia());
	}
	
	@Test
	public void siInicioCon50YGasto10Tengo40() throws EnergiaInsuficiente {
		Energia energia = new Energia(50);
		
		energia.gastarEnergia(10);
		
		Assert.assertEquals(40, energia.getEnergia());
	}
	
	@Test(expected = EnergiaInsuficiente.class)
	public void siQuieroGastarMasEnergiaDeLaQueTengoLanzaExcepcion() throws EnergiaInsuficiente   {
		Energia energia = new Energia(50);
		
		energia.gastarEnergia(60);
	}
	
	@Test
	public void siGastoMasEnergiaDeLaQueTengoLanzaExcepcionYNoSeModificaLaCantidad() {
		Energia energia = new Energia(50);
		try {			
			energia.gastarEnergia(60);
		} catch (EnergiaInsuficiente e) {
			Assert.assertEquals(50, energia.getEnergia());
		}
	}
	
	@Test
	public void siInicioCon50YAumento5Tengo55() {
		Energia energia = new Energia(50);
		
		energia.aumentarEnergia(5);
		
		Assert.assertEquals(55, energia.getEnergia());
	}
	
	@Test
	public void siInicioCon50YAumento150Tengo200() {
		Energia energia = new Energia(50);
		
		energia.aumentarEnergia(150);
		
		Assert.assertEquals(200, energia.getEnergia());
	}
	
	@Test
	public void siInicioCon50YAumento151Tengo200() {
		Energia energia = new Energia(50);
		
		energia.aumentarEnergia(151);
		
		Assert.assertEquals(200, energia.getEnergia());
	}

}
