package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class PuertoEstelarTerranTest {

	private PuertoEstelarTerran puertoEstelar;

	@Test
	public void debeTener1300DeVida() throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getVida() == 1300);

	}

	@Test
	public void debeTardar10TurnosEnCrearse()
			throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getTiempoRestante() == 10);
	}

	@Test
	public void debeCostar150MineralesY100DeGas()
			throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getCosto().getMinerales() == 150);
		Assert.assertTrue(this.puertoEstelar.getCosto().getGas() == 100);
	}

	@Test
	public void dosPuertosEstelaresDeberianSerIguales() {
		this.puertoEstelar = new PuertoEstelarTerran();
		Constructible otroPuerto = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.equals(otroPuerto));
	}

	@Test
	public void siPongoAConstruirUnEspectroNoOcupaPoblacionHastaQueEstaTerminado()
			throws Exception {
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();

		Assert.assertTrue(jugador.contarPoblacion() == 1);
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siFabricoUnEspectroCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion()
			throws Throwable {

		this.puertoEstelar = new PuertoEstelarTerran();
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
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();
		for (int i = 0; i < 8; i++) {
			this.puertoEstelar.pasarTurno();
		}
	}

	@Test
	public void siFabricoUnEspectroCuandoEstaTerminadoAumentaLaPoblacion()
			throws Exception {

		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();
		for (int i = 0; i < 8; i++) {
			this.puertoEstelar.pasarTurno();
		}
		Assert.assertTrue(jugador.contarPoblacion() == 3);
	}

	@Test
	public void siPongoAConstruirUnaNaveDeCienciaNoOcupaPoblacionHastaQueEstaTerminado()
			throws Exception {
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();

		Assert.assertTrue(jugador.contarPoblacion() == 1);
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siFabricoUnaNaveDeCienciaCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion()
			throws Throwable {

		this.puertoEstelar = new PuertoEstelarTerran();
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
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();
		for (int i = 0; i < 10; i++) {
			this.puertoEstelar.pasarTurno();
		}
	}

	@Test
	public void siFabricoUnaNaveDeCienciaCuandoEstaTerminadoAumentaLaPoblacion()
			throws Exception {

		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();
		for (int i = 0; i < 10; i++) {
			this.puertoEstelar.pasarTurno();
		}
		Assert.assertTrue(jugador.contarPoblacion() == 3);
	}

	@Test
	public void siPongoAConstruirUnaNaveDeTransporteNoOcupaPoblacionHastaQueEstaTerminado()
			throws Exception {
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();

		Assert.assertTrue(jugador.contarPoblacion() == 1);
	}

	@Test(expected = LimitePoblacionalAlcanzado.class)
	public void siFabricoUnaNaveDeTransporteCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion()
			throws Throwable {

		this.puertoEstelar = new PuertoEstelarTerran();
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
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i = 0; i < 10; i++) {
			this.puertoEstelar.pasarTurno();
		}
	}

	@Test
	public void siFabricoUnaNaveDeTransporteCuandoEstaTerminadoAumentaLaPoblacion()
			throws Exception {

		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4, 4));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2, 2));
		for (int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1, 1));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(), new Coordenada(6, 6));
		for (int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i = 0; i < 7; i++) {
			this.puertoEstelar.pasarTurno();
		}
		Assert.assertTrue(jugador.contarPoblacion() == 3);

	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		this.puertoEstelar = new PuertoEstelarTerran();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1,
				this.puertoEstelar.rangoDeAtaqueCorrespondiente(rango));
	}
}
