package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.modelo.construcciones.Constructible;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.modelo.programa.JugadorTerran;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;
import fiuba.algo3.tpfinal.modelo.programa.Parcela;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;
import fiuba.algo3.tpfinal.modelo.unidades.Zealot;

public class CentroDeMineralTest {

	private CentroDeMineral centroMineral;
	private Mapa ambiente;

	@Before
	public void arrange() throws Exception {
		this.ambiente = new Mapa("mapaTierra.txt");
		this.centroMineral = new CentroDeMineral();
		centroMineral.setCoordenada(new Coordenada(1, 91));
	}

	@Test
	public void siSeCreaUnCentroDeMineralDeberiaTener500DeVida() {
		Assert.assertTrue(this.centroMineral.getVida() == 500);
	}

	@Test
	public void siSeCreaUnCentroDeMineralesSeDeberiaTener50MineralesMinimo() {
		Assert.assertTrue(this.centroMineral.getCosto().getMinerales() == 50);
	}

	@Test
	public void elTiempoDeConstruccionDeberiaSer4Turnos() {
		Assert.assertTrue(this.centroMineral.getTiempoRestante() == 4);
	}

	@Test
	public void siAtacanUnCentroCon100DeDanioLaVidaQuedaEn400() {
		Danio danio = new Danio(0, 100);
		centroMineral.atacado(danio);

		Assert.assertEquals(400, centroMineral.getVida());
	}

	@Test
	public void siAtacanUnCentroCon500DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(0, 500);
		centroMineral.atacado(danio);

		Assert.assertEquals(0, centroMineral.getVida());
	}

	@Test
	public void siAtacanUnCentroCon1000DeDanioLaVidaQuedaEn0() {
		Danio danio = new Danio(0, 1000);
		centroMineral.atacado(danio);

		Assert.assertEquals(0, centroMineral.getVida());
	}

	@Test
	public void dosCentroDeMineralDeberianSerIguales() {
		Constructible otroCentro = new CentroDeMineral();
		((CentroDeMineral) otroCentro).setCoordenada(new Coordenada(6, 26));
		Assert.assertTrue(this.centroMineral.equals(otroCentro));
	}

	@Test
	public void unCentroDeMineralPuedeExtraerDeUnDepositoDeMinerales() throws ParcelaOcupada {
		Coordenada coord = new Coordenada(1, 91);
		ambiente.insertarUnidad(coord, this.centroMineral);
		Assert.assertEquals(10,
				this.centroMineral.recolectarMinerales(ambiente));
	}

	@Test
	public void siUnCentroDeMineralExtraeDeUnDepositoDeMineralesLeRestan990() throws ParcelaOcupada {
		Coordenada coord = new Coordenada(1, 91);
		ambiente.insertarUnidad(coord, this.centroMineral);
		Parcela parcela = ambiente.getParcela(coord);
		DepositoDeMinerales deposito = (DepositoDeMinerales) parcela
				.getSuperficie();

		this.centroMineral.recolectarMinerales(ambiente);

		Assert.assertEquals(990, deposito.getRecursos());
	}

	@Test
	public void siPasaTurnoLeCargaMineralAlJugadorYLaVidaQuedaIgual()
			throws Exception {
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugador = new JugadorTerran("Damian", mapa);
		Zealot zealot = new Zealot();
		zealot.setCoordenada(new Coordenada(2, 91));
		centroMineral.setJugador(jugador);
		zealot.atacar(centroMineral);
		centroMineral.pasarTurno();

		Assert.assertEquals(492, centroMineral.getVida());
		Assert.assertEquals(210, jugador.getPresupuesto().cantidadDeMineral());
	}

	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		RangoDeAtaque rango = new RangoDeAtaque(1, 2);

		Assert.assertEquals(1,
				this.centroMineral.rangoDeAtaqueCorrespondiente(rango));
	}
}
