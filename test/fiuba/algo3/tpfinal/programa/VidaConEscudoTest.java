package fiuba.algo3.tpfinal.programa;

import static org.junit.Assert.*;

import org.junit.Test;

public class VidaConEscudoTest {
	
	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn100ElEscudoQuedaEn400() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);

		vidaConEscudo.recibirDanio(100);
		
		assertEquals(400, vidaConEscudo.getEscudo());
	}
	
	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn100LaVidaQuedaIntacta() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);

		vidaConEscudo.recibirDanio(100);
		
		assertEquals(100, vidaConEscudo.getVida());
	}
	
	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn550ElEscudoNoQuedaNegativo() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);

		vidaConEscudo.recibirDanio(550);
		
		assertEquals(0, vidaConEscudo.getEscudo());
	}
	
	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn550LaVidaQuedaEn50() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);

		vidaConEscudo.recibirDanio(550);
		
		assertEquals(50, vidaConEscudo.getVida());
	}
	
	@Test
	public void siElEscudoNoEstaCompletoYSePAsaTurnoSeRegeneraEn8() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);
		vidaConEscudo.recibirDanio(100);
		
		vidaConEscudo.pasarTurno();
		
		assertEquals(408, vidaConEscudo.getEscudo());
	}
	
	@Test
	public void siElEscudoYLaVidaNoEstanCompletosYSePasaTurnoLAVidaNoSeREgenera() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);

		vidaConEscudo.recibirDanio(550);
		vidaConEscudo.pasarTurno();
		
		assertEquals(50, vidaConEscudo.getVida());
	}
	
	@Test
	public void siSePasanMuchosTurnosElEscudoNoPasaDeSuLimiteInicial() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100,500);
		
		vidaConEscudo.recibirDanio(20);
		vidaConEscudo.pasarTurno();
		vidaConEscudo.pasarTurno();
		vidaConEscudo.pasarTurno();
		
		assertEquals(500, vidaConEscudo.getEscudo());
	}

}
