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

public class GolliatTest {

	@Test
	public void siSeCreaUnGolliatDebeTener125DeVida() {
		Golliat golliat = new Golliat();
		Assert.assertTrue(golliat.getVida() == 125);
	}

	@Test
	public void siAUnGolliatLePegan100DebeTener25() {
		Golliat golliat = new Golliat();
		Danio danio = new Danio(0, 100);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 25);
	}

	@Test
	public void siAUnGolliatLePegan800DebeTener0() {
		Golliat golliat = new Golliat();
		Danio danio = new Danio(0, 800);
		golliat.atacado(danio);
		Assert.assertTrue(golliat.getVida() == 0);
	}

	@Test
	public void siUnGolliatAtacaAOtroAlSegundoLeBajaLaVidaA113() {

		Golliat unGolliat = new Golliat();
		Golliat otroGolliat = new Golliat();
		unGolliat.atacar(otroGolliat);
		Assert.assertTrue(otroGolliat.getVida() == 113);
	}

	@Test
	public void unGolliatSePuedeMoverEnLaTierraPeroNoEnAireNiMineralNiGas() {
		Golliat unidad = new Golliat();

		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unGolliatSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Golliat unidad = new Golliat();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unGolliatNoSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Golliat unidad = new Golliat();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unGolliatNoSePuedeMoverAOtraCeldaSiHayMineral()
			throws Exception {
		Golliat unidad = new Golliat();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unGolliatNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Golliat unidad = new Golliat();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unGolliatNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		Golliat unidad = new Golliat();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Golliat unidad = new Golliat();
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(1, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
