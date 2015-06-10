package fiuba.algo3.tpfinal.programa;



import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.construcciones.ArchivosTemplarios;
import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.construcciones.Recolector;
import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Marine;

public class JugadorTest {

	private Jugador jugador;
	private Mapa mapa;
	private Coordenada coordTierra, coordTierra2, coordTierra3;

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un mapa valido
		this.coordTierra = new Coordenada(2,2);
		this.coordTierra2 = new Coordenada(3,3);
		this.coordTierra3 = new Coordenada(4,4);
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugador = new Jugador("Damian", this.mapa);

	}

	@Test
	public void elJugadorComienzaConUnNombre() {
		Assert.assertEquals("Damian", jugador.getNombre());
	}

	@Test
	public void elJugadorComienzaConCeroGas() {
		Assert.assertEquals(0, jugador.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void elJugadorComienzaCon200Mineral() {
		Assert.assertEquals(200, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeMineralTiene220() {
		jugador.getPresupuesto().agregarMineral(20);
		Assert.assertEquals(220, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasTiene20() {
		jugador.getPresupuesto().agregarGas(20);
		Assert.assertEquals(20, jugador.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void siElJugadorSuma20DeMineralYGasta10Tiene210() {
		jugador.getPresupuesto().agregarMineral(20);
		jugador.getPresupuesto().removerMineral(10);
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void siElJugadorSuma20DeGasYGasta10Tiene10() {
		jugador.getPresupuesto().agregarGas(20);
		jugador.getPresupuesto().removerGas(10);
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}

	@Test
	public void siElJugadorGastaMasGasDelQueTieneSeLanzaExcepcion() {
		jugador.getPresupuesto().agregarGas(20);
		try {
			jugador.getPresupuesto().removerGas(30);
			Assert.assertTrue(false);
		} catch (GasInsuficiente e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void siElJugadorGastaMasMineralDelQueTieneSeLanzaExcepcion() {
		jugador.getPresupuesto().agregarMineral(20);
		try {
			jugador.getPresupuesto().removerMineral(300);
			Assert.assertTrue(false);
		} catch (MineralInsuficiente e) {
			Assert.assertTrue(true);
		}

	}
	
	@Test
	public void elJugadorRecolectaMineralesDeUnRecolectorYSuma10() {
		Recolector recolector = new NexoMineral(new Coordenada(1,100));
		recolector.recolectarPara(jugador, mapa);
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}
	
	@Test
	public void elJugadorRecolectaMineralesDeOtroRecolectorYSuma10() {
		Recolector recolector = new CentroDeMineral(new Coordenada(1,91));
		recolector.recolectarPara(jugador, mapa);
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void elJugadorRecolectaGasDeUnRecolectorYSuma10() {
		Recolector recolector = new Refineria(new Coordenada(1, 90));
		recolector.recolectarPara(jugador, mapa);
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}
	
	@Test
	public void elJugadorRecolectaGasDeOtroRecolectorYSuma10() {
		Recolector recolector = new Asimilador(new Coordenada(1, 90));
		recolector.recolectarPara(jugador, mapa);
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineral() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new NexoMineral(new Coordenada(1,100));
		jugador.construir(construccion,new Coordenada(1,100));
		for(int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineralPeroNoPasanTurnosEntoncesNoLoTiene() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new NexoMineral(new Coordenada(1,100));
		jugador.construir(construccion,new Coordenada(1,100));
		Assert.assertFalse(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineralLeQuedan150DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new NexoMineral(new Coordenada(1,100));
		jugador.construir(construccion,new Coordenada(1,100));
		for(int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		Assert.assertEquals(150, jugador.getPresupuesto().cantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilon() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Pilon();
		jugador.construir(construccion, coordTierra);
		for(int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilonLeQuedan100DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Pilon();
		jugador.construir(construccion,coordTierra);
		for(int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		Assert.assertEquals(100, jugador.getPresupuesto().cantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimilador() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Asimilador(new Coordenada(1, 90));
		jugador.construir(construccion,new Coordenada(1, 90));
		for(int i = 0; i <6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimiladorLeQuedan100DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Asimilador(new Coordenada(1, 90));
		jugador.construir(construccion,new Coordenada(1, 90));
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertEquals(100, jugador.getPresupuesto().cantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAcceso() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Acceso();
		jugador.construir(construccion,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAccesoLeQuedan50DeMinerales() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Acceso();
		jugador.construir(construccion,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		Assert.assertEquals(50, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarSinUnAccesoLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible puerto = new PuertoEstelarProtoss();
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(puerto,coordTierra);
	}
	
	@Test(expected = MineralInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible acceso = new Acceso();
		jugador.construir(acceso,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.construir(puerto,coordTierra2);
	}
	
	@Test(expected = GasInsuficiente.class)
	public void siElJugadorProtossQuiereConstruirUnPuertoEstelarYNoLeAlcanzaElGasLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		jugador.getPresupuesto().agregarMineral(1000);
		Constructible acceso = new Acceso();
		jugador.construir(acceso,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.construir(puerto,coordTierra2);
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPuertoEstelar() throws ConstruccionRequeridaInexistente {

		Constructible acceso = new Acceso();
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.getPresupuesto().agregarGas(1000);
		jugador.getPresupuesto().agregarMineral(1000);
		
		jugador.construir(acceso, coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(puerto, coordTierra2);
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		
		Assert.assertTrue(jugador.getConstrucciones().contains(puerto));
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siElJugadorProtossQuiereConstruirUnArchivoTemplarioSinUnPuertEstelarLanzaExcepcion() throws ConstruccionRequeridaInexistente {
		Constructible archivo = new ArchivosTemplarios();
		jugador.construir(archivo,coordTierra);
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorProtossQuiereConstruirUnArchivoTemplarioConUnAccesoLanzaExcepcion() throws ConstruccionRequeridaInexistente {
	
		Constructible acceso = new Acceso();
		Constructible archivo = new ArchivosTemplarios();
		jugador.getPresupuesto().agregarGas(1000);
		jugador.getPresupuesto().agregarMineral(1000);
		
		jugador.construir(acceso,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(archivo,coordTierra2);
	}
	
	@Test
	public void elJugadorProtossPuedeConstruirUnArchivoTemplarioConUnPuertoEstelar() throws ConstruccionRequeridaInexistente {
	
		Constructible archivo = new ArchivosTemplarios();
		Constructible acceso = new Acceso();
		Constructible puerto = new PuertoEstelarProtoss();
		jugador.getPresupuesto().agregarGas(1000);
		jugador.getPresupuesto().agregarMineral(1000);
	
		jugador.construir(acceso,coordTierra);
		for(int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(puerto,coordTierra2);
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(archivo,coordTierra3);
		for(int i = 0; i < 9; i++) {
			jugador.pasarTurno();
		}
		
		Assert.assertTrue(jugador.getConstrucciones().contains(archivo));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnCentroDeMineral() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new CentroDeMineral(new Coordenada(1,91));
		jugador.construir(construccion,new Coordenada(1,91));
		for(int i = 0; i < 4; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnaBarraca() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Barraca();
		jugador.construir(construccion,coordTierra);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnDepositoSuministro() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new DepositoSuministro();
		jugador.construir(construccion,coordTierra);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test
	public void elJugadorTerranConstruyeUnaRefineria() throws ConstruccionRequeridaInexistente {
		Constructible construccion = new Refineria(new Coordenada(1, 90));
		jugador.construir(construccion,new Coordenada(1, 90));
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.getConstrucciones().contains(construccion));
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnaFabricaSinUnaBarraca() throws ConstruccionRequeridaInexistente {
	
		Constructible fabrica = new Fabrica();
		
		jugador.getPresupuesto().agregarMineral(1000);
		
		jugador.construir(fabrica,coordTierra);
		
	}
	
	@Test
	public void elJugadorTerranPuedeConstruirUnaFabricaConUnaBarraca() throws ConstruccionRequeridaInexistente {
		
		Constructible barraca = new Barraca();
		Constructible fabrica = new Fabrica();
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		
		jugador.construir(barraca,coordTierra);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(fabrica,coordTierra2);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		
		Assert.assertTrue(jugador.getConstrucciones().contains(fabrica));
		
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnPuertoEstelarSinUnaFabrica() throws ConstruccionRequeridaInexistente {
	
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		
		jugador.construir(puerto,coordTierra);
		
	}
	
	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void elJugadorTerranNoPuedeConstruirUnPuertoEstelarConSoloUnaBarraca() throws ConstruccionRequeridaInexistente {
	
		Constructible barraca = new Barraca();
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
	
		jugador.construir(barraca,coordTierra);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(puerto,coordTierra2);
		
	}
	
	@Test
	public void elJugadorTerranPuedeConstruirUnPuertoEstelarConUnaFabrica() throws ConstruccionRequeridaInexistente {
		
		Constructible barraca = new Barraca();
		Constructible fabrica = new Fabrica();
		Constructible puerto = new PuertoEstelarTerran();
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		
		jugador.construir(barraca,coordTierra);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(fabrica,coordTierra2);
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(puerto,coordTierra3);
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		
		Assert.assertTrue(jugador.getConstrucciones().contains(puerto));
		
	}

	@Test
	public void siElJugadorConstruyeDepositosDeSuministrosElLimitePoblacionalAUmentaEn5() throws ConstruccionRequeridaInexistente{
		
		jugador.construir(new DepositoSuministro(),coordTierra);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.limitePoblacional()==10);
		jugador.construir(new DepositoSuministro(),coordTierra2);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Assert.assertTrue(jugador.limitePoblacional()==15);
	}
	
	@Test
	public void siElJugadorTieneUnMarineYSeLoMatanSuPoblacionVuelveACero() throws ConstruccionRequeridaInexistente {
		jugador.construir(new DepositoSuministro(),coordTierra);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		Marine marine = new Marine();
		jugador.agregarUnidad(marine,new Coordenada(1,1));
		jugador.pasarTurno();
		
		Marine enemigo = new Marine();
		while(!marine.estaMuerto()) {
			enemigo.atacar(marine);
		}
		
		jugador.empezarTurno();
		
		Assert.assertEquals(0, jugador.contarPoblacion());
		
	}
	
	@Test
	public void siElJugadorTieneUnDepositoYSeLoMatanSuPoblacionLimiteVuelveACinco() throws ConstruccionRequeridaInexistente {
		DepositoSuministro deposito = new DepositoSuministro();
		jugador.construir(deposito,coordTierra);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		
		Marine enemigo = new Marine();
		while(!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugador.empezarTurno();
		
		Assert.assertEquals(5, jugador.limitePoblacional());
		Assert.assertFalse(jugador.getConstrucciones().contains(deposito));
	}
	
	@Test
	public void siElJugadorTieneDosDepositosYLeMatanUnoSuPoblacionLimiteVuelveADiez() throws ConstruccionRequeridaInexistente {
		DepositoSuministro deposito = new DepositoSuministro();
		DepositoSuministro otroDeposito = new DepositoSuministro();
		Coordenada otraCoordenada = new Coordenada(1,2);
		jugador.construir(deposito, coordTierra);
		jugador.construir(otroDeposito, otraCoordenada);
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		jugador.pasarTurno();
		Assert.assertEquals(15, jugador.limitePoblacional());
		
		Marine enemigo = new Marine();
		while(!deposito.estaMuerto()) {
			enemigo.atacar(deposito);
		}
		jugador.empezarTurno();
		
		Assert.assertEquals(10, jugador.limitePoblacional());
	}
	
	@Test
	public void unJugadorAlIniciarConRazaNoEstaExtinto() {
		jugador.setRaza("Terran");
		Assert.assertFalse(jugador.estaExtinto());
	}


}

