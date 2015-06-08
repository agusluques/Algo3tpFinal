package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public class NaveCienciaTest {

	@Test
	public void siSeCreaUnaNaveCienciaDebeTener200DeVida(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Assert.assertTrue(naveCiencia.getVida() == 200);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan100DebeTener100(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(100,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 100);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan800DebeTener0(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(800,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 0);
	}
	
	@Test
	public void siUnEspectroAtacaAUnaNaveCienciaAlSegundoLeBajaLaVidaA180() {
		
		Espectro unEspectro = new Espectro();
		NaveCiencia unaNaveCiencia = new NaveCiencia();
		unEspectro.atacar(unaNaveCiencia);
		Assert.assertTrue(unaNaveCiencia.getVida() == 180);
	}
	
	@Test
	public void unaNaveCienciaSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveCiencia unidad = new NaveCiencia();
		
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}
	
	@Test
	public void unNaveCienciaSePuedeMoverAUnaCeldaVecinaSiHayTierra() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test
	public void unNaveCienciaSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,50);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,100);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,90);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiEstaOcupada() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}

}
