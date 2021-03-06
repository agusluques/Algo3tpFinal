package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Constructible;
import fiuba.algo3.tpfinal.modelo.construcciones.Refineria;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class RefineriaTest {

	private Refineria refineria;

	@Before
	public void arrange() {
		this.refineria = new Refineria();
		refineria.setCoordenada(new Coordenada(1, 90));
	}

	@Test
	public void debeTenerVidaIgualA750() {
		Assert.assertTrue(this.refineria.getVida() == 750);
	}

	@Test
	public void debeTardar6TurnosEnCrearse() {
		Assert.assertTrue(this.refineria.getTiempoRestante() == 6);
	}

	@Test
	public void debeCostar100Minerales() {
		Assert.assertTrue(this.refineria.getCosto().getMinerales() == 100);
	}

	@Test
	public void dosRefineriasDeberianSerIguales() {
		Constructible otraRefineria = new Refineria();
		Assert.assertTrue(this.refineria.equals(otraRefineria));
	}

	@Test
	public void siPasaTurnoLeCargaGasAlJugadorYLaVidaQuedaIgual()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		Zealot zealot = new Zealot();
		zealot.setCoordenada(new Coordenada(1, 89));
		refineria.setJugador(jugador);
		zealot.atacar(refineria);
		refineria.pasarTurno();

		Assert.assertEquals(742, refineria.getVida());
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1,
				this.refineria.rangoDeAtaqueCorrespondiente(rango));
	}
}
