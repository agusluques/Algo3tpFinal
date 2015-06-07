package fiuba.algo3.tpfinal.unidades;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.CapacidadInsuficiente;
import fiuba.algo3.tpfinal.programa.Danio;

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
	
	@Test
	public void unaNaveSinPasajerosDesciendeUnaListaVacia() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Collection<UnidadesTerran> pasajerosDescendidos= nave.descenderPasajeros();
		Assert.assertTrue(pasajerosDescendidos.isEmpty());
	}
	
	@Test
	public void unaNaveSinPasajerosTieneCapacidad8() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		
		Assert.assertEquals(8, nave.getCapacidad());
		
	}
	
	@Test
	public void unaNaveConUnMarineDesciendeUnaListaConUnMarine() {
		NaveTransporteTerran nave = new NaveTransporteTerran();
		Marine marine = new Marine();
		
		nave.subirPasajero(marine);
		Collection<UnidadesTerran> pasajerosDescendidos= nave.descenderPasajeros();
		
		Assert.assertTrue(pasajerosDescendidos.contains(marine));
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

}
