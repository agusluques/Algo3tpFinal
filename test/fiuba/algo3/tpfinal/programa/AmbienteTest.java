package fiuba.algo3.tpfinal.programa;

import java.io.FileNotFoundException;

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
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Aire()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion25TieneTierra() {
		
		Coordenada coord = new Coordenada(2,5);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Tierra()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion18TieneUnDepositoDeMinerales() {
		
		Coordenada coord = new Coordenada(1,8);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeMinerales()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicion37TieneUnDepositoDeGas() {
		
		Coordenada coord = new Coordenada(3,7);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeGas()));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void siCreoMapaQueNoExisteDeberiaLanzarExcepcion() throws Exception{
		@SuppressWarnings("unused")//se usa para que lance la excepcion
		Ambiente ambienteErroneo = new Ambiente("archivoQueNoExiste.txt");
	}
	
	@Test
	public void elAnchoDelMapa1Es13() {
		Assert.assertEquals(13, ambiente.getAncho());
	}
	
	@Test
	public void elAltoDelMapa1Es5() {
		Assert.assertEquals(5, ambiente.getAlto());
	}
	
	
	@Test
	public void elMapa1NoCumpleLosRequisitos() {
		int ancho = ambiente.getAncho();
		int alto = ambiente.getAlto();

		// Primer cuarto
		int cantidadDeMinerales = 0;
		int cantidadDeVolcanes = 0;
		int cantidadDeBases1 = 0;
		for (int i = 1; i <= alto / 2; i++) {
			for (int j = 1; j <= ancho / 2; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie() == new DepositoDeGas()) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales > 10 && cantidadDeVolcanes == 1) {
					cantidadDeBases1 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Segundo cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases2 = 0;
		for (int i = 1; i <= alto / 2; i++) {
			for (int j = ancho/2 + 1; j <= ancho; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie() == new DepositoDeMinerales()) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie() == new DepositoDeGas()) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales > 10 && cantidadDeVolcanes == 1) {
					cantidadDeBases2 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Tercer cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases3 = 0;
		for (int i = alto/2 + 1; i <= alto; i++) {
			for (int j = 1; j <= ancho / 2; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie() == new DepositoDeMinerales()) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie() == new DepositoDeGas()) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales > 10 && cantidadDeVolcanes == 1) {
					cantidadDeBases3 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Cuarto cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases4 = 0;
		for (int i = alto / 2 + 1; i <= alto; i++) {
			for (int j = ancho / 2 + 1; j <= ancho; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie() == new DepositoDeMinerales()) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie() == new DepositoDeGas()) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales > 10 && cantidadDeVolcanes == 1) {
					cantidadDeBases4 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		Assert.assertFalse(cantidadDeBases1 > 0
				&& cantidadDeBases1 == cantidadDeBases2
				&& cantidadDeBases1 == cantidadDeBases3
				&& cantidadDeBases1 == cantidadDeBases4);

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
	
	@Test
	public void elMapaTierraCumpleLosRequisitos() throws Exception {
		Ambiente ambiente = new Ambiente("mapaTierra.txt");
		int ancho = ambiente.getAncho();
		int alto = ambiente.getAlto();

		// Primer cuarto
		int cantidadDeMinerales = 0;
		int cantidadDeVolcanes = 0;
		int cantidadDeBases1 = 0;
		for (int i = 1; i <= alto / 2; i++) {
			for (int j = 1; j <= ancho / 2; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales >= 8 && cantidadDeVolcanes == 1) {
					cantidadDeBases1 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Segundo cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases2 = 0;
		for (int i = 1; i <= alto / 2; i++) {
			for (int j = ancho/2 + 1; j <= ancho; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales >= 8 && cantidadDeVolcanes == 1) {
					cantidadDeBases2 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Tercer cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases3 = 0;
		for (int i = alto/2 + 1; i <= alto; i++) {
			for (int j = 1; j <= ancho / 2; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales >= 8 && cantidadDeVolcanes == 1) {
					cantidadDeBases3 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		// Cuarto cuarto
		cantidadDeMinerales = 0;
		cantidadDeVolcanes = 0;
		int cantidadDeBases4 = 0;
		for (int i = alto / 2 + 1; i <= alto; i++) {
			for (int j = ancho / 2 + 1; j <= ancho; j++) {
				Coordenada coordActual = new Coordenada(i, j);
				Parcela parcelaActual = ambiente.getParcela(coordActual);
				if (parcelaActual.getSuperficie().equals(new DepositoDeMinerales())) {
					cantidadDeMinerales += 1;
				}
				if (parcelaActual.getSuperficie().equals(new DepositoDeGas())) {
					cantidadDeVolcanes += 1;
				}
				if (cantidadDeMinerales >= 8 && cantidadDeVolcanes == 1) {
					cantidadDeBases4 += 1;
					cantidadDeMinerales = 0;
					cantidadDeVolcanes = 0;
				}
			}
		}

		Assert.assertTrue(cantidadDeBases1 > 0
				&& cantidadDeBases1 == cantidadDeBases2
				&& cantidadDeBases1 == cantidadDeBases3
				&& cantidadDeBases1 == cantidadDeBases4);

	}
}
	 


