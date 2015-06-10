package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public class AltoTemplarioTest {

	@Test
	public void siSeCreaUnAltoTemplarioDebeTener40DeVidaY40DeEscudo() {
		AltoTemplario altoTemplario = new AltoTemplario();
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 40);

	}

	@Test
	public void siAUnAltoTemplarioLePegan50DebeTener30DeVida() {
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0, 50);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 30);
	}

	@Test
	public void siAUnAltoTemplarioLePegan800DebeTener0() {
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0, 800);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 0);
	}

	@Test
	public void siUnDragonAtacaAUnAltoTemplarioAlSegundoLeBajaElEscudoA20YNoBajaVida() {

		Dragon unDragon = new Dragon();
		AltoTemplario altoTemplario = new AltoTemplario();
		unDragon.atacar(altoTemplario);
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 20);

	}

	@Test(expected = EnergiaInsuficiente.class)
	public void siUnAltoTemplarioIntentaCrearAlucinacionesSinTenerEnergiaSuficienteLanzaUnaExcepcion()
			throws Exception {

		AltoTemplario altoTemplario = new AltoTemplario();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad(altoTemplario, new Coordenada(3, 3));
		jugador.agregarUnidad(zealot, new Coordenada(4, 4));
		altoTemplario.crearAlucinaciones(zealot);

	}

	@Test
	public void siUnAltoTemplarioCreaIlusionesLasMismasAparecenEnLasUnidadesDelJugador()
			throws Exception, EnergiaInsuficiente {

		AltoTemplario altoTemplario = new AltoTemplario();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		int cantidadDeAlucinaciones = 0;

		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad(altoTemplario, new Coordenada(3, 3));
		jugador.agregarUnidad(zealot, new Coordenada(4, 4));
		for (int i = 0; i < 4; i++) {
			altoTemplario.pasarTurno(jugador, mapa);
		}
		altoTemplario.crearAlucinaciones(zealot);
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Alucinacion(zealot)).getClass()) {
				cantidadDeAlucinaciones++;
			}
		}

		Assert.assertTrue(cantidadDeAlucinaciones == 2);

	}

	@Test
	public void unAltoTemplarioSePuedeMoverEnLaTierraPeroNoEnAireNiMineralNiGas() {
		AltoTemplario unidad = new AltoTemplario();

		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad
				.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}

	@Test
	public void unAltoTemplarioSePuedeMoverAUnaCeldaVecinaSiHayTierra()
			throws Exception {
		AltoTemplario unidad = new AltoTemplario();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		unidad.trasladarA(destino, mapa);

		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}

	@Test(expected = MovimientoInvalido.class)
	public void unAltoTemplarioNoSePuedeMoverAOtraCeldaSiHayAire()
			throws Exception {
		AltoTemplario unidad = new AltoTemplario();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 50);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unAltoTemplarioNoSePuedeMoverAOtraCeldaSiHayMineral()
			throws Exception {
		AltoTemplario unidad = new AltoTemplario();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 100);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unAltoTemplarioNoSePuedeMoverAOtraCeldaSiHayGas()
			throws Exception {
		AltoTemplario unidad = new AltoTemplario();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 51), unidad);
		Coordenada destino = new Coordenada(1, 90);
		unidad.trasladarA(destino, mapa);
	}

	@Test(expected = MovimientoInvalido.class)
	public void unAltoTemplarioNoSePuedeMoverAOtraCeldaSiEstaOcupada()
			throws Exception {
		AltoTemplario unidad = new AltoTemplario();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");

		mapa.insertarUnidad(new Coordenada(1, 1), unidad);
		Coordenada destino = new Coordenada(1, 2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		AltoTemplario unidad = new AltoTemplario();
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(1, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

	@Test(expected = EnergiaInsuficiente.class)
	public void siIntentoLanzarUnaTormentaCuandoNoTengoManaLanzaUnaExcepcion()
			throws Exception {

		AltoTemplario templar = new AltoTemplario();
		templar.lanzarTormentaPsionica(new Coordenada(3, 3));

	}

}
