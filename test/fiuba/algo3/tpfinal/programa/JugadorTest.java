package fiuba.algo3.tpfinal.programa;



import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.unidades.Acceso;
import fiuba.algo3.tpfinal.unidades.Asimilador;
import fiuba.algo3.tpfinal.unidades.CentroDeMineral;
import fiuba.algo3.tpfinal.unidades.Constructible;
import fiuba.algo3.tpfinal.unidades.NexoMineral;
import fiuba.algo3.tpfinal.unidades.Pilon;
import fiuba.algo3.tpfinal.unidades.Recolector;
import fiuba.algo3.tpfinal.unidades.Refineria;

@SuppressWarnings("deprecation")
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
	public void elJugadorProtossConstruyeUnNexoMineral() {
		Constructible construccion = new NexoMineral();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnNexoMineralLeQuedan50DeMinerales() {
		Constructible construccion = new NexoMineral();
		jugador.construir(construccion);
		Assert.assertEquals(150, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilon() {
		Constructible construccion = new Pilon();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnPilonLeQuedan100DeMinerales() {
		Constructible construccion = new Pilon();
		jugador.construir(construccion);
		Assert.assertEquals(100, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimilador() {
		Constructible construccion = new Asimilador();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAsimiladorLeQuedan100DeMinerales() {
		Constructible construccion = new Asimilador();
		jugador.construir(construccion);
		Assert.assertEquals(100, jugador.getCantidadDeMineral());
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAcceso() {
		Constructible construccion = new Acceso();
		jugador.construir(construccion);
		Assert.assertTrue(jugador.posee(construccion));
	}
	
	@Test
	public void elJugadorProtossConstruyeUnAccesoLeQuedan50DeMinerales() {
		Constructible construccion = new Acceso();
		jugador.construir(construccion);
		Assert.assertEquals(50, jugador.getCantidadDeMineral());
	}

}
