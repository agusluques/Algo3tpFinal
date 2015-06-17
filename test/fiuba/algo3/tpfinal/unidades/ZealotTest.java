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

public class ZealotTest {

	@Test
	public void siUnZealotRecibeDanioLeBajaElEscudo() {

		Zealot unZealot = new Zealot();
		Danio unDanio = new Danio(0, 30);
		unZealot.atacado(unDanio);
		Assert.assertTrue(unZealot.getEscudo() == 30);

	}

	@Test
	public void siUnZealotRecibeMasDe60DeDanioLeDestruyeElEscudoYLeBajaLaVida() {

		Zealot unZealot = new Zealot();
		Danio unDanio = new Danio(0, 70);
		unZealot.atacado(unDanio);
		Assert.assertTrue(unZealot.getEscudo() == 0);
		Assert.assertTrue(unZealot.getVida() == 90);

	}

	@Test
	public void siUnZealotAtacaAOtroAlSegundoLeBajaElEscudo() {

		Zealot unZealot = new Zealot();
		unZealot.setCoordenada(new Coordenada(0, 0));
		Zealot otroZealot = new Zealot();
		otroZealot.setCoordenada(new Coordenada(0, 1));
		unZealot.atacar(otroZealot);
		Assert.assertTrue(otroZealot.getEscudo() == 52);
	}

	@Test
	public void siUnZealotAtacaAOtroFueraDelRangoNoLeSacaEscudo() {
		Zealot unZealot = new Zealot();
		unZealot.setCoordenada(new Coordenada(0, 0));
		Zealot otroZealot = new Zealot();
		otroZealot.setCoordenada(new Coordenada(0, 1));
		unZealot.mover(2, 2);
		otroZealot.mover(3, 3);

		unZealot.atacar(otroZealot);

		Assert.assertTrue(otroZealot.getEscudo() == 60);
	}

	@Test
	public void unZealotSePuedeMoverEnLaTierraPeroNoEnAireNiMineralNiGas() {
		Zealot unidad = new Zealot();

		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unZealotSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		Zealot unidad = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unZealotNoSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		Zealot unidad = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unZealotNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		Zealot unidad = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unZealotNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		Zealot unidad = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unZealotNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		Zealot unidad = new Zealot();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Zealot unidad = new Zealot();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}