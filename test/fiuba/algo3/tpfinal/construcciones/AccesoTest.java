package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Acceso;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Dragon;
import fiuba.algo3.tpfinal.unidades.Zealot;

public class AccesoTest {
	
	private Acceso acceso;

	@Before
	public void arrenge() {
		this.acceso = new Acceso();
	}

	@Test
	public void unAccesoDebeTener500DeVidaInicial() {
		Assert.assertTrue(this.acceso.getVida() == 500);
	}

	@Test
	public void unAccesoDebeTener500DeEscudoInicial() {
		Assert.assertTrue(this.acceso.getEscudo() == 500);
	}

	@Test
	public void unAccesoDebeCostar150Minerales() {
		Assert.assertTrue(this.acceso.getCostoMineral() == 150);
	}
	
	@Test
	public void unAccesoDebeCostar0Gases() {
		Assert.assertTrue(this.acceso.getCostoGas() == 0);
	}

	@Test
	public void unAccesoDebeCrearseEn8Turnos() {
		Assert.assertTrue(this.acceso.getTiempo() == 8);
	}
	
	@Test
	public void dosAccesosDeberianSerIguales() {
		Constructible otroAcceso = new Acceso();
		Assert.assertTrue(this.acceso.equals(otroAcceso));
	}

	@Test
	public void siFabricoUnZealotElMismoApareceEnLaListaDeUnidadesDelJugador() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(this.acceso, new Coordenada(4,4));
		jugador.construir(new Pilon(), new Coordenada(2,2));
		this.acceso.fabricarZealot();
		for (int i=0;i<4;i++){
			this.acceso.haceLoTuyo();
		}
		for(Atacable unidad : jugador.getUnidades()){
			Assert.assertTrue(unidad.getClass()==(new Zealot()).getClass());
		}
		
	}
	
	@Test
	public void siFabricoUnDragonElMismoApareceEnLaListaDeUnidadesDelJugador() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(this.acceso, new Coordenada(4,4));
		jugador.construir(new Pilon(), new Coordenada(2,2));
		this.acceso.fabricarDragon();
		for (int i=0;i<6;i++){
			this.acceso.haceLoTuyo();
		}
		for(Atacable unidad : jugador.getUnidades()){
			Assert.assertTrue(unidad.getClass()==(new Dragon()).getClass());
		}
		
	}

}
