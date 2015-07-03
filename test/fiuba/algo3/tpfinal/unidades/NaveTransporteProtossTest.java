package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.modelo.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.unidades.Dragon;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class NaveTransporteProtossTest {

	@Test
	public void siSeCreaUnaNaveTransporteProtossDebeTener80DeVidaY60DeEscudo() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Assert.assertTrue(nave.getCantidadDeVida() == 80);
		Assert.assertTrue(nave.getCantidadDeEscudo() == 60);
	}

	@Test
	public void siAUnaNaveTransporteProtossLePegan100DebeTener40DeVida() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(100, 0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getCantidadDeVida() == 40);
	}

	@Test
	public void siAUnaNaveTransporteProtossLePegan800DebeTener0() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(800, 0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getCantidadDeVida() == 0);
	}

	@Test
	public void siUnDragonAtacaAUnaNaveTransporteProtossAlSegundoLeBajaElEscudoA40YNoBajaVida() {

		Dragon unDragon = new Dragon();
		unDragon.setCoordenada(new Coordenada(0, 0));
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		nave.setCoordenada(new Coordenada(0, 1));
		unDragon.atacar(nave);
		Assert.assertTrue(nave.getCantidadDeVida() == 80);
		Assert.assertTrue(nave.getCantidadDeEscudo() == 40);
	}

	@Test(expected = NoHayPasajerosEnLaNave.class)
	public void siQuieroDescenderLosPasajerosDeUnaNaveSinPasajerosLanzaExcpecion()
			throws NoHayPasajerosEnLaNave, ParcelaOcupada {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		nave.bajarPasajeros();
	}

	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();

		Assert.assertEquals(8, nave.getCapacidad());

	}

	@Test
	public void unaNaveConUnZealotTieneCapacidad6() throws Exception {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		nave.setJugador(jugador);
		
		Zealot zealot = new Zealot();
		mapa.insertarUnidad(new Coordenada(1, 1), zealot);
		zealot.setJugador(jugador);
		zealot.setCoordenada(new Coordenada(1, 1));
		nave.subirPasajero(zealot);

		Assert.assertEquals(6, nave.getCapacidad());
	}

	@Test
	public void unaNavePuedeSubir4Zealots() throws Exception {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		nave.setJugador(jugador);
		
		for (int i = 0; i < 4; i++) {
			Zealot zealot = new Zealot();
			mapa.insertarUnidad(new Coordenada(i + 1, i + 1), zealot);
			zealot.setJugador(jugador);
			zealot.setCoordenada(new Coordenada(i + 1, i + 1));
			nave.subirPasajero(zealot);
		}

		Assert.assertEquals(0, nave.getCapacidad());
	}

	@Test(expected = CapacidadInsuficiente.class)
	public void siUnaNaveIntentaSubir5ZealotsLanzaExcepcion() throws Exception {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		nave.setJugador(jugador);
		
		for (int i = 0; i < 5; i++) {
			Zealot zealot = new Zealot();
			mapa.insertarUnidad(new Coordenada(i + 1, i + 1), zealot);
			zealot.setJugador(jugador);
			zealot.setCoordenada(new Coordenada(i + 1, i + 1));
			nave.subirPasajero(zealot);
		}
	}

	@Test(expected = CapacidadInsuficiente.class)
	public void unaNaveNoPuedeSubirAOtraNaveAunqueEsteVacia() {
		NaveTransporteProtoss nave1 = new NaveTransporteProtoss();
		NaveTransporteProtoss nave2 = new NaveTransporteProtoss();

		nave1.subirPasajero(nave2);
	}

	@Test
	public void unaNaveTransporteSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();

		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unNaveTransporteProtossSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test
	public void unNaveTransporteProtossSePuedeMoverAOtraCeldaSiHayAire()
			throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiHayMineral()
			throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiHayGas()
			throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
