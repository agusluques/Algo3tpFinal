package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.Marine;

public class BarracaTest {

	private Barraca barraca;

	@Before
	public void arrange() {
		this.barraca = new Barraca();
	}

	@Test
	public void unaBarracaDebeTener1000DeVida() {
		Assert.assertTrue(this.barraca.getVida() == 1000);
	}

	@Test
	public void unaBarracaDebeCostar150Minerales() {
		Assert.assertTrue(this.barraca.getCostoMineral() == 150);
	}

	@Test
	public void unaBarracaDebeCrearseEn12Turnos() {
		Assert.assertTrue(this.barraca.getTiempo() == 12);
	}
	
	@Test
	public void dosBarracasDeberianSerIguales() {
		Constructible otraBarraca = new Barraca();
		Assert.assertTrue(this.barraca.equals(otraBarraca));
	}


	@Test
	public void siPongoAConstruirUnMarineNoOcupaPoblacionHastaQueEstaTerminado() throws Exception{
		
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(this.barraca, new Coordenada(2,2));
		jugador.construir(new DepositoSuministro(),new Coordenada(4,4));
		this.barraca.fabricarMarine();
		
		Assert.assertTrue(jugador.contarPoblacion()==0);
	}
	
	@Test (expected = LimitePoblacionalAlcanzado.class )
	public void siFabricoUnMarineCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion() throws Throwable{
		
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(this.barraca, new Coordenada(2,2));
		this.barraca.fabricarMarine();
		for (int i=0;i<4;i++){
			this.barraca.haceLoTuyo();
		}
	}
	
	@Test
	public void siFabricoUnMarineCuandoEstaTerminadoAumentaLaPoblacion() throws Exception{
		
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.construir(this.barraca, new Coordenada(2,2));
		jugador.construir(new DepositoSuministro(),new Coordenada(4,4));
		this.barraca.fabricarMarine();
		for (int i=0;i<4;i++){
			this.barraca.haceLoTuyo();
		}
		Assert.assertTrue(jugador.contarPoblacion()==1);
	}
}
