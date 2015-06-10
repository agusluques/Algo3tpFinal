package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Rango;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class NexoMineralTest {

	private NexoMineral nexo;

	@Before
	public void arrange() {
		this.nexo = new NexoMineral(new Coordenada(1, 100));
	}

	@Test
	public void unNexoDebeTener250DeVidaInicial() {
		Assert.assertTrue(this.nexo.getVida() == 250);
	}

	@Test
	public void unNexoDebeTener250DeEscudoInicial() {
		Assert.assertTrue(this.nexo.getEscudo() == 250);
	}

	@Test
	public void unNexoDebeCostar50Minerales() {
		Assert.assertTrue(this.nexo.getCostoMineral() == 50);
	}

	@Test
	public void unNexoDebeCostar0Gases() {
		Assert.assertTrue(this.nexo.getCostoGas() == 0);
	}

	@Test
	public void unNexoDebeCrearseEn4Turnos() {
		Assert.assertTrue(this.nexo.getTiempoRestante() == 4);
	}

	@Test
	public void siAtacanUnNexoCon100LaVidaQuedaIntactaYElEscudoEn150() {
		Danio danio = new Danio(0, 100);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 150);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon250LaVidaQuedaIntactaYElEscudoEn0() {
		Danio danio = new Danio(0, 250);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 250 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon300LaVidaQuedaEn200YElEscudoEn0() {
		Danio danio = new Danio(0, 300);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 200 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon600LaVidaQuedaEn0YElEscudoEn0() {
		Danio danio = new Danio(0, 600);
		nexo.atacado(danio);
		boolean resultado = (nexo.getVida() == 0 && nexo.getEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void dosNexosDeberianSerIguales() {
		Constructible otroNexo = new NexoMineral(new Coordenada(1, 99));
		Assert.assertTrue(this.nexo.equals(otroNexo));
	}

	@Test
	public void siPasaTurnoLeCargaMineralAlJugadorYLaVidaQuedaIgual()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Zealot zealot = new Zealot();
		zealot.setCoordenada(new Coordenada(2, 91));

		zealot.atacar(nexo);
		nexo.pasarTurno(jugador, mapa);

		Assert.assertEquals(250, nexo.getEscudo());
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(1, this.nexo.rangoDeAtaqueCorrespondiente(rango));
	}

}
