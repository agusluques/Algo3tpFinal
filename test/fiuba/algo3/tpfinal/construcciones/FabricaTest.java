package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Golliat;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class FabricaTest {

	private Fabrica fabrica;

	@Test
	public void debeTener1250DeVida() throws ConstruccionRequeridaInexistente {
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getVida() == 1250);

	}

	@Test
	public void debeTardar12TurnosEnCrearse()
			throws ConstruccionRequeridaInexistente {
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getTiempoRestante() == 12);
	}

	@Test
	public void debeCostar200MineralesY100DeGas()
			throws ConstruccionRequeridaInexistente {
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getCosto().getMinerales() == 200);
		Assert.assertTrue(this.fabrica.getCosto().getGas() == 100);
	}

	@Test
	public void dosFabricasDeberianSerIguales() {
		this.fabrica = new Fabrica();
		Constructible otraFabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.equals(otraFabrica));
	}

	@Test
	public void siPongoAConstruirUnGolliatNoOcupaPoblacionHastaQueEstaTerminado()
			throws Exception {
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnUltimaBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.fabrica, new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.fabrica.fabricarGolliat();

		Assert.assertTrue(jugador.contarPoblacion() == 1);
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siFabricoUnGolliatCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion()
			throws Throwable {
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		Barraca barraca = new Barraca();
		jugador.construir(barraca, new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		for (int x = 0; x < 5; x++) {
			barraca.fabricarMarine();
			for (int i = 0; i < 10; i++) {
				barraca.pasarTurno();
			}
		}
		jugador.construir(this.fabrica, new Coordenada(2, 2));
		for (int i = 0; i < 13; i++) {
			jugador.pasarTurno();
		}
		this.fabrica.fabricarGolliat();
		for (int i = 0; i < 6; i++) {
			this.fabrica.pasarTurno();
		}
	}

	@Test
	public void siFabricoUnMarineCuandoEstaTerminadoAumentaLaPoblacion()
			throws Exception {
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.fabrica, new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.fabrica.fabricarGolliat();
		for (int i = 0; i < 7; i++) {
			this.fabrica.pasarTurno();
		}
		Assert.assertTrue(jugador.contarPoblacion() == 3);

	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		this.fabrica = new Fabrica();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, this.fabrica.rangoDeAtaqueCorrespondiente(rango));
	}

	@Test
	public void siPongoAFabricar3GolliatsAlMismoTiempoCada6TurnosApareceUno()
			throws Throwable {
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		Barraca barraca = new Barraca();
		// Construyo una barraca y un deposito de suministros
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		jugador.construir(barraca, new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		// Construyo una fabrica
		jugador.construir(this.fabrica, new Coordenada(2, 2));
		for (int i = 0; i < 13; i++) {
			jugador.pasarTurno();
		}
		// Pone a fabricar 3 golliats
		for (int x = 0; x < 3; x++) {
			this.fabrica.fabricarGolliat();
		}

		for (int y = 1; y <= 3; y++) {
			int cantidadDeGolliats = 0;

			// Pasa 6 turnos asi se termina el primer golliat
			for (int x = 0; x < 6; x++) {
				this.fabrica.pasarTurno();
			}

			// Busco cuantos golliats tiene el jugador
			for (Atacable unidad : jugador.getUnidades()) {
				if (unidad.getClass() == (new Golliat().getClass())) {
					cantidadDeGolliats++;
				}
			}
			// Es siempre un marine mas que la cantidad que construyo porque el
			// jugador terran empieza
			// con un marine como unidad basica
			Assert.assertTrue(cantidadDeGolliats == y);
		}

	}
}
