package pruebasDeIntegracion;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Barraca;
import fiuba.algo3.tpfinal.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Juego;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;

public class JuegoTest {

	@Before
	public void arrange() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugadorUno = new JugadorTerran("Pablo", mapa);
		JugadorTerran jugadorDos = new JugadorTerran("Nico", mapa);
		Juego juego = new Juego(jugadorUno, jugadorDos, mapa);

		ConstruccionTerran centroMineral = new CentroDeMineral();
		ConstruccionTerran barraca = new Barraca();
		jugadorUno.construir(centroMineral, new Coordenada(1, 91));
		jugadorUno.construir(barraca, new Coordenada(20, 92));

		juego.pasarTurno(jugadorUno);

		ConstruccionTerran centroMineralDos = new CentroDeMineral();
		ConstruccionTerran barracaDos = new Barraca();
		jugadorDos.construir(centroMineralDos, new Coordenada(75, 23));
		jugadorDos.construir(barracaDos, new Coordenada(67, 27));

		juego.pasarTurno(jugadorDos);

		Assert.assertTrue(jugadorUno.getPresupuesto().cantidadDeMineral() == 0);
		Assert.assertTrue(jugadorDos.getPresupuesto().cantidadDeMineral() == 0);

		for (int i = 0; i < 4; i++) {
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(jugadorUno.getPresupuesto().cantidadDeMineral() == 10);
		Assert.assertTrue(jugadorDos.getPresupuesto().cantidadDeMineral() == 10);

		for (int i = 0; i < 7; i++) {
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(jugadorUno.getPresupuesto().cantidadDeMineral() == 80);
		Assert.assertTrue(jugadorDos.getPresupuesto().cantidadDeMineral() == 80);

		((Barraca) barraca).fabricarMarine();
		((Barraca) barracaDos).fabricarMarine();

		for (int i = 0; i < 3; i++) {
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		UnidadTerran marineJugadorUno = (UnidadTerran) jugadorUno.getUnidades()
				.get(1);
		UnidadTerran primerMarineAtacado = (UnidadTerran) jugadorDos
				.getUnidades().get(0);
		UnidadTerran segundoMarineAtacado = (UnidadTerran) jugadorDos
				.getUnidades().get(1);

		// posiciono el marine del jugadorUno al lado de marine a atacar
		Coordenada coordPrimerMarineAtacado = new Coordenada(
				primerMarineAtacado.getCoordenada().getFila() + 1,
				primerMarineAtacado.getCoordenada().getColumna() + 2);

		marineJugadorUno.trasladarA(coordPrimerMarineAtacado, mapa);

		for (int i = 0; i < 6; i++) {
			marineJugadorUno.atacar(primerMarineAtacado);
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(primerMarineAtacado.estaMuerto() == false);
		Assert.assertTrue(primerMarineAtacado.getVida() == 4);

		marineJugadorUno.atacar(primerMarineAtacado);
		Assert.assertTrue(primerMarineAtacado.estaMuerto() == true);
		Assert.assertTrue(primerMarineAtacado.getVida() == 0);
		Assert.assertTrue(jugadorDos.getUnidades().size() == 2);

		juego.pasarTurno(jugadorUno);
		Assert.assertTrue(jugadorDos.getUnidades().size() == 1);

		// posiciono el marine del jugadorUno al lado de marine a atacar
		Coordenada coordSegundoMarineAtacado = new Coordenada(
				segundoMarineAtacado.getCoordenada().getFila() + 1,
				segundoMarineAtacado.getCoordenada().getColumna() - 2);

		marineJugadorUno.trasladarA(coordSegundoMarineAtacado, mapa);

		for (int i = 0; i < 6; i++) {
			marineJugadorUno.atacar(segundoMarineAtacado);
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(segundoMarineAtacado.estaMuerto() == false);
		Assert.assertTrue(segundoMarineAtacado.getVida() == 4);

		marineJugadorUno.atacar(segundoMarineAtacado);
		Assert.assertTrue(segundoMarineAtacado.estaMuerto() == true);
		Assert.assertTrue(segundoMarineAtacado.getVida() == 0);
		Assert.assertTrue(jugadorDos.getUnidades().size() == 1);

		juego.pasarTurno(jugadorUno);
		Assert.assertTrue(jugadorDos.getUnidades().size() == 0);

		// posiciono el marine del jugadorUno al lado del centro de mineral del
		// dos
		Coordenada coordCentroMin = new Coordenada(centroMineralDos
				.getCoordenada().getFila() + 1, centroMineralDos
				.getCoordenada().getColumna() - 2);

		marineJugadorUno.trasladarA(coordCentroMin, mapa);

		for (int i = 0; i < 83; i++) {
			marineJugadorUno.atacar(centroMineralDos);
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(centroMineralDos.estaMuerto() == false);
		Assert.assertTrue(centroMineralDos.getVida() == 2);

		marineJugadorUno.atacar(centroMineralDos);
		Assert.assertTrue(centroMineralDos.estaMuerto() == true);
		Assert.assertTrue(centroMineralDos.getVida() == 0);
		Assert.assertTrue(jugadorDos.getConstrucciones().size() == 2);

		juego.pasarTurno(jugadorUno);
		Assert.assertTrue(jugadorDos.getConstrucciones().size() == 1);

		// posiciono el marine del jugadorUno al lado de la barraca del dos
		Coordenada coordBarraca = new Coordenada(barracaDos.getCoordenada()
				.getFila() + 1, barracaDos.getCoordenada().getColumna() - 2);

		marineJugadorUno.trasladarA(coordBarraca, mapa);

		for (int i = 0; i < 166; i++) {
			marineJugadorUno.atacar(barracaDos);
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}

		Assert.assertTrue(barracaDos.estaMuerto() == false);
		Assert.assertTrue(barracaDos.getVida() == 4);

		marineJugadorUno.atacar(barracaDos);
		Assert.assertTrue(barracaDos.estaMuerto() == true);
		Assert.assertTrue(barracaDos.getVida() == 0);
		Assert.assertTrue(jugadorDos.getConstrucciones().size() == 1);

		juego.pasarTurno(jugadorUno);
		Assert.assertTrue(jugadorDos.getConstrucciones().size() == 0);

	}

	@Test
	public void siElJugadorUnoDestruyeTodosLosEdificiosYUnidadesDelJugadorDosGanaJugadorUno() {
		
	}

}
