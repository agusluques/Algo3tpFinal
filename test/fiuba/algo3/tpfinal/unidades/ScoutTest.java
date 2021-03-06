package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class ScoutTest {

	@Test
	public void siSeCreaUnScoutDebeTener150DeVidaY100DeEscudo() {
		Scout scout = new Scout();
		Assert.assertTrue(scout.getCantidadDeVida() == 150);
		Assert.assertTrue(scout.getCantidadDeEscudo() == 100);

	}

	@Test
	public void siAUnScoutLePegan110DebeTener140DeVida() {
		Scout scout = new Scout();
		Danio danio = new Danio(110, 0);
		scout.atacado(danio);
		Assert.assertTrue(scout.getCantidadDeVida() == 140);
	}

	@Test
	public void siAUnScoutLePegan110PorTierraNoLeBajanVidaNiEscudo() {
		Scout scout = new Scout();
		Danio danio = new Danio(0, 110);
		scout.atacado(danio);
		Assert.assertTrue(scout.getCantidadDeVida() == 150);
		Assert.assertTrue(scout.getCantidadDeEscudo() == 100);
	}

	@Test
	public void siAUnScoutLePegan800DebeTener0() {
		Scout scout = new Scout();
		Danio danio = new Danio(800, 0);
		scout.atacado(danio);
		Assert.assertTrue(scout.getCantidadDeVida() == 0);
	}

	@Test
	public void siUnScoutAtacaAOtroAlSegundoLeBajaElEscudoA86YNoBajaVida() {

		Scout unScout = new Scout();
		unScout.setCoordenada(new Coordenada(0, 0));
		Scout otroScout = new Scout();
		otroScout.setCoordenada(new Coordenada(0, 1));
		unScout.atacar(otroScout);
		Assert.assertTrue(otroScout.getCantidadDeVida() == 150);
		Assert.assertTrue(otroScout.getCantidadDeEscudo() == 86);

	}

	@Test
	public void unaScoutSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		Scout unidad = new Scout();

		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unScoutSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test
	public void unScoutSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unScoutNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unScoutNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unScoutNoSePuedeMoverAOtraCeldaSiEstaOcupada() throws Exception {
		Scout unidad = new Scout();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test
	public void unScoutSePuedeMoverAOtraTierraSiHayUnCamino() throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(7, 11);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test
	public void unScoutPuedeVolar() throws Exception {
		Scout unidad = new Scout();
		Mapa mapa = new Mapa("mapaTierra_1.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(15, 20);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Scout unidad = new Scout();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}
}
