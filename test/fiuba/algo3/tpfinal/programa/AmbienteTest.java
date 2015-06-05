package fiuba.algo3.tpfinal.programa;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.MapaInvalido;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class AmbienteTest {
	
	
	@Test
	public void siCreoUnAmbienteDeberiaEstarVacio() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Assert.assertTrue(ambiente.mapaEstaVacio());
	}

	@Test
	public void siAgregoUnaUnidadAlAmbienteDejaDeEstarVacio() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Zealot zealot = new Zealot();
		Coordenada coord = new Coordenada(1,6);
		ambiente.insertarUnidad(coord, zealot);
		Assert.assertFalse(ambiente.mapaEstaVacio());
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil1Col50TieneAire() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Coordenada coord = new Coordenada(1,50);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Aire()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil1Col1TieneTierra() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Coordenada coord = new Coordenada(1,1);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Tierra()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil6Col20TieneUnDepositoDeMinerales() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Coordenada coord = new Coordenada(6,20);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeMinerales()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil6Col26TieneUnDepositoDeGas() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Coordenada coord = new Coordenada(6,26);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeGas()));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void siCreoMapaQueNoExisteDeberiaLanzarExcepcion() throws Exception{
		@SuppressWarnings("unused")//se usa para que lance la excepcion
		Ambiente ambienteErroneo = new Ambiente("archivoQueNoExiste.txt");
	}
	
	
	@Test
	public void elAnchoDelMapaTierraEs100() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Assert.assertEquals(100, ambiente.getAncho());
	}
	
	@Test
	public void elAltoDelMapaTierraEs100() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		Assert.assertEquals(100, ambiente.getAlto());
	}
	
	@Test(expected = MapaInvalido.class)
	public void elMapa1NoSePuedeCrear() throws Exception {
		@SuppressWarnings("unused")
		Ambiente ambiente = new Ambiente("mapa1.txt");
	}
}
	 


