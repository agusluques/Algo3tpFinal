package fiuba.algo3.tpfinal.programa;



import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Acceso;
import fiuba.algo3.tpfinal.unidades.ArchivosTemplarios;
import fiuba.algo3.tpfinal.unidades.Asimilador;
import fiuba.algo3.tpfinal.unidades.Barraca;
import fiuba.algo3.tpfinal.unidades.CentroDeMineral;
import fiuba.algo3.tpfinal.unidades.Constructible;
import fiuba.algo3.tpfinal.unidades.DepositoSuministro;
import fiuba.algo3.tpfinal.unidades.Fabrica;
import fiuba.algo3.tpfinal.unidades.NexoMineral;
import fiuba.algo3.tpfinal.unidades.Pilon;
import fiuba.algo3.tpfinal.unidades.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.unidades.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.unidades.Recolector;
import fiuba.algo3.tpfinal.unidades.Refineria;

public class JugadorTest {

	private Jugador jugador;

	@Before
	public void arrange() {
		this.jugador = new Jugador("Damian");
	}

	@Test
	public void elJugadorComienzaConUnNombre() {
		Assert.assertEquals("Damian", jugador.getNombre());
	}

	@Test
	public void elJugadorComienzaConCeroGas() {
		Assert.assertEquals(0, jugador.getCantidadDeGas());
	}

	@Test
	public void elJugadorComienzaCon200Mineral() {
		Assert.assertEquals(200, jugador.getCantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeMineralTiene220() {
		jugador.agregarMineral(20);
		Assert.assertEquals(220, jugador.getCantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasTiene20() {
		jugador.agregarGas(20);
		Assert.assertEquals(20, jugador.getCantidadDeGas());
	}

	@Test
	public void siElJugadorSuma20DeMineralYGasta10Tiene210() {
		jugador.agregarMineral(20);
		jugador.gastarMineral(10);
		Assert.assertEquals(210, jugador.getCantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasYGasta10Tiene10() {
		jugador.agregarGas(20);
		jugador.gastarGas(10);
		Assert.assertEquals(10, jugador.getCantidadDeGas());
	}

	@Test
	public void siElJugadorGastaMasGasDelQueTieneSeLanzaExcepcion() {
		jugador.agregarGas(10);
		try {
			jugador.gastarGas(30);
			Assert.assertTrue(false);
		} catch (GasInsuficiente e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void siElJugadorGastaMasMineralDelQueTieneSeLanzaExcepcion() {
		jugador.agregarMineral(10);
		try {
			jugador.gastarMineral(300);
			Assert.assertTrue(false);
		} catch (MineralInsuficiente e) {
			Assert.assertTrue(true);
		}

	}
	
	@Test
	public void elJugadorRecolectaMineralesDeUnRecolectorYSuma10() {
		Recolector recolector = new NexoMineral();
		jugador.recolectar(recolector);
		Assert.assertEquals(210, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorRecolectaMineralesDeOtroRecolectorYSuma10() {
		Recolector recolector = new CentroDeMineral();
		jugador.recolectar(recolector);
		Assert.assertEquals(210, jugador.getCantidadDeMineral());
	}

	@Test
	public void elJugadorRecolectaGasDeUnRecolectorYSuma10() {
		Recolector recolector = new Refineria();
		jugador.recolectar(recolector);
		Assert.assertEquals(10, jugador.getCantidadDeGas());
	}
	
	@Test
	public void elJugadorRecolectaGasDeOtroRecolectorYSuma10() {
		Recolector recolector = new Asimilador();
		jugador.recolectar(recolector);
		Assert.assertEquals(10, jugador.getCantidadDeGas());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineral() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new NexoMineral();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineralLeQuedan50DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new NexoMineral();
		jugador.construir(construccion);
		Assert.assertEquals(150, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilon() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Pilon();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilonLeQuedan100DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Pilon();
		jugador.construir(construccion);
		Assert.assertEquals(100, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimilador() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Asimilador();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimiladorLeQuedan100DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Asimilador();
		jugador.construir(construccion);
		Assert.assertEquals(100, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAcceso() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Acceso();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAccesoLeQuedan50DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Acceso();
		jugador.construir(construccion);
		Assert.assertEquals(50, jugador.getCantidadDeMineral());
	}

	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarSinUnAccesoLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.construir(puerto);
	}
	
	@Test(expected = MineralInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible acceso = new Acceso();
		jugador.construir(acceso);
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.construir(puerto);
	}
	
	@Test(expected = GasInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaElGasLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible nexo = new NexoMineral();
		jugador.construir(nexo);
		for (int i = 0; i < 20; i++) {
			jugador.recolectar((Recolector) nexo);
		}
		Constructible acceso = new Acceso();
		jugador.construir(acceso);
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.construir(puerto);
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPuertoEstelar() throws ConstruccionRequeridaInexistente {
		Constructible nexo = new NexoMineral();
		Constructible asimilador = new Asimilador();
		Constructible acceso = new Acceso();
		Constructible puerto = new PuertoEstelarProtoss();
		
		jugador.construir(nexo);
		jugador.construir(asimilador);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) nexo);
			jugador.recolectar((Recolector) asimilador);
		}
		jugador.construir(acceso);
		jugador.construir(puerto);
		
		Assert.assertTrue(jugador.posee(puerto));
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siElJugadorProtossQuiereConstruirUnArchivoTemplarioSinUnPuertEstelarLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible archivo = new ArchivosTemplarios();
		jugador.construir(archivo);
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorProtossQuiereConstruirUnArchivoTemplarioConUnAccesoLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible nexo = new NexoMineral();
		Constructible asimilador = new Asimilador();
		Constructible acceso = new Acceso();
		Constructible archivo = new ArchivosTemplarios();
		
		jugador.construir(nexo);
		jugador.construir(asimilador);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) nexo);
			jugador.recolectar((Recolector) asimilador);
		}
		jugador.construir(acceso);
		
		jugador.construir(archivo);
	}
	
	@Test
	public void elJugadorProtossPuedeConstruirUnArchivoTemplarioConUnPuertoEstelar() throws ConstruccionRequeridaInexistente {
		Constructible nexo = new NexoMineral();
		Constructible asimilador = new Asimilador();
		Constructible archivo = new ArchivosTemplarios();
		Constructible acceso = new Acceso();
		Constructible puerto = new PuertoEstelarProtoss();
		
		jugador.construir(nexo);
		jugador.construir(asimilador);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) nexo);
			jugador.recolectar((Recolector) asimilador);
		}
		jugador.construir(acceso);
		jugador.construir(puerto);
		jugador.construir(archivo);
		
		Assert.assertTrue(jugador.posee(archivo));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnCentroDeMineral() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new CentroDeMineral();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnaBarraca() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Barraca();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnDepositoSuministro() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new DepositoSuministro();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnaRefineria() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Refineria();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnaFabricaSinUnaBarraca() throws ConstruccionRequeridaInexistente {
		Constructible centro = new CentroDeMineral();
		Constructible refineria = new Refineria();
		Constructible fabrica = new Fabrica();
		
		jugador.construir(centro);
		jugador.construir(refineria);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) centro);
			jugador.recolectar((Recolector) refineria);
		}
		
		jugador.construir(fabrica);
		
	}
	
	@Test
	public void elJugadorTerranPuedeConstruirUnaFabricaConUnaBarraca() throws ConstruccionRequeridaInexistente {
		Constructible centro = new CentroDeMineral();
		Constructible refineria = new Refineria();
		Constructible barraca = new Barraca();
		Constructible fabrica = new Fabrica();
		
		jugador.construir(centro);
		jugador.construir(refineria);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) centro);
			jugador.recolectar((Recolector) refineria);
		}
		jugador.construir(barraca);
		jugador.construir(fabrica);
		
		Assert.assertTrue(jugador.posee(fabrica));
		
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnPuertoEstelarSinUnaFabrica() throws ConstruccionRequeridaInexistente {
		Constructible centro = new CentroDeMineral();
		Constructible refineria = new Refineria();
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.construir(centro);
		jugador.construir(refineria);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) centro);
			jugador.recolectar((Recolector) refineria);
		}
		
		jugador.construir(puerto);
		
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnPuertoEstelarConSoloUnaBarraca() throws ConstruccionRequeridaInexistente {
		Constructible centro = new CentroDeMineral();
		Constructible refineria = new Refineria();
		Constructible barraca = new Barraca();
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.construir(centro);
		jugador.construir(refineria);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) centro);
			jugador.recolectar((Recolector) refineria);
		}
		jugador.construir(barraca);
		
		jugador.construir(puerto);
		
	}
	
	@Test
	public void elJugadorTerranPuedeConstruirUnPuertoEstelarConUnaFabrica() throws ConstruccionRequeridaInexistente {
		Constructible centro = new CentroDeMineral();
		Constructible refineria = new Refineria();
		Constructible barraca = new Barraca();
		Constructible fabrica = new Fabrica();
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.construir(centro);
		jugador.construir(refineria);
		for (int i = 0; i < 50; i++) {
			jugador.recolectar((Recolector) centro);
			jugador.recolectar((Recolector) refineria);
		}
		jugador.construir(barraca);
		jugador.construir(fabrica);
		jugador.construir(puerto);
		
		Assert.assertTrue(jugador.posee(puerto));
		
	}
}
