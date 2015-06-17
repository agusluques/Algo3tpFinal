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

public class DragonTest {

	@Test
	public void siSeCreaUnDragonDebeTener100DeVidaY80DeEscudo() {
		Dragon dragon = new Dragon();
		Assert.assertTrue(dragon.getVida() == 100);
		Assert.assertTrue(dragon.getEscudo() == 80);

	}

	@Test
	public void siAUnDragonLePegan110DebeTener70DeVida() {
		Dragon dragon = new Dragon();
		Danio danio = new Danio(0, 110);
		dragon.atacado(danio);
		Assert.assertTrue(dragon.getVida() == 70);
	}

	@Test
	public void siAUnDragonLePegan800DebeTener0() {
		Dragon dragon = new Dragon();
		Danio danio = new Danio(0, 800);
		dragon.atacado(danio);
		Assert.assertTrue(dragon.getVida() == 0);
	}

	@Test
	public void siUnDragonAtacaAOtroAlSegundoLeBajaElEscudoA80YNoBajaVida() {

		Dragon unDragon = new Dragon();
		unDragon.setCoordenada(new Coordenada(0, 0));
		Dragon otroDragon = new Dragon();
		otroDragon.setCoordenada(new Coordenada(0, 1));
		unDragon.atacar(otroDragon);
		Assert.assertTrue(otroDragon.getVida() == 100);
		Assert.assertTrue(otroDragon.getEscudo() == 60);

	}

	@Test
	public void unDragonSePuedeMoverEnLaTierraPeroNoEnAireNiMineralNiGas() {
		Dragon unidad = new Dragon();

		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unDragonSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Dragon unidad = new Dragon();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unDragonNoSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Dragon unidad = new Dragon();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unDragonNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		Dragon unidad = new Dragon();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unDragonNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Dragon unidad = new Dragon();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unDragonNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		Dragon unidad = new Dragon();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Dragon unidad = new Dragon();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
