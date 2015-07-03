package fiuba.algo3.tpfinal.programa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;

public class VidaConEscudoTest {

	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn100ElEscudoQuedaEn400() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(100);

		assertEquals(400, vidaConEscudo.getCantidadDeEscudo());
	}

	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn100LaVidaQuedaIntacta() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(100);

		assertEquals(100, vidaConEscudo.getCantidadDeVida());
	}

	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn550ElEscudoNoQuedaNegativo() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(550);

		assertEquals(0, vidaConEscudo.getCantidadDeEscudo());
	}

	@Test
	public void siLaVidaConEscudoSeCreaCon100y500YSeBajaEn550LaVidaQuedaEn50() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(550);

		assertEquals(50, vidaConEscudo.getCantidadDeVida());
	}

	@Test
	public void siElEscudoNoEstaCompletoYSePAsaTurnoSeRegeneraEn8() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);
		vidaConEscudo.recibirDanio(100);

		vidaConEscudo.pasarTurno();

		assertEquals(408, vidaConEscudo.getCantidadDeEscudo());
	}

	@Test
	public void siElEscudoYLaVidaNoEstanCompletosYSePasaTurnoLAVidaNoSeREgenera() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(550);
		vidaConEscudo.pasarTurno();

		assertEquals(50, vidaConEscudo.getCantidadDeVida());
	}

	@Test
	public void siSePasanMuchosTurnosElEscudoNoPasaDeSuLimiteInicial() {
		VidaConEscudo vidaConEscudo = new VidaConEscudo(100, 500);

		vidaConEscudo.recibirDanio(20);
		vidaConEscudo.pasarTurno();
		vidaConEscudo.pasarTurno();
		vidaConEscudo.pasarTurno();

		assertEquals(500, vidaConEscudo.getCantidadDeEscudo());
	}

}
