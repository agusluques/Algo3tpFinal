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
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.unidades.Espectro;
import fiuba.algo3.tpfinal.modelo.unidades.Marine;
import fiuba.algo3.tpfinal.modelo.unidades.NaveCiencia;
import fiuba.algo3.tpfinal.modelo.unidades.NaveTransporteTerran;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class NaveTransporteTerranTest {

	@Test
	public void siSeCreaUnaNaveTansporteTerranDebeTener150DeVida() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Assert.assertTrue(nave.getVida() == 150);
	}

	@Test
	public void siAUnaNaveTansporteTerranLePegan100DebeTener50() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(100, 0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 50);
	}

	@Test
	public void siAUnaNaveTansporteTerranLePegan800DebeTener0() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(800, 0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 0);
	}

	@Test
	public void siUnEspectroAtacaAUnaNaveTransporteTerranAlSegundoLeBajaLaVidaA130() {

		Espectro unEspectro = new Espectro();
		unEspectro.setCoordenada(new Coordenada(0, 0));
		NaveTransporteTerran nave = new NaveTransporteTerran();
		nave.setCoordenada(new Coordenada(0, 1));
		unEspectro.atacar(nave);
		Assert.assertTrue(nave.getVida() == 130);
	}

	@Test
	public void siUnaNaveCienciaAtacaAUnaNaveTransporteTerranAlSegundoNoLeBajaVida() {

		NaveCiencia naveUno = new NaveCiencia();
		naveUno.setCoordenada(new Coordenada(0, 0));
		NaveTransporteTerran naveDos = new NaveTransporteTerran();
		naveDos.setCoordenada(new Coordenada(0, 1));
		naveUno.atacar(naveDos);
		Assert.assertTrue(naveDos.getVida() == 150);
	}

	@Test(expected = NoHayPasajerosEnLaNave.class)
	public void unaNaveSinPasajerosQueTrataDedescenderLanzaExcepcion()
			throws NoHayPasajerosEnLaNave, ParcelaOcupada {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		nave.bajarPasajeros();

	}

	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteTerran nave = new NaveTransporteTerran();

		Assert.assertEquals(8, nave.getCapacidad());
	}

	@Test
	public void unaNaveConUnMarineTieneCapacidad7() throws Exception {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		nave.setJugador(jugador);

		Marine marine = new Marine();
		mapa.insertarUnidad(new Coordenada( 1,1), marine);
		marine.setJugador(jugador);
		marine.setCoordenada(new Coordenada(1, 1));
		nave.subirPasajero(marine);

		Assert.assertEquals(7, nave.getCapacidad());
	}

	@Test
	public void unaNavePuedeSubir8Marines() throws Exception {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		nave.setJugador(jugador);

		for (int i = 0; i < 8; i++) {
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(i + 1, i + 1), marine);
			marine.setJugador(jugador);
			marine.setCoordenada(new Coordenada(i + 1, i + 1));
			nave.subirPasajero(marine);
		}

		Assert.assertEquals(0, nave.getCapacidad());
	}

	@Test(expected = CapacidadInsuficiente.class)
	public void siUnaNaveIntentaSubir9MarinesLanzaExcepcion() throws Exception {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		nave.setJugador(jugador);

		for (int i = 0; i < 9; i++) {
			Marine marine = new Marine();
			mapa.insertarUnidad(new Coordenada(i + 1, i + 1), marine);
			marine.setJugador(jugador);
			marine.setCoordenada(new Coordenada(i + 1, i + 1));
			nave.subirPasajero(marine);
		}
	}

	@Test(expected = CapacidadInsuficiente.class)
	public void unaNaveNoPuedeSubirAOtraNaveAunqueEsteVacia() {
		NaveTransporteTerran nave1 = new NaveTransporteTerran();
		NaveTransporteTerran nave2 = new NaveTransporteTerran();

		nave1.subirPasajero(nave2);
	}

	@Test
	public void unaNaveTransporteSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveTransporteTerran unidad = new NaveTransporteTerran();

		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unNaveTransporteTerranSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test
	public void unNaveTransporteTerranSePuedeMoverAOtraCeldaSiHayAire()
			throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiHayMineral()
			throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiHayGas()
			throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
