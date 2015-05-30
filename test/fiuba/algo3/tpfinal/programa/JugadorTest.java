package fiuba.algo3.tpfinal.programa;



import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.GasInsuficienteException;
import fiuba.algo3.tpfinal.excepciones.MineralInsuficienteException;

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
		} catch (GasInsuficienteException e) {
			Assert.assertTrue(true);
		}

	}

	@Test
	public void siElJugadorGastaMasMineralDelQueTieneSeLanzaExcepcion() {
		jugador.agregarMineral(10);
		try {
			jugador.gastarMineral(300);
			Assert.assertTrue(false);
		} catch (MineralInsuficienteException e) {
			Assert.assertTrue(true);
		}

	}

}
