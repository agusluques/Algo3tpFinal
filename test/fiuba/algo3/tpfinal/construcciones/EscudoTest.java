package fiuba.algo3.tpfinal.construcciones;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class EscudoTest {
	
	@Test
	public void siSeBajaElEscudoConUnInicialDe500LeQueda400() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(100);
		
		escudo.bajarEscudo(100, vida);
		
		Assert.assertEquals(400, escudo.getEscudo());
	}
	
	@Test
	public void siSeBajaElEscudoConUnInicialDe500NoBajaLaVida() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(100);
		
		escudo.bajarEscudo(100, vida);
		
		Assert.assertEquals(100, vida.getVida());
	}
	
	@Test
	public void siSeBajaElEscudoEn600ConUnInicialDe500NoQuedaEnNegativo() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		
		escudo.bajarEscudo(600, vida);
		
		Assert.assertEquals(0, escudo.getEscudo());
	}
	
	@Test
	public void siSeBajaElEscudoEn600ConUnInicialDe500LaVidaQuedaEn400() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		
		escudo.bajarEscudo(600, vida);
		
		Assert.assertEquals(400, vida.getVida());
	}
	
	@Test
	public void sielEscudoNoEstaCompletoYSePasaElTurnoSeRegeneraCompletamente() throws Exception {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno(jugador, mapa);
		
		Assert.assertEquals(500, escudo.getEscudo());
	}
	
	@Test
	public void sielEscudoNoEstaCompletoYSePasaElTurnoSeRegeneraCompletamentePeroLaVidaNoSeCambia() throws Exception {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno(jugador, mapa);
		
		Assert.assertEquals(400, vida.getVida());
	}
	
	@Test
	public void siSePasanMuchosTurnosElEscudoNoSePasaDeSuLimite() throws Exception {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno(jugador, mapa);
		escudo.pasarTurno(jugador, mapa);
		escudo.pasarTurno(jugador, mapa);
		escudo.pasarTurno(jugador, mapa);
		
		Assert.assertEquals(500, escudo.getEscudo());
	}


}
