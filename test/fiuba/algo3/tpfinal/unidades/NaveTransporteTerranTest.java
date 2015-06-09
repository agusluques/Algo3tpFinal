package fiuba.algo3.tpfinal.unidades;



import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.excepciones.NoHayPasajerosEnLaNave;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public class NaveTransporteTerranTest {

	@Test
	public void siSeCreaUnaNaveTansporteTerranDebeTener150DeVida(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Assert.assertTrue(nave.getVida() == 150);
	}
	
	@Test
	public void siAUnaNaveTansporteTerranLePegan100DebeTener50(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(100,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 50);
	}
	
	@Test
	public void siAUnaNaveTansporteTerranLePegan800DebeTener0(){
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Danio danio = new Danio(800,0);
		nave.atacado(danio);
		Assert.assertTrue(nave.getVida() == 0);
	}
	
	@Test
	public void siUnEspectroAtacaAUnaNaveTransporteTerranAlSegundoLeBajaLaVidaA130() {
		
		Espectro unEspectro = new Espectro();
		NaveTransporteTerran nave = new NaveTransporteTerran();
		unEspectro.atacar(nave);
		Assert.assertTrue(nave.getVida() == 130);
	}
	
	@Test
	public void siUnaNaveCienciaAtacaAUnaNaveTransporteTerranAlSegundoNoLeBajaVida() {
		
		NaveCiencia naveUno = new NaveCiencia();
		NaveTransporteTerran naveDos = new NaveTransporteTerran();
		naveUno.atacar(naveDos);
		Assert.assertTrue(naveDos.getVida() == 150);
	}
	
	@Test(expected = NoHayPasajerosEnLaNave.class)
	public void unaNaveSinPasajerosDesciendeUnaListaVacia() throws NoHayPasajerosEnLaNave {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		nave.bajarPasajeros();
		
	}
	
	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		
		Assert.assertEquals(8, nave.getCapacidad());
		
	}
	

	
	@Test
	public void unaNaveConUnMarineTieneCapacidad7() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Marine marine = new Marine();
		
		nave.subirPasajero(marine);
		
		Assert.assertEquals(7, nave.getCapacidad());
	}
	
	@Test
	public void unaNavePuedeSubir8Marines() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Marine marine = new Marine();
		
		for (int i=0; i<8; i++) {
			nave.subirPasajero(marine);
		}
		
		Assert.assertEquals(0, nave.getCapacidad());
	}
	
	@Test(expected = CapacidadInsuficiente.class)
	public void siUnaNaveIntentaSubir9MarinesLanzaExcepcion() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Marine marine = new Marine();
		
		for (int i=0; i<9; i++) {
			nave.subirPasajero(marine);
		}
	}
	
	@Test(expected = CapacidadInsuficiente.class)
	public void unaNaveNoPuedeSubirAOtraNaveAunqueEsteVacia() {
		NaveTransporteTerran nave1 = new NaveTransporteTerran();
		NaveTransporteTerran nave2 = new NaveTransporteTerran();
		
		nave1.subirPasajero(nave2);
	}
	
	@Test
	public void unaNaveTransporteSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}
	
	@Test
	public void unNaveTransporteTerranSePuedeMoverAUnaCeldaVecinaSiHayTierra() throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test
	public void unNaveTransporteTerranSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,50);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,100);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,90);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveTransporteTerranNoSePuedeMoverAOtraCeldaSiEstaOcupada() throws Exception {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		NaveTransporteTerran unidad = new NaveTransporteTerran();
		Rango rango = new Rango(1,2);
		
		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

}
