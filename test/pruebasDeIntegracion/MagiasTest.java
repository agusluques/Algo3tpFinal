package pruebasDeIntegracion;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Protoss;
import fiuba.algo3.tpfinal.modelo.unidades.AltoTemplario;
import fiuba.algo3.tpfinal.modelo.unidades.Alucinacion;
import fiuba.algo3.tpfinal.modelo.unidades.Atacante;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.TormentaPsionica;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class MagiasTest {

	@Test
	public void leTiroUnEMPAUnaUnidadProtossLaMismaPierdeElEscudoYLaNavePierdeEnergia()
			throws Exception {
		// Creo el mapa, los jugador y las unidades correspondientes
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss jugador2 = new JugadorProtoss("Luciano", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable zealot = new Zealot();
		// Paso los turnos para que la nave gane energia
		for (int i = 1; i < 7; i++) {
			nave.pasarTurno();
		}
		// Le agrego una casa a cada jugador para que pueda asignarle las
		// unidades
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad((UnidadTerran) nave, new Coordenada(2, 2));
		jugador2.agregarUnidad((UnidadProtoss) zealot, new Coordenada(5, 5));

		nave.lanzarEMP(new Coordenada(4, 4));
		Assert.assertTrue(((Protoss) zealot).getCantidadDeEscudo() == 0);
		Assert.assertTrue(nave.getEnergia() == 10);

	}

	@Test
	public void tiroUnaEMPYLasUnidadesConEnergiaCercanasLaPierden()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss jugador2 = new JugadorProtoss("Luciano", mapa);
		Atacable templar = new AltoTemplario();
		NaveCiencia otraNave = new NaveCiencia();

		for (int i = 1; i < 7; i++) {
			otraNave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new Pilon());

		jugador.agregarUnidad((UnidadTerran) otraNave, new Coordenada(2, 3));

		jugador2.agregarUnidad((UnidadProtoss) templar, new Coordenada(3, 2));

		otraNave.lanzarEMP(new Coordenada(3, 3));

		Assert.assertTrue(otraNave.getEnergia() == 10);
		Assert.assertTrue(((AltoTemplario) templar).getEnergia() == 0);

	}

	@Test
	public void tiroUnEMPYLasUnidadesFueraDeRangoNoSufrenModificaciones()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		JugadorTerran jugador2 = new JugadorTerran("Luciano", mapa);
		Atacable zealot = new Zealot();
		Atacable templar = new AltoTemplario();
		NaveCiencia otraNave = new NaveCiencia();

		for (int i = 1; i < 7; i++) {
			otraNave.pasarTurno();
		}

		jugador.getConstrucciones().add(new Pilon());
		jugador2.getConstrucciones().add(new DepositoSuministro());

		jugador.agregarUnidad((UnidadProtoss) zealot, new Coordenada(4, 3));
		jugador.agregarUnidad((UnidadProtoss) templar, new Coordenada(3, 4));

		jugador2.agregarUnidad((UnidadTerran) otraNave, new Coordenada(1, 1));

		otraNave.lanzarEMP(new Coordenada(2, 2));

		Assert.assertTrue(((Zealot) zealot).getCantidadDeEscudo() == 60);
		Assert.assertTrue(((AltoTemplario) templar).getCantidadDeEscudo() == 40);
		Assert.assertTrue(((AltoTemplario) templar).getEnergia() == 50);

	}

	@Test
	public void siTiroUnEMPFueraDelRangoNoMeBajaLaEnergiaYNoLesHaceNadaALosDelRango()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss jugador2 = new JugadorProtoss("Luciano", mapa);
		Atacable templar = new AltoTemplario();
		NaveCiencia otraNave = new NaveCiencia();

		for (int i = 1; i < 7; i++) {
			otraNave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new Pilon());

		jugador.agregarUnidad((UnidadTerran) otraNave, new Coordenada(2, 3));

		jugador2.agregarUnidad((UnidadProtoss) templar, new Coordenada(3, 2));

		otraNave.lanzarEMP(new Coordenada(100, 3));

		Assert.assertTrue(otraNave.getEnergia() == 110);
		Assert.assertTrue(((AltoTemplario) templar).getEnergia() == 50);
	}

	@Test
	public void laTormentaPsionicaLeHaceDanioATodasLasUnidadesHostilesEnElArea()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss otroJugador = new JugadorProtoss("Luciano", mapa);
		Atacable golliat = new Golliat();
		Atacable golliat2 = new Golliat();
		Atacable golliat3 = new Golliat();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) golliat, new Coordenada(2, 2));
		jugador.agregarUnidad((UnidadTerran) golliat2, new Coordenada(3, 3));
		jugador.agregarUnidad((UnidadTerran) golliat3, new Coordenada(4, 4));

		TormentaPsionica tormenta = new TormentaPsionica(otroJugador, mapa,
				new Coordenada(3, 3));
		tormenta.pasarTurno();

		Assert.assertTrue(((Golliat) golliat).getVida() == 25);
		Assert.assertTrue(((Golliat) golliat2).getVida() == 25);
		Assert.assertTrue(((Golliat) golliat3).getVida() == 25);

	}

	@Test
	public void lasIlusionesSoloTienenVidaYNoEscudo() throws Exception,
			EnergiaInsuficiente {

		AltoTemplario altoTemplario = new AltoTemplario();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad(altoTemplario, new Coordenada(3, 3));
		jugador.agregarUnidad(zealot, new Coordenada(4, 4));
		for (int i = 0; i < 4; i++) {
			altoTemplario.pasarTurno();
		}

		altoTemplario.crearAlucinaciones(zealot);
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Alucinacion(zealot)).getClass()) {
				Assert.assertTrue(((Alucinacion) unidad).getCantidadDeVida() == 0);
				Assert.assertTrue(((Alucinacion) unidad).getCantidadDeEscudo() == 60);

			}
		}

	}

	@Test
	public void lasIlusionesNoHacenDanio() throws Exception,
			EnergiaInsuficiente {

		AltoTemplario altoTemplario = new AltoTemplario();
		Dragon dragon = new Dragon();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		JugadorProtoss otroJugador = new JugadorProtoss("Luciano", mapa);

		jugador.getConstrucciones().add(new Pilon());
		otroJugador.getConstrucciones().add(new Pilon());

		jugador.agregarUnidad(altoTemplario, new Coordenada(1, 1));
		jugador.agregarUnidad(dragon, new Coordenada(1, 3));
		otroJugador.agregarUnidad(zealot, new Coordenada(2, 2));

		for (int i = 0; i < 4; i++) {
			altoTemplario.pasarTurno();
		}

		altoTemplario.crearAlucinaciones(dragon);

		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Alucinacion(dragon)).getClass()) {
				((Atacante) unidad).atacar(zealot);
			}
		}

		Assert.assertTrue(zealot.getCantidadDeEscudo() == 60);
		Assert.assertTrue(zealot.getCantidadDeVida() == 100);
	}

	@Test
	public void tiroUnEMPLasAlucinacionesMueren() throws Exception {
		int cantidadAlucinaciones = 0;
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		JugadorTerran jugador2 = new JugadorTerran("Luciano", mapa);
		UnidadProtoss zealot = new Zealot();
		AltoTemplario templar = new AltoTemplario();
		NaveCiencia otraNave = new NaveCiencia();

		for (int i = 1; i < 7; i++) {
			templar.pasarTurno();
			otraNave.pasarTurno();
		}

		jugador.getConstrucciones().add(new Pilon());
		jugador2.getConstrucciones().add(new DepositoSuministro());

		jugador.agregarUnidad((UnidadProtoss) zealot, new Coordenada(1, 2));
		jugador.agregarUnidad((UnidadProtoss) templar, new Coordenada(1, 1));
		jugador2.agregarUnidad((UnidadTerran) otraNave, new Coordenada(3, 3));

		templar.crearAlucinaciones(zealot);
		// Chequeo primero que las alucinaciones se hayan creado
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Alucinacion(zealot)).getClass()) {
				cantidadAlucinaciones++;
			}
		}

		Assert.assertTrue(cantidadAlucinaciones == 1);

		// lanzo el EMP
		otraNave.lanzarEMP(new Coordenada(2, 2));
		// Chequeo que todas las alucinaciones esten muertas
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Alucinacion(zealot)).getClass()) {
				Assert.assertTrue(unidad.estaMuerto());
			}
		}

	}

}
