package fiuba.algo3.tpfinal.unidades;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.programa.Danio;

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
	
	@Test
	public void unaNaveSinPasajerosDesciendeUnaListaVacia() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Collection<UnidadesProtoss> pasajerosDescendidos= nave.descenderPasajeros();
		Assert.assertTrue(pasajerosDescendidos.isEmpty());
	}
	
	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		
		Assert.assertEquals(8, nave.getCapacidad());
		
	}
	
	@Test
	public void unaNaveConUnZealotDesciendeUnaListaConUnZealot() {
		NaveTransporteProtoss nave = new NaveTransporteProtoss();
		Zealot zealot = new Zealot();
		
		nave.subirPasajero(zealot);
		Collection<UnidadesProtoss> pasajerosDescendidos= nave.descenderPasajeros();
		
		Assert.assertTrue(pasajerosDescendidos.contains(zealot));
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
	
	
	
	

}
