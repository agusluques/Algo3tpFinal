package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class AsimiladorTest {

	private Asimilador asimilador;

	@Before
	public void arrange() {
		this.asimilador = new Asimilador(new Coordenada(1,90));
	}

	@Test
	public void unAsimiladorDebeTener450DeVidaInicial() {
		Assert.assertTrue(this.asimilador.getVida() == 450);
	}

	@Test
	public void unAsimiladorDebeTener450DeEscudoInicial() {
		Assert.assertTrue(this.asimilador.getEscudo() == 450);
	}

	@Test
	public void unAsimiladorDebeCostar100Minerales() {
		Assert.assertTrue(this.asimilador.getCostoMineral() == 100);
	}

	@Test
	public void unAsimiladorDebeCostar0Gases() {
		Assert.assertTrue(this.asimilador.getCostoGas() == 0);
	}
	
	@Test
	public void unAsimiladorDebeCrearseEn6Turnos() {
		Assert.assertTrue(this.asimilador.getTiempoRestante() == 6);
	}
	
	@Test
	public void dosAsimiladoresDeberianSerIguales() {
		Constructible otroAsimilador = new Asimilador(new Coordenada(6, 26));
		Assert.assertTrue(this.asimilador.equals(otroAsimilador));
	}
	
	@Test
	public void siPasaTurnoAumentaElEscudoYLeCargaGasAlJugador() throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Zealot zealot = new Zealot();
		
		zealot.atacar(asimilador);
		asimilador.pasarTurno(jugador, mapa);
		
		Assert.assertEquals(450, asimilador.getEscudo());
		Assert.assertEquals(10, jugador.getPresupuesto().cantidadDeGas());
	}
	
}
