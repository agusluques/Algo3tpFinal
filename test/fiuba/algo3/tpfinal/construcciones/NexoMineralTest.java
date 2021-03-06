package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Constructible;
import fiuba.algo3.tpfinal.modelo.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class NexoMineralTest {

	private NexoMineral nexo;

	@Before
	public void arrange() {
		this.nexo = new NexoMineral();
		nexo.setCoordenada(new Coordenada(1, 100));
	}

	@Test
	public void unNexoDebeTener250DeVidaInicial() {
		Assert.assertTrue(this.nexo.getCantidadDeVida() == 250);
	}

	@Test
	public void unNexoDebeTener250DeEscudoInicial() {
		Assert.assertTrue(this.nexo.getCantidadDeEscudo() == 250);
	}

	@Test
	public void unNexoDebeCostar50Minerales() {
		Assert.assertTrue(this.nexo.getCosto().getMinerales() == 50);
	}

	@Test
	public void unNexoDebeCostar0Gases() {
		Assert.assertTrue(this.nexo.getCosto().getGas() == 0);
	}

	@Test
	public void unNexoDebeCrearseEn4Turnos() {
		Assert.assertTrue(this.nexo.getTiempoRestante() == 4);
	}

	@Test
	public void siAtacanUnNexoCon100LaVidaQuedaIntactaYElEscudoEn150() {
		Danio danio = new Danio(0, 100);
		nexo.atacado(danio);
		boolean resultado = (nexo.getCantidadDeVida() == 250 && nexo.getCantidadDeEscudo() == 150);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon250LaVidaQuedaIntactaYElEscudoEn0() {
		Danio danio = new Danio(0, 250);
		nexo.atacado(danio);
		boolean resultado = (nexo.getCantidadDeVida() == 250 && nexo.getCantidadDeEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon300LaVidaQuedaEn200YElEscudoEn0() {
		Danio danio = new Danio(0, 300);
		nexo.atacado(danio);
		boolean resultado = (nexo.getCantidadDeVida() == 200 && nexo.getCantidadDeEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void siAtacanUnNexoCon600LaVidaQuedaEn0YElEscudoEn0() {
		Danio danio = new Danio(0, 600);
		nexo.atacado(danio);
		boolean resultado = (nexo.getCantidadDeVida() == 0 && nexo.getCantidadDeEscudo() == 0);
		Assert.assertTrue(resultado);
	}

	@Test
	public void dosNexosDeberianSerIguales() {
		Constructible otroNexo = new NexoMineral();
		((NexoMineral) otroNexo).setCoordenada(new Coordenada(1, 99));
		Assert.assertTrue(this.nexo.equals(otroNexo));
	}

	@Test
	public void siPasaTurnoLeCargaMineralAlJugadorYLaVidaQuedaIgual()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		Zealot zealot = new Zealot();
		zealot.setCoordenada(new Coordenada(2, 91));
		nexo.setJugador(jugador);
		zealot.atacar(nexo);
		nexo.pasarTurno();

		Assert.assertEquals(250, nexo.getCantidadDeEscudo());
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, this.nexo.rangoDeAtaqueCorrespondiente(rango));
	}

}
