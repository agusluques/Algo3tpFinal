package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Asimilador;
import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class AsimiladorTest {

	private ConstruccionProtoss asimilador;

	@Before
	public void arrange() {
		this.asimilador = new Asimilador();
		asimilador.setCoordenada(new Coordenada(1, 90));
	}

	@Test
	public void unAsimiladorDebeTener450DeVidaInicial() {
		Assert.assertTrue(this.asimilador.getCantidadDeVida() == 450);
	}

	@Test
	public void unAsimiladorDebeTener450DeEscudoInicial() {
		Assert.assertTrue(this.asimilador.getCantidadDeEscudo() == 450);
	}

	@Test
	public void unAsimiladorDebeCostar100Minerales() {
		Assert.assertTrue(this.asimilador.getCosto().getMinerales() == 100);
	}

	@Test
	public void unAsimiladorDebeCostar0Gases() {
		Assert.assertTrue(this.asimilador.getCosto().getGas() == 0);
	}

	@Test
	public void unAsimiladorDebeCrearseEn6Turnos() {
		Assert.assertTrue(this.asimilador.getTiempoRestante() == 6);
	}

	@Test
	public void dosAsimiladoresDeberianSerIguales() {
		Asimilador otroAsimilador = new Asimilador();
		otroAsimilador.setCoordenada(new Coordenada(6, 26));
		Assert.assertTrue(this.asimilador.equals(otroAsimilador));
	}

	@Test
	public void siPasaTurnoAumentaElEscudoYLeCargaGasAlJugador()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		Zealot zealot = new Zealot();
		zealot.setCoordenada(new Coordenada(0, 0));
		asimilador.setJugador(jugador);
		zealot.atacar(asimilador);
		asimilador.pasarTurno();
		Assert.assertEquals(450, asimilador.getCantidadDeEscudo());
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1,
				this.asimilador.rangoDeAtaqueCorrespondiente(rango));
	}

}
