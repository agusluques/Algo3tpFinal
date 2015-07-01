package fiuba.algo3.tpfinal.construcciones;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class AccesoTest {

	private Acceso acceso;

	@Before
	public void arrenge() {
		this.acceso = new Acceso();
	}

	@Test
	public void unAccesoDebeTener500DeVidaInicial() {
		// asserTrue(this.accesso.tieneVida(500));
		assertTrue(this.acceso.getCantidadDeVida() == 500);
	}

	@Test
	public void unAccesoDebeTener500DeEscudoInicial() {
		Assert.assertTrue(this.acceso.getCantidadDeEscudo() == 500);
	}

	@Test
	public void unAccesoDebeCostar150Minerales() {
		Assert.assertTrue(this.acceso.getCosto().getMinerales() == 150);
	}

	@Test
	public void unAccesoDebeCostar0Gases() {
		Assert.assertTrue(this.acceso.getCosto().getGas() == 0);
	}

	@Test
	public void unAccesoDebeCrearseEn8Turnos() {
		Assert.assertTrue(this.acceso.getTiempoRestante() == 8);
	}

	@Test
	public void dosAccesosDeberianSerIguales() {
		Constructible otroAcceso = new Acceso();
		Assert.assertTrue(this.acceso.equals(otroAcceso));
	}

	@Test
	public void siFabricoUnZealotElMismoApareceEnLaListaDeUnidadesDelJugador()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(acceso, new Coordenada(1, 1));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(), new Coordenada(1, 2));
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		((Acceso) this.acceso).fabricarZealot();
		for (int i = 0; i < 4; i++) {
			((Acceso) this.acceso).pasarTurno();
		}
		for (Atacable unidad : jugador.getUnidades()) {
			Assert.assertTrue(unidad.getClass() == (new Zealot()).getClass());
		}

	}

	@Test
	public void siFabricoUnDragonElMismoApareceEnLaListaDeUnidadesDelJugador()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(acceso, new Coordenada(1, 1));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(), new Coordenada(1, 2));
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		((Acceso) this.acceso).fabricarDragon();
		for (int i = 0; i < 6; i++) {
			((Acceso) this.acceso).pasarTurno();
		}
		int cantUnidadCorrespondiente = 0;
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Dragon()).getClass()) {
				cantUnidadCorrespondiente++;
			}
		}
		Assert.assertTrue(cantUnidadCorrespondiente == 1);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1, acceso.rangoDeAtaqueCorrespondiente(rango));
	}

	@Test
	public void siPongoAFabricarPrimeroUnDragonYDespuesUnZealotElDragonSeTerminaPrimero()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);
		jugador.inicializarEnPrimeraBase();

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		// Construyo un acceso y un pilon
		jugador.construir(new Pilon(), new Coordenada(1, 2));
		jugador.construir(acceso, new Coordenada(1, 1));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		// Pongo a fabricar un Dragon, un zealot y paso los turnos
		this.acceso.fabricarDragon();
		this.acceso.fabricarZealot();
		for (int i = 0; i < 6; i++) {
			this.acceso.pasarTurno();
		}
		int cantDeDragones = 0;
		int cantDeZealots = 0;
		// Cuento la cantidad de dragones y zealots
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Dragon()).getClass()) {
				cantDeDragones++;
			}
			if (unidad.getClass() == (new Zealot()).getClass()) {
				cantDeZealots++;
			}
		}
		Assert.assertTrue(cantDeDragones == 1);
		// Es 1 la cantidad de zealots porque esta la unidad basica
		Assert.assertTrue(cantDeZealots == 1);

		// Avanzo 4 turnos mas asi se termina de crear el zealot
		for (int i = 0; i < 4; i++) {
			this.acceso.pasarTurno();
		}
		cantDeDragones = 0;
		cantDeZealots = 0;
		// Cuento la cantidad de dragones y zealots
		for (Atacable unidad : jugador.getUnidades()) {
			if (unidad.getClass() == (new Dragon()).getClass()) {
				cantDeDragones++;
			}
			if (unidad.getClass() == (new Zealot()).getClass()) {
				cantDeZealots++;
			}
		}
		Assert.assertTrue(cantDeDragones == 1);
		// Es 2 la cantidad de zealots porque esta la unidad basica
		Assert.assertTrue(cantDeZealots == 2);

	}
}
