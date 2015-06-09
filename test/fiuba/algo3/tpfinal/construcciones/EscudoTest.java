package fiuba.algo3.tpfinal.construcciones;

import org.junit.Assert;
import org.junit.Test;

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
	public void sielEscudoNoEstaCompletoYSePasaElTurnoSeRegeneraCompletamente() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno();
		
		Assert.assertEquals(500, escudo.getEscudo());
	}
	
	@Test
	public void sielEscudoNoEstaCompletoYSePasaElTurnoSeRegeneraCompletamentePeroLaVidaNoSeCambia() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno();
		
		Assert.assertEquals(400, vida.getVida());
	}
	
	@Test
	public void siSePasanMuchosTurnosElEscudoNoSePasaDeSuLimite() {
		Escudo escudo = new Escudo();
		Vida vida = new Vida();
		escudo.inicializarEscudo(500);
		vida.inicializarVida(500);
		
		escudo.bajarEscudo(600, vida);
		escudo.pasarTurno();
		escudo.pasarTurno();
		escudo.pasarTurno();
		escudo.pasarTurno();
		
		Assert.assertEquals(500, escudo.getEscudo());
	}


}
