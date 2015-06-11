package pruebasDeIntegracion;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;

public class PoblacionTest {

	private Jugador jugador;
	private Mapa mapa;
	private Coordenada coordTierra, coordTierra2;

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un
		// mapa valido
		this.coordTierra = new Coordenada(2, 2);
		this.coordTierra2 = new Coordenada(3, 3);
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugador = new Jugador("Damian", this.mapa);

	}

	@Test
	public void elJugadorEmpiezaCon5ComoLimitePoblacional() {
		Assert.assertTrue(jugador.limitePoblacional() == 5);
	}

	@Test
	public void siElJugadorConstruyePilonesElLimitePoblacionalAUmentaEn5()
			throws ConstruccionRequeridaInexistente {

		jugador.construir(new Pilon(), coordTierra);
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.limitePoblacional() == 10);
		jugador.construir(new Pilon(), coordTierra2);
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();

		}
		Assert.assertTrue(jugador.limitePoblacional() == 15);

	}

	public void aunqueElJugadorConstruyaMuchosPilonesSuLimitePoblacionalNoPasaDe200()
			throws ConstruccionRequeridaInexistente {
		for (int x = 0; x < 39; x++) {
			jugador.construir(new Pilon(), coordTierra);
			for (int i = 0; i < 5; i++) {
				jugador.pasarTurno();
			}
		}

		Assert.assertEquals(200, jugador.limitePoblacional());

		for (int x = 0; x < 5; x++) {
			jugador.construir(new Pilon(), coordTierra);
			for (int i = 0; i < 5; i++) {
				jugador.pasarTurno();
			}
		}

		Assert.assertEquals(200, jugador.limitePoblacional());
	}

	@Test
	public void siElJugadorTiene2MarinesSuPoblacionEsDos()
			throws ConstruccionRequeridaInexistente {

		jugador.agregarUnidad(new Marine(), new Coordenada(1, 1));
		jugador.agregarUnidad(new Marine(), new Coordenada(1, 2));
		Assert.assertTrue(jugador.contarPoblacion() == 2);
	}

	@Test
	public void siElJugadorTieneUnMarineYSeLoMatanSuPoblacionVuelveACero()
			throws ConstruccionRequeridaInexistente {
		Marine marine = new Marine();
		jugador.agregarUnidad(marine, new Coordenada(1, 1));
		jugador.pasarTurno();

		Marine enemigo = new Marine();
		while (!marine.estaMuerto()) {
			enemigo.atacar(marine);
		}

		jugador.empezarTurno();

		Assert.assertEquals(0, jugador.contarPoblacion());

	}

	@Test
	public void siElJugadorTieneUnDepositoYSeLoMatanSuPoblacionLimiteVuelveACinco()
			throws ConstruccionRequeridaInexistente {
		DepositoSuministro deposito = new DepositoSuministro();
		jugador.construir(deposito, coordTierra);
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();

		Marine enemigo = new Marine();
		while (!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugador.empezarTurno();

		Assert.assertEquals(5, jugador.limitePoblacional());
		Assert.assertFalse(jugador.getConstrucciones().contains(deposito));
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siIntentoFabricarUnidadesYMePasoDelLimiteLanzaExcepcion() {

		for (int i = 0; i < 6; i++) {
			jugador.agregarUnidad(new Marine(), new Coordenada(1, i + 1));
		}

	}

}
