package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public class EspectroTest {

	@Test
	public void siSeCreaUnEspectroDebeTener120DeVida() {
		Espectro espectro = new Espectro();
		Assert.assertTrue(espectro.getVida() == 120);
	}

	@Test
	public void siAUnEspectroLePegan100DebeTener20() {
		Espectro espectro = new Espectro();
		Danio danio = new Danio(100, 0);
		espectro.atacado(danio);
		Assert.assertTrue(espectro.getVida() == 20);
	}

	@Test
	public void siAUnEspectroLePegan800DebeTener0() {
		Espectro espectro = new Espectro();
		Danio danio = new Danio(800, 0);
		espectro.atacado(danio);
		Assert.assertTrue(espectro.getVida() == 0);
	}

	@Test
	public void siUnGolliatAtacaAUnEspectroAlSegundoLeBajaLaVidaA110() {

		Golliat unGolliat = new Golliat();
		Espectro unEspectro = new Espectro();
		unGolliat.atacar(unEspectro);
		Assert.assertTrue(unEspectro.getVida() == 110);
	}

	@Test
	public void unEspectroSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		Espectro unidad = new Espectro();

		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unEspectroSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Espectro unidad = new Espectro();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test
	public void unEspectroSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Espectro unidad = new Espectro();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unEspectroNoSePuedeMoverAOtraCeldaSiHayMineral()
			throws Exception {
		Espectro unidad = new Espectro();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unEspectroNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Espectro unidad = new Espectro();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unEspectroNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		Espectro unidad = new Espectro();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Espectro unidad = new Espectro();
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
