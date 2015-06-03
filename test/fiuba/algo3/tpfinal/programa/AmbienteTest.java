package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.unidades.Zealot;

public class AmbienteTest {
	private Ambiente ambiente;

	@Before
	public void arrange() throws Exception {
		this.ambiente = new Ambiente("mapa1.txt");
	}
	
	@Test
	public void siCreoUnAmbienteDeberiaEstarVacio() {
		Assert.assertTrue(ambiente.mapaEstaVacio());
	}

	@Test
	public void siAgregoUnaUnidadAlAmbienteDejaDeEstarVacio() {
		
		Zealot zealot = new Zealot();
		Coordenada coord = new Coordenada(1,6);
		ambiente.insertarUnidad(coord, zealot);
		Assert.assertFalse(ambiente.mapaEstaVacio());
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion12TieneAire() {
		
		Coordenada coord = new Coordenada(1,2);
		Parcela parcela = ambiente.gerParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Aire()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion25TieneTierra() {
		
		Coordenada coord = new Coordenada(2,5);
		Parcela parcela = ambiente.gerParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Tierra()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion18TieneUnDepositoDeMinerales() {
		
		Coordenada coord = new Coordenada(1,8);
		Parcela parcela = ambiente.gerParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeMinerales()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion37TieneUnDepositoDeGas() {
		
		Coordenada coord = new Coordenada(3,7);
		Parcela parcela = ambiente.gerParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeGas()));
	}
}
	 


