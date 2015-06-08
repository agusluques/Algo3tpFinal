package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

import fiuba.algo3.tpfinal.excepciones.NoHayPasajerosEnLaNave;


import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;


public class NaveTransporteProtossTest {

	@Test
	public void siSeCreaUnaNaveTransporteProtossDebeTener80DeVidaY60DeEscudo(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Assert.assertTrue(nave.getVida() == 80);
		Assert.assertTrue(nave.getEscudo() == 60);
	}
	
	@Test
	public void siAUnaNaveTransporteProtossLePegan100DebeTener40DeVida(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(100,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 40);
	}
	
	@Test
	public void siAUnaNaveTransporteProtossLePegan800DebeTener0(){
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Danio danio = new Danio(800,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 0);
	}
	
	@Test
	public void siUnDragonAtacaAUnaNaveTransporteProtossAlSegundoLeBajaElEscudoA40YNoBajaVida() {
		
		Dragon unDragon = new Dragon();
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		unDragon.atacar(nave);
		Assert.assertTrue(nave.getVida() == 80);
		Assert.assertTrue(nave.getEscudo() == 40);
	}
	
	@Test(expected = NoHayPasajerosEnLaNave.class)
	public void siQuieroDescenderLosPasajerosDeUnaNaveSinPasajerosLanzaExcpecion() throws NoHayPasajerosEnLaNave {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		nave.bajarPasajeros();
	}
	
	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		
		Assert.assertEquals(8, nave.getCapacidad());
		
	}
	

	
	@Test
	public void unaNaveConUnZealotTieneCapacidad6() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		
		nave.subirPasajero(zealot);
		
		Assert.assertEquals(6, nave.getCapacidad());
	}
	
	@Test
	public void unaNavePuedeSubir4Zealots() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		
		Assert.assertEquals(0, nave.getCapacidad());
	}
	
	@Test(expected = CapacidadInsuficiente.class)
	public void siUnaNaveIntentaSubir5ZealotsLanzaExcepcion() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
		nave.subirPasajero(zealot);
	}
	
	@Test(expected = CapacidadInsuficiente.class)
	public void unaNaveNoPuedeSubirAOtraNaveAunqueEsteVacia() {
		NaveTransporteProtoss nave1 = new NaveTransporteProtoss();
		NaveTransporteProtoss nave2 = new NaveTransporteProtoss();
		
		nave1.subirPasajero(nave2);
	}
	
	@Test
	public void unaNaveTransporteSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}
	
	@Test
	public void unNaveTransporteProtossSePuedeMoverAUnaCeldaVecinaSiHayTierra() throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test
	public void unNaveTransporteProtossSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,50);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,100);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,90);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteProtossNoSePuedeMoverAOtraCeldaSiEstaOcupada() throws Exception {
		NaveTransporteProtoss unidad = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}
	
	

}
