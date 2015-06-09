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
import fiuba.algo3.tpfinal.unidades.Rango;
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
		Assert.assertTrue(this.acceso.getTiempoRestante() == 8);
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
		jugador.construir(acceso, new Coordenada(1,1));
		for (int i=0;i<8;i++){
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(),  new Coordenada(1,2));
		for (int i=0;i<5;i++){
			jugador.pasarTurno();
		}
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
		jugador.construir(acceso, new Coordenada(1,1));
		for (int i=0;i<8;i++){
			jugador.pasarTurno();
		}
		jugador.construir(new Pilon(),  new Coordenada(1,2));
		for (int i=0;i<5;i++){
			jugador.pasarTurno();
		}
		this.acceso.fabricarDragon();
		for (int i=0;i<6;i++){
			this.acceso.haceLoTuyo();
		}
		for(Atacable unidad : jugador.getUnidades()){
			Assert.assertTrue(unidad.getClass()==(new Dragon()).getClass());
		}
		
	}
	
	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		Rango rango = new Rango(1,2);
		
		Assert.assertEquals(1,  acceso.rangoDeAtaqueCorrespondiente(rango));
	}

}
