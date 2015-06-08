package fiuba.algo3.tpfinal.programa;

import java.io.FileNotFoundException;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.MapaInvalido;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class MapaTest {
	
	
	@Test
	public void siCreoUnAmbienteDeberiaEstarVacio() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Assert.assertTrue(ambiente.mapaEstaVacio());
	}

	@Test
	public void siAgregoUnaUnidadAlAmbienteDejaDeEstarVacio() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Zealot zealot = new Zealot();
		Coordenada coord = new Coordenada(1,6);
		ambiente.insertarUnidad(coord, zealot);
		Assert.assertFalse(ambiente.mapaEstaVacio());
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil1Col50TieneAire() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Coordenada coord = new Coordenada(1,50);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Aire()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil1Col1TieneTierra() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Coordenada coord = new Coordenada(1,1);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new Tierra()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil6Col20TieneUnDepositoDeMinerales() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Coordenada coord = new Coordenada(6,20);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeMinerales()));
	}
	
	@Test
	public void siCreoMiMapaDePruebaLaPosicionFil6Col26TieneUnDepositoDeGas() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Coordenada coord = new Coordenada(6,26);
		Parcela parcela = ambiente.getParcela(coord);
		Assert.assertTrue(parcela.getSuperficie().equals(new DepositoDeGas()));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void siCreoMapaQueNoExisteDeberiaLanzarExcepcion() throws Exception{
		@SuppressWarnings("unused")//se usa para que lance la excepcion
		Mapa ambienteErroneo = new Mapa("archivoQueNoExiste.txt");
	}
	
	
	@Test
	public void elAnchoDelMapaTierraEs100() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Assert.assertEquals(100, ambiente.getAncho());
	}
	
	@Test
	public void elAltoDelMapaTierraEs100() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Assert.assertEquals(100, ambiente.getAlto());
	}
	
	@Test(expected = MapaInvalido.class)
	public void elMapa1NoSePuedeCrear() throws Exception {
		@SuppressWarnings("unused")
		Mapa ambiente = new Mapa("mapa1.txt");
	}
	
	@Test
	public void siIntercambioUnCentroDeMineralesConUnaTierraSeIntercambianCorrectamente() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Coordenada coordenadaTierra = new Coordenada(1,1);
		Coordenada coordenadaMineral = new Coordenada(1,100);
		Parcela parcelaTierra = ambiente.getParcela(coordenadaTierra);
		Parcela parcelaMineral = ambiente.getParcela(coordenadaMineral);
		
		ambiente.intercambiarParcelas(coordenadaTierra, coordenadaMineral);
		
		Assert.assertEquals(parcelaTierra, ambiente.getParcela(coordenadaMineral));
		Assert.assertEquals(parcelaMineral, ambiente.getParcela(coordenadaTierra));
	}

	@Test
	public void siIntentoUbicarUnaUnidadEnUnaPosicionVaciaQuedaEnEsaPosicion() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Zealot unZealot = new Zealot();
		Coordenada coord = new Coordenada(3,3);
		ambiente.ubicarCercaDe(unZealot, coord);
		Assert.assertTrue(unZealot.getCoordenada().equals(coord));
		Assert.assertTrue(ambiente.getParcela(coord).getOcupante().equals(unZealot));
	}

	@Test
	public void siTengoUnaUnidadEnLaEsquinaDelMapaLaOtraSeUbicaAlLado() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Zealot unZealot = new Zealot();
		Zealot otroZealot = new Zealot();
		Coordenada coord = new Coordenada(1,1);
		Coordenada coord2 = new Coordenada(1,2);
		
		ambiente.insertarUnidad(coord, unZealot);
		ambiente.ubicarCercaDe(otroZealot, coord);
		
		Assert.assertTrue(otroZealot.getCoordenada().equals(coord2));
		Assert.assertTrue(ambiente.getParcela(coord2).getOcupante().equals(otroZealot));
		
	}
	
	@Test
	public void siUbico8UnidadesCercaDeUnaEstasLaRodean() throws Exception {
		Mapa ambiente = new Mapa("mapaTierra.txt");
		Zealot unZealot = new Zealot();
		Atacable otroZealot;
		ambiente.insertarUnidad(new Coordenada(3,3), unZealot);
		for (int i=0;i<8;i++){
			ambiente.ubicarCercaDe(new Zealot(), new Coordenada(3,3));
		}
		for (int y=2;y<=4;y++){
			for(int x=2;x<=4;x++){
				otroZealot = ambiente.getParcela(new Coordenada(y,x)).getOcupante();
				Assert.assertTrue(unZealot.getClass()==otroZealot.getClass());
			}
		}
		
	}

}
	 


