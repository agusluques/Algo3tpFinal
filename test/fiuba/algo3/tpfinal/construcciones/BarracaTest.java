package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class BarracaTest {

	private Barraca barraca;

	@Before
	public void arrange() {
		this.barraca = new Barraca();
	}

	@Test
	public void unaBarracaDebeTener1000DeVida() {
		Assert.assertTrue(this.barraca.getVida() == 1000);
	}

	@Test
	public void unaBarracaDebeCostar150Minerales() {
		Assert.assertTrue(this.barraca.getCosto().getMinerales() == 150);
	}

	@Test
	public void unaBarracaDebeCrearseEn12Turnos() {
		Assert.assertTrue(this.barraca.getTiempoRestante() == 12);
	}

	@Test
	public void dosBarracasDeberianSerIguales() {
		Constructible otraBarraca = new Barraca();
		Assert.assertTrue(this.barraca.equals(otraBarraca));
	}

	@Test
	public void siPongoAConstruirUnMarineNoOcupaPoblacionHastaQueEstaTerminado()
			throws Exception {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(this.barraca, new Coordenada(2, 2));
		jugador.construir(new DepositoSuministro(), new Coordenada(4, 4));
		((Barraca) this.barraca).fabricarMarine();

		Assert.assertTrue(jugador.contarPoblacion() == 1);
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siFabricoUnMarineCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion()
			throws Throwable {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(this.barraca, new Coordenada(2, 2));
		for (int x = 0; x < 6; x++) {
			((Barraca) this.barraca).fabricarMarine();
			for (int i = 0; i < 4; i++) {
				((Barraca) this.barraca).pasarTurno();
			}
		}
	}

	@Test
	public void siFabricoUnMarineCuandoEstaTerminadoAumentaLaPoblacion()
			throws Exception {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(barraca, new Coordenada(1, 1));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(1, 2));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		((Barraca) this.barraca).fabricarMarine();
		for (int i = 0; i < 4; i++) {
			((Barraca) this.barraca).pasarTurno();
		}
		Assert.assertTrue(jugador.contarPoblacion() == 2);
	}

	@Test
	public void siFabricoUnMarineApareceEnElMapaAlrededorDeLaBarraca()
			throws Exception {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(barraca, new Coordenada(1, 1));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(1, 2));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		((Barraca) this.barraca).fabricarMarine();
		for (int i = 0; i < 4; i++) {
			((Barraca) this.barraca).pasarTurno();
		}
		Atacable marine = mapa.getParcela(new Coordenada(2, 1)).getOcupante();
		Assert.assertTrue(marine.getClass() == (new Marine()).getClass());

	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);
		Assert.assertEquals(1, this.barraca.rangoDeAtaqueCorrespondiente(rango));
	}

	@Test
	public void siPongoAFabricar3MarinesAlMismoTiempoCada3TurnosSeTerminaUno()
			throws Throwable {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(this.barraca, new Coordenada(4, 4));
		// Termina la construccion de la barraca
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		// Pone a fabricar 3 marines
		for (int x = 0; x < 3; x++) {
			this.barraca.fabricarMarine();
		}

		for (int y = 1; y <= 3; y++) {
			int cantidadDeMarines = 0;

			// Pasa 3 turnos asi se termina el primer Marine
			for (int x = 0; x < 3; x++) {
				this.barraca.pasarTurno();
			}

			// Busco cuantos Marines tiene el jugador
			for (Atacable unidad : jugador.getUnidades()) {
				if (unidad.getClass() == (new Marine().getClass())) {
					cantidadDeMarines++;
				}
			}
			// Es siempre un marine mas que la cantidad que construyo porque el
			// jugador terran empieza
			// con un marine como unidad basica
			Assert.assertTrue(cantidadDeMarines == y + 1);
		}

	}

	@Test
	public void siPongoAFabricarMasDe6MarinesAlMismoTiempoSoloFabrica6()
			throws Throwable {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new DepositoSuministro(), new Coordenada(2, 2));
		jugador.construir(this.barraca, new Coordenada(4, 4));
		// Termina la construccion de la barraca
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		// Pone a fabricar 10 marines
		for (int x = 0; x < 10; x++) {
			this.barraca.fabricarMarine();
		}

		// Avanzo la fabricacion en la barraca 30 turnos (3 turnos por cada
		// marine que puse a fabricar
		for (int y = 1; y <= 30; y++) {
			this.barraca.pasarTurno();
		}
		int cantidadDeMarines = 0;
		// Busco cuantos Marines tiene el jugador
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Marine().getClass())) {
				cantidadDeMarines++;
			}
		}
		// Es siempre un marine mas que la cantidad que construyo porque el
		// jugador terran empieza
		// con un marine como unidad basica
		Assert.assertTrue(cantidadDeMarines == 7);

	}

	@Test
	public void siPongoAFabricarUnMarineCuandoEstoyAlLimiteDePoblacionElMismoSeTerminaDeFabricarCuandoCOnstruyoUnaCasa()
			throws Throwable {

		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(this.barraca, new Coordenada(4, 4));
		// Termina la construccion de la barraca
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		// Le agrego 4 marines al jugador para completar su poblacion
		for (int x = 0; x < 4; x++) {
			jugador.agregarUnidad(new Marine(), new Coordenada(4, 4));
		}

		// Pongo a fabricar un marine y dejo pasar turnos
		this.barraca.fabricarMarine();
		for (int x = 0; x < 6; x++) {
			jugador.pasarTurno();

		}

		int cantidadDeMarines = 0;
		// Chequeo que siga teniendo 5 marines
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Marine().getClass())) {
				cantidadDeMarines++;
			}
		}
		Assert.assertTrue(cantidadDeMarines == 5);

		// Construyo un deposito de suministros
		jugador.construir(new DepositoSuministro(), new Coordenada(7, 7));
		for (int i = 0; i < 7; i++) {
			jugador.pasarTurno();
		}

		cantidadDeMarines = 0;
		// Compruebo que el ultimo marine se termino de fabricar
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Marine().getClass())) {
				cantidadDeMarines++;
			}
		}
		Assert.assertTrue(cantidadDeMarines == 6);
	}
}
