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

public class MarineTest {

	@Test
	public void siSeCreaUnMarineDebeTener40DeVida() {
		Marine marine = new Marine();
		Assert.assertTrue(marine.getVida() == 40);
	}

	@Test
	public void siAUnMarineLePegan30DebeTener10() {
		Marine marine = new Marine();
		Danio danio = new Danio(0, 30);
		marine.atacado(danio);
		Assert.assertTrue(marine.getVida() == 10);
	}

	@Test
	public void siAUnMarineLePegan60DebeTener0() {
		Marine marine = new Marine();
		Danio danio = new Danio(0, 60);
		marine.atacado(danio);
		Assert.assertTrue(marine.getVida() == 0);
	}

	@Test
	public void siUnMarineAtacaAOtroAlSegundoLeBajaLaVidaA36() {

		Marine unMarine = new Marine();
		unMarine.setCoordenada(new Coordenada(0,0));
		Marine otroMarine = new Marine();
		otroMarine.setCoordenada(new Coordenada(0,1));
		unMarine.atacar(otroMarine);
		Assert.assertTrue(otroMarine.getVida() == 34);
	}

	@Test
	public void siUnMarineAtacaAOtroDentroDelRangoLeSacaVida() {
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		unMarine.setCoordenada(new Coordenada(5, 4));
		otroMarine.setCoordenada(new Coordenada(7, 6));

		unMarine.atacar(otroMarine);
		Assert.assertTrue(otroMarine.getVida() == 34);

	}

	@Test
	public void siUnMarineAtacaAOtroFueraDelRangoNoLeSacaVida() {
		Marine unMarine = new Marine();
		Marine otroMarine = new Marine();
		unMarine.setCoordenada(new Coordenada(5, 4));
		otroMarine.setCoordenada(new Coordenada(7, 8));

		unMarine.atacar(otroMarine);

		Assert.assertTrue(otroMarine.getVida() == 40);

	}

	@Test
	public void unMarineSePuedeMoverEnLaTierraPeroNoEnAireNiMineralNiGas() {
		Marine unidad = new Marine();

		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unMarineSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Marine unidad = new Marine();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unMarineNoSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Marine unidad = new Marine();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unMarineNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		Marine unidad = new Marine();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unMarineNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Marine unidad = new Marine();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unMarineNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		Marine unidad = new Marine();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Marine unidad = new Marine();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
