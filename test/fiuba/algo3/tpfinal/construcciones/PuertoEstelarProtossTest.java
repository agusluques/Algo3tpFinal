package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.Rango;
import fiuba.algo3.tpfinal.unidades.Scout;

public class PuertoEstelarProtossTest {

	private PuertoEstelarProtoss puertoEstelar;

	@Test
	public void unPuertoEstelarDebeTener600DeVidaInicial()
			throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getVida() == 600);
	}

	@Test
	public void unPuertoEstelarDebeTener600DeEscudoInicial()
			throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getEscudo() == 600);
	}

	@Test
	public void unPuertoEstelarDebeCostar150Minerales()
			throws ConstruccionRequeridaInexistente {

		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCosto().getMinerales() == 150);
	}

	@Test
	public void unPuertoEstelarDebeCostar150Gases()
			throws ConstruccionRequeridaInexistente {

		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCosto().getGas() == 150);
	}

	@Test
	public void unPuertoEstelarDebeCrearseEn10Turnos()
			throws ConstruccionRequeridaInexistente {

		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getTiempoRestante() == 10);
	}

	@Test
	public void dosPuertosEstelaresDeberianSerIguales() {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Constructible otroPuerto = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.equals(otroPuerto));
	}

	@Test
	public void siFabricoUnScoutElMismoApareceEnLaListaDeUnidadesDelJugador()
			throws Exception {
		int cantDeScout=0;
		this.puertoEstelar = new PuertoEstelarProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Acceso(), new Coordenada(2, 2));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(4, 4));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(), new Coordenada(6, 6));
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarScout();
		for (int i = 0; i < 9; i++) {
			this.puertoEstelar.pasarTurno(null, null);
		}
		for (Atacable unidad : jugador.getUnidades()) {
			if(unidad.getClass()==(new Scout()).getClass()){
				cantDeScout++;
			}
		}

		Assert.assertTrue(cantDeScout==1);
	}

	@Test
	public void siFabricoUnaNaveDeTransporteProtossLaMismaApareceEnLaListaDeUnidadesDelJugador()
			throws Exception {
		int cantDeNave=0;
		this.puertoEstelar = new PuertoEstelarProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorProtoss jugador = new JugadorProtoss("Damian", mapa);

		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Acceso(), new Coordenada(2, 2));
		for (int i = 0; i < 8; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(4, 4));
		for (int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(), new Coordenada(6, 6));
		for (int i = 0; i < 5; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i = 0; i < 8; i++) {
			this.puertoEstelar.pasarTurno(null, null);
		}
		for (Atacable unidad : jugador.getUnidades()) {
			if(unidad.getClass()==(new NaveTransporteProtoss()).getClass()){
				cantDeNave++;
			}
		}

		Assert.assertTrue(cantDeNave==1);
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Rango rango = new Rango(1, 2);

		Assert.assertEquals(1,
				this.puertoEstelar.rangoDeAtaqueCorrespondiente(rango));
	}

}
