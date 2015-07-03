package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.Atacable;
import fiuba.algo3.tpfinal.modelo.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.Radiacion;
import fiuba.algo3.tpfinal.modelo.unidades.UnidadTerran;

public class RadiacionTest {

	@Test
	public void siIrradioUnaUnidadLaMismaPierde30DeVidaPorTurno()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		Atacable marine = new Marine();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) marine, new Coordenada(3, 3));
		Radiacion unaRadiacion = new Radiacion(marine);
		unaRadiacion.pasarTurno();

		Assert.assertTrue(((Marine) marine).getVida() == 10);

	}

	@Test
	public void siIrradioUnaUnidadSusAliadasCercanasTambienSufranDanio()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		Atacable marine = new Marine();
		Atacable marine2 = new Marine();
		Atacable marine3 = new Marine();

		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((UnidadTerran) marine, new Coordenada(3, 3));
		jugador.agregarUnidad((UnidadTerran) marine2, new Coordenada(2, 3));
		jugador.agregarUnidad((UnidadTerran) marine3, new Coordenada(3, 2));

		Radiacion unaRadiacion = new Radiacion(marine);
		unaRadiacion.pasarTurno();
		Assert.assertTrue(((Marine) marine2).getVida() == 10);
		Assert.assertTrue(((Marine) marine3).getVida() == 10);

	}

	@Test
	public void siUnaUnidadIrradiadaEstaCercaDeUnaUnidadHostilLaSegundaNoSufreDanio()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran unJugador = new JugadorTerran("Damian", mapa);
		JugadorTerran otroJugador = new JugadorTerran("Luciano", mapa);
		Atacable unMarine = new Marine();
		Atacable otroMarine = new Marine();

		unJugador.getConstrucciones().add(new DepositoSuministro());
		otroJugador.getConstrucciones().add(new DepositoSuministro());

		unJugador.agregarUnidad((UnidadTerran) unMarine, new Coordenada(3, 3));
		otroJugador.agregarUnidad((UnidadTerran) otroMarine, new Coordenada(2,
				3));

		Radiacion unaRadiacion = new Radiacion(unMarine);
		unaRadiacion.pasarTurno();

		Assert.assertTrue(((Marine) unMarine).getVida() == 10);
		Assert.assertTrue(((Marine) otroMarine).getVida() == 40);

	}
}
