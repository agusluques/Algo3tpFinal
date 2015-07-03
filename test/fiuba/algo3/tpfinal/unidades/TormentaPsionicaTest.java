package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.Golliat;
import fiuba.algo3.tpfinal.modelo.unidades.Scout;
import fiuba.algo3.tpfinal.modelo.unidades.TormentaPsionica;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;

public class TormentaPsionicaTest {

	@Test
	public void siPongoUnaTormentaPsionicaLaMismaHace100DeDanioPorTurno()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss otroJugador = new JugadorProtoss("Luciano", mapa);
		Atacable golliat = new Golliat();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) golliat, new Coordenada(3, 3));

		TormentaPsionica tormenta = new TormentaPsionica(otroJugador, mapa,
				new Coordenada(4, 4));
		tormenta.pasarTurno();

		Assert.assertTrue(((Golliat) golliat).getVida() == 25);

	}

	@Test
	public void siUnaUnidadConMenosDe200DeVidaPermaneceEnLaTormentaPorMasDe2TurnosLaMismaMuere()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		JugadorProtoss otroJugador = new JugadorProtoss("Luciano", mapa);
		Atacable golliat = new Golliat();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) golliat, new Coordenada(3, 3));

		TormentaPsionica tormenta = new TormentaPsionica(otroJugador, mapa,
				new Coordenada(4, 4));
		tormenta.pasarTurno();
		tormenta.pasarTurno();

		Assert.assertTrue(golliat.estaMuerto());

	}

	@Test
	public void unaTormentaNoHaceMasDanioDespuesDe2Turnos() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		JugadorProtoss otroJugador = new JugadorProtoss("Luciano", mapa);
		Atacable scout = new Scout();

		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad((UnidadProtoss) scout, new Coordenada(3, 3));

		TormentaPsionica tormenta = new TormentaPsionica(otroJugador, mapa,
				new Coordenada(4, 4));
		for (int i = 1; i <= 3; i++) {
			tormenta.pasarTurno();
		}

		Assert.assertTrue(((Scout) scout).getCantidadDeVida() == 50);

	}

	@Test
	public void siUnaUnidadAliadaEstaEncimaDeUnaTormentaNoRecibeDanio()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		Atacable golliat = new Golliat();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) golliat, new Coordenada(3, 3));

		TormentaPsionica tormenta = new TormentaPsionica(jugador, mapa,
				new Coordenada(4, 4));
		tormenta.pasarTurno();

		Assert.assertTrue(((Golliat) golliat).getVida() == 125);

	}

}
