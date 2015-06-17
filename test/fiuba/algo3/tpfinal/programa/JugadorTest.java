package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Marine;

public class JugadorTest {

	private JugadorProtoss jugadorProtoss;
	private JugadorTerran jugadorTerran;
	private Mapa mapa;
	private Coordenada coordTierra, coordTierra2, coordTierra3;

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un
		// mapa valido
		this.coordTierra = new Coordenada(2, 2);
		this.coordTierra2 = new Coordenada(3, 3);
		this.coordTierra3 = new Coordenada(4, 4);
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugadorProtoss = new JugadorProtoss("Damian", this.mapa);
		this.jugadorTerran = new JugadorTerran("Luciano", this.mapa);

	}

	@Test
	public void elJugadorComienzaConUnNombre() {
		Assert.assertEquals("Damian", jugadorProtoss.getNombre());
	}

	@Test
	public void elJugadorComienzaConCeroGas() {
		Assert.assertEquals(0, jugadorProtoss.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void elJugadorComienzaCon200Mineral() {
		Assert.assertEquals(200, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeMineralTiene220() {
		jugadorProtoss.getPresupuesto().agregarMineral(20);
		Assert.assertEquals(220, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasTiene20() {
		jugadorProtoss.getPresupuesto().agregarGas(20);
		Assert.assertEquals(20, jugadorProtoss.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void siElJugadorSuma20DeMineralYGasta10Tiene210() {
		jugadorProtoss.getPresupuesto().agregarMineral(20);
		jugadorProtoss.getPresupuesto().gastar(new Costo(10));
		Assert.assertEquals(210, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasYGasta10Tiene10() {
		jugadorProtoss.getPresupuesto().agregarGas(20);
		jugadorProtoss.getPresupuesto().gastar(new Costo(0, 10));
		Assert.assertEquals(10, jugadorProtoss.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void siElJugadorGastaMasGasDelQueTieneSeLanzaExcepcion() {
		jugadorProtoss.getPresupuesto().agregarGas(20);
		try {
			jugadorProtoss.getPresupuesto().gastar(new Costo(0, 30));
			Assert.assertTrue(false);
		} catch (GasInsuficiente e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void siElJugadorGastaMasMineralDelQueTieneSeLanzaExcepcion() {
		jugadorProtoss.getPresupuesto().agregarMineral(20);
		try {
			jugadorProtoss.getPresupuesto().gastar(new Costo(300));
			Assert.assertTrue(false);
		} catch (MineralInsuficiente e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void elJugadorRecolectaMineralesDeUnRecolectorYSuma10() {
		NexoMineral recolector = new NexoMineral();
		recolector.setCoordenada(new Coordenada(1, 100));
		recolector.setJugador(jugadorProtoss);
		recolector.recolectar(mapa);
		Assert.assertEquals(210, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void elJugadorRecolectaMineralesDeOtroRecolectorYSuma10() {
		CentroDeMineral recolector = new CentroDeMineral();
		recolector.setCoordenada(new Coordenada(1, 91));
		recolector.setJugador(jugadorTerran);
		recolector.recolectar(mapa);
		Assert.assertEquals(210, jugadorTerran.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void elJugadorRecolectaGasDeUnRecolectorYSuma10() {
		Refineria recolector = new Refineria();
		recolector.setCoordenada(new Coordenada(1, 90));
		recolector.setJugador(jugadorTerran);
		recolector.recolectar(mapa);
		Assert.assertEquals(10, jugadorTerran.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void elJugadorRecolectaGasDeOtroRecolectorYSuma10() {
		Asimilador recolector = new Asimilador();
		recolector.setCoordenada(new Coordenada(6, 26));
		recolector.setJugador(jugadorProtoss);
		recolector.recolectar(mapa);
		Assert.assertEquals(10, jugadorProtoss.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void elJugadorProtossConstruyeUnNexoMineral()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new NexoMineral();
		jugadorProtoss.construir(construccion, new Coordenada(1, 100));
		for (int i = 0; i < 4; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorProtossConstruyeUnNexoMineralPeroNoPasanTurnosEntoncesNoLoTiene()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new NexoMineral();
		jugadorProtoss.construir(construccion, new Coordenada(1, 100));
		Assert.assertFalse(jugadorProtoss.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorProtossConstruyeUnNexoMineralLeQuedan150DeMinerales()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new NexoMineral();
		jugadorProtoss.construir(construccion, new Coordenada(1, 100));
		for (int i = 0; i < 4; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertEquals(150, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void elJugadorProtossConstruyeUnPilon()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Pilon();
		jugadorProtoss.construir(construccion, coordTierra);
		for (int i = 0; i < 5; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorProtossConstruyeUnPilonLeQuedan100DeMinerales()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Pilon();
		jugadorProtoss.construir(construccion, coordTierra);
		for (int i = 0; i < 5; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertEquals(100, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void elJugadorProtossConstruyeUnAsimilador()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Asimilador();
		jugadorProtoss.construir(construccion, new Coordenada(1, 90));
		for (int i = 0; i < 6; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorProtossConstruyeUnAsimiladorLeQuedan100DeMinerales()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Asimilador();
		jugadorProtoss.construir(construccion, new Coordenada(1, 90));
		for (int i = 0; i < 6; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertEquals(100, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	@Test
	public void elJugadorProtossConstruyeUnAcceso()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Acceso();
		jugadorProtoss.construir(construccion, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorProtossConstruyeUnAccesoLeQuedan50DeMinerales()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss construccion = new Acceso();
		jugadorProtoss.construir(construccion, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		Assert.assertEquals(50, jugadorProtoss.getPresupuesto()
				.cantidadDeMineral());
	}

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void
	// siElJugadorProtossQuiereConstruirUnPuertoEstelarSinUnAccesoLanzaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// ConstruccionProtoss puerto = new PuertoEstelarProtoss();
	// for (int i = 0; i < 10; i++) {
	// jugadorProtoss.pasarTurno();
	// }
	// jugadorProtoss.construir(puerto, coordTierra);
	// }

	@Test(expected = MineralInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaLanzaExcepcion()
			throws ConstruccionRequeridaInexistente {
		ConstruccionProtoss acceso = new Acceso();
		jugadorProtoss.construir(acceso, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		ConstruccionProtoss puerto = new PuertoEstelarProtoss();
		jugadorProtoss.construir(puerto, coordTierra2);
	}

	@Test(expected = GasInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaElGasLanzaExcepcion()
			throws ConstruccionRequeridaInexistente {
		jugadorProtoss.getPresupuesto().agregarMineral(1000);
		ConstruccionProtoss acceso = new Acceso();
		jugadorProtoss.construir(acceso, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		ConstruccionProtoss puerto = new PuertoEstelarProtoss();
		jugadorProtoss.construir(puerto, coordTierra2);
	}

	@Test
	public void elJugadorProtossConstruyeUnPuertoEstelar()
			throws ConstruccionRequeridaInexistente {

		ConstruccionProtoss acceso = new Acceso();
		ConstruccionProtoss puerto = new PuertoEstelarProtoss();
		jugadorProtoss.getPresupuesto().agregarGas(1000);
		jugadorProtoss.getPresupuesto().agregarMineral(1000);

		jugadorProtoss.construir(acceso, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		jugadorProtoss.construir(puerto, coordTierra2);
		for (int i = 0; i < 10; i++) {
			jugadorProtoss.pasarTurno();
		}

		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(puerto));
	}

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void
	// siElJugadorProtossQuiereConstruirUnArchivoTemplarioSinUnPuertEstelarLanzaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// ConstruccionProtoss archivo = new ArchivosTemplarios();
	// jugadorProtoss.construir(archivo, coordTierra);
	// }

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void
	// elJugadorProtossQuiereConstruirUnArchivoTemplarioConUnAccesoLanzaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	//
	// ConstruccionProtoss acceso = new Acceso();
	// ConstruccionProtoss archivo = new ArchivosTemplarios();
	// jugadorProtoss.getPresupuesto().agregarGas(1000);
	// jugadorProtoss.getPresupuesto().agregarMineral(1000);
	//
	// jugadorProtoss.construir(acceso, coordTierra);
	// for (int i = 0; i < 8; i++) {
	// jugadorProtoss.pasarTurno();
	// }
	// jugadorProtoss.construir(archivo, coordTierra2);
	// }

	@Test
	public void elJugadorProtossPuedeConstruirUnArchivoTemplarioConUnPuertoEstelar()
			throws ConstruccionRequeridaInexistente {

		ConstruccionProtoss archivo = new ArchivosTemplarios();
		ConstruccionProtoss acceso = new Acceso();
		ConstruccionProtoss puerto = new PuertoEstelarProtoss();
		jugadorProtoss.getPresupuesto().agregarGas(1000);
		jugadorProtoss.getPresupuesto().agregarMineral(1000);

		jugadorProtoss.construir(acceso, coordTierra);
		for (int i = 0; i < 8; i++) {
			jugadorProtoss.pasarTurno();
		}
		jugadorProtoss.construir(puerto, coordTierra2);
		for (int i = 0; i < 10; i++) {
			jugadorProtoss.pasarTurno();
		}
		jugadorProtoss.construir(archivo, coordTierra3);
		for (int i = 0; i < 9; i++) {
			jugadorProtoss.pasarTurno();
		}

		Assert.assertTrue(jugadorProtoss.getConstrucciones().contains(archivo));
	}

	@Test
	public void elJugadorTerranConstruyeUnCentroDeMineral()
			throws ConstruccionRequeridaInexistente {
		ConstruccionTerran construccion = new CentroDeMineral();
		jugadorTerran.construir(construccion, new Coordenada(1, 91));
		for (int i = 0; i < 4; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorTerranConstruyeUnaBarraca()
			throws ConstruccionRequeridaInexistente {
		ConstruccionTerran construccion = new Barraca();
		jugadorTerran.construir(construccion, coordTierra);
		for (int i = 0; i < 12; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorTerranConstruyeUnDepositoSuministro()
			throws ConstruccionRequeridaInexistente {
		ConstruccionTerran construccion = new DepositoSuministro();
		jugadorTerran.construir(construccion, coordTierra);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(
				construccion));
	}

	@Test
	public void elJugadorTerranConstruyeUnaRefineria()
			throws ConstruccionRequeridaInexistente {
		ConstruccionTerran construccion = new Refineria();
		jugadorTerran.construir(construccion, new Coordenada(1, 90));
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(
				construccion));
	}

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void elJugadorTerranNoPuedeConstruirUnaFabricaSinUnaBarraca()
	// throws ConstruccionRequeridaInexistente {
	//
	// ConstruccionTerran fabrica = new Fabrica();
	//
	// jugadorTerran.getPresupuesto().agregarMineral(1000);
	//
	// jugadorTerran.construir(fabrica, coordTierra);
	//
	// }

	@Test
	public void elJugadorTerranPuedeConstruirUnaFabricaConUnaBarraca()
			throws ConstruccionRequeridaInexistente {

		ConstruccionTerran barraca = new Barraca();
		ConstruccionTerran fabrica = new Fabrica();

		jugadorTerran.getPresupuesto().agregarMineral(1000);
		jugadorTerran.getPresupuesto().agregarGas(1000);

		jugadorTerran.construir(barraca, coordTierra);
		for (int i = 0; i < 12; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.construir(fabrica, coordTierra2);
		for (int i = 0; i < 12; i++) {
			jugadorTerran.pasarTurno();
		}

		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(fabrica));

	}

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void elJugadorTerranNoPuedeConstruirUnPuertoEstelarSinUnaFabrica()
	// throws ConstruccionRequeridaInexistente {
	//
	// ConstruccionTerran puerto = new PuertoEstelarTerran();
	//
	// jugadorTerran.getPresupuesto().agregarMineral(1000);
	// jugadorTerran.getPresupuesto().agregarGas(1000);
	//
	// jugadorTerran.construir(puerto, coordTierra);
	//
	// }

	// @Test(expected = ConstruccionRequeridaInexistente.class)
	// public void
	// elJugadorTerranNoPuedeConstruirUnPuertoEstelarConSoloUnaBarraca()
	// throws ConstruccionRequeridaInexistente {
	//
	// ConstruccionTerran barraca = new Barraca();
	// ConstruccionTerran puerto = new PuertoEstelarTerran();
	//
	// jugadorTerran.getPresupuesto().agregarMineral(1000);
	// jugadorTerran.getPresupuesto().agregarGas(1000);
	//
	// jugadorTerran.construir(barraca, coordTierra);
	// for (int i = 0; i < 12; i++) {
	// jugadorTerran.pasarTurno();
	// }
	//
	// jugadorTerran.construir(puerto, coordTierra2);
	//
	// }

	@Test
	public void elJugadorTerranPuedeConstruirUnPuertoEstelarConUnaFabrica()
			throws ConstruccionRequeridaInexistente {

		ConstruccionTerran barraca = new Barraca();
		ConstruccionTerran fabrica = new Fabrica();
		ConstruccionTerran puerto = new PuertoEstelarTerran();

		jugadorTerran.getPresupuesto().agregarMineral(1000);
		jugadorTerran.getPresupuesto().agregarGas(1000);

		jugadorTerran.construir(barraca, coordTierra);
		for (int i = 0; i < 12; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.construir(fabrica, coordTierra2);
		for (int i = 0; i < 12; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.construir(puerto, coordTierra3);
		for (int i = 0; i < 10; i++) {
			jugadorTerran.pasarTurno();
		}

		Assert.assertTrue(jugadorTerran.getConstrucciones().contains(puerto));

	}

	@Test
	public void siElJugadorConstruyeDepositosDeSuministrosElLimitePoblacionalAUmentaEn5()
			throws ConstruccionRequeridaInexistente {

		jugadorTerran.construir(new DepositoSuministro(), coordTierra);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.limitePoblacional() == 10);
		jugadorTerran.construir(new DepositoSuministro(), coordTierra2);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		Assert.assertTrue(jugadorTerran.limitePoblacional() == 15);
	}

	@Test
	public void siElJugadorTieneUnMarineYSeLoMatanSuPoblacionVuelveACero()
			throws ConstruccionRequeridaInexistente {
		jugadorTerran.inicializarEnPrimeraBase();
		jugadorTerran.construir(new DepositoSuministro(), coordTierra);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		Marine marine = new Marine();
		jugadorTerran.agregarUnidad(marine, new Coordenada(1, 1));
		jugadorTerran.pasarTurno();

		Marine enemigo = new Marine();
		enemigo.setCoordenada(new Coordenada(0, 0));
		while (!marine.estaMuerto()) {
			enemigo.atacar(marine);
		}

		jugadorTerran.empezarTurno();

		Assert.assertEquals(1, jugadorTerran.contarPoblacion());

	}

	@Test
	public void siElJugadorTieneUnDepositoYSeLoMatanSuPoblacionLimiteVuelveACinco()
			throws ConstruccionRequeridaInexistente {
		DepositoSuministro deposito = new DepositoSuministro();
		jugadorTerran.construir(deposito, coordTierra);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.pasarTurno();

		Marine enemigo = new Marine();
		enemigo.setCoordenada(new Coordenada(0, 0));
		while (!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugadorTerran.empezarTurno();

		Assert.assertEquals(5, jugadorTerran.limitePoblacional());
		Assert.assertFalse(jugadorTerran.getConstrucciones().contains(deposito));
	}

	@Test
	public void siElJugadorTieneDosDepositosYLeMatanUnoSuPoblacionLimiteVuelveADiez()
			throws ConstruccionRequeridaInexistente {
		DepositoSuministro deposito = new DepositoSuministro();
		DepositoSuministro otroDeposito = new DepositoSuministro();
		Coordenada otraCoordenada = new Coordenada(1, 2);
		jugadorTerran.construir(deposito, coordTierra);
		jugadorTerran.construir(otroDeposito, otraCoordenada);
		for (int i = 0; i < 6; i++) {
			jugadorTerran.pasarTurno();
		}
		jugadorTerran.pasarTurno();
		Assert.assertEquals(15, jugadorTerran.limitePoblacional());

		Marine enemigo = new Marine();
		enemigo.setCoordenada(new Coordenada(0, 0));
		while (!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugadorTerran.empezarTurno();

		Assert.assertEquals(10, jugadorTerran.limitePoblacional());
	}

}
