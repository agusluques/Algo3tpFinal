package pruebasDeIntegracion;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;

public class PoblacionTest {

	private JugadorProtoss jugador;
	private JugadorTerran jugadorTerran;
	private Mapa mapa;
	private Coordenada coordTierra, coordTierra2;

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un
		// mapa valido
		this.coordTierra = new Coordenada(2, 2);
		this.coordTierra2 = new Coordenada(3, 3);
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugador = new JugadorProtoss("Damian", this.mapa);
		this.jugadorTerran = new JugadorTerran("Luciano", this.mapa);

	}

	@Test
	public void elJugadorEmpiezaCon5ComoLimitePoblacional() {
		Assert.assertTrue(jugador.limitePoblacional() == 5);
	}

	@Test
	public void siElJugadorConstruyePilonesElLimitePoblacionalAUmentaEn5()
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {

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

	@Test
	public void aunqueElJugadorConstruyaMuchosPilonesSuLimitePoblacionalNoPasaDe200()
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {
		jugador.getPresupuesto().agregarMineral(100000);
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 5; y++) {
				jugador.construir(new Pilon(), new Coordenada(y, x));
				for (int i = 0; i < 5; i++) {
					jugador.pasarTurno();
				}

			}

		}

		Assert.assertEquals(200, jugador.limitePoblacional());
		for (int x = 1; x <= 5; x++) {
			jugador.construir(new Pilon(), new Coordenada(13, x));
			for (int i = 0; i < 5; i++) {
				jugador.pasarTurno();
			}
		}

		Assert.assertEquals(200, jugador.limitePoblacional());
	}

	@Test
	public void siElJugadorTiene2MarinesSuPoblacionEsDos()
			throws ConstruccionRequeridaInexistente, LimitePoblacionalAlcanzado, ParcelaOcupada {
		jugadorTerran.inicializarEnPrimeraBase();
		jugadorTerran.agregarUnidad(new Marine(), new Coordenada(1, 1));
		jugadorTerran.agregarUnidad(new Marine(), new Coordenada(1, 2));
		Assert.assertTrue(jugadorTerran.contarPoblacion() == 3);
	}

	@Test
	public void siElJugadorTieneUnMarineYSeLoMatanSuPoblacionVuelveACero()
			throws ConstruccionRequeridaInexistente, LimitePoblacionalAlcanzado, ParcelaOcupada {
		jugadorTerran.inicializarEnPrimeraBase();
		Marine marine = new Marine();
		jugadorTerran.agregarUnidad(marine, new Coordenada(1, 1));
		jugadorTerran.pasarTurno();

		Marine enemigo = new Marine();
		enemigo.setCoordenada(new Coordenada(0, 0));
		while (!marine.estaMuerto()) {
			enemigo.atacar(marine);
		}

		jugadorTerran.empezarTurno();

		Assert.assertEquals(1, jugadorTerran.contarPoblacion());

	}

	@Test
	public void siElJugadorTieneUnDepositoYSeLoMatanSuPoblacionLimiteVuelveACinco()
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {
		DepositoSuministro deposito = new DepositoSuministro();
		jugadorTerran.construir(deposito, coordTierra);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.pasarTurno();

		Marine enemigo = new Marine();
		enemigo.setCoordenada(new Coordenada(0, 0));
		while (!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugadorTerran.empezarTurno();

		Assert.assertEquals(5, jugadorTerran.limitePoblacional());
		Assert.assertFalse(jugadorTerran.getConstrucciones().contains(deposito));
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siIntentoFabricarUnidadesYMePasoDelLimiteLanzaExcepcion() throws LimitePoblacionalAlcanzado, ParcelaOcupada {

		for (int i = 0; i < 6; i++) {
			jugadorTerran.agregarUnidad(new Marine(), new Coordenada(1, i + 1));
		}

	}

}
