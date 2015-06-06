package fiuba.algo3.tpfinal.construcciones;

import org.junit.Test;

import junit.framework.Assert;



import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.Fabrica;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class FabricaTest {

	private Fabrica fabrica;
	
	@Test
	public void debeTener1250DeVida() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getVida() == 1250);
		
	}
	
	@Test
	public void debeTardar12TurnosEnCrearse() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getTiempo() == 12);
	}
	
	@Test
	public void debeCostar200MineralesY100DeGas() throws ConstruccionRequeridaInexistente{
		this.fabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.getCostoMineral() == 200);
		Assert.assertTrue(this.fabrica.getCostoGas() == 100);
	}
	
	@Test
	public void dosFabricasDeberianSerIguales() {
		this.fabrica = new Fabrica();
		Constructible otraFabrica = new Fabrica();
		Assert.assertTrue(this.fabrica.equals(otraFabrica));
	}

	@Test
	public void siPongoAConstruirUnGolliatNoOcupaPoblacionHastaQueEstaTerminado() throws Exception{
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		jugador.construir(this.fabrica, new Coordenada(2,2));
		jugador.construir(new DepositoSuministro(),new Coordenada(6,6));
		this.fabrica.fabricarGolliat();
		
		Assert.assertTrue(jugador.contarPoblacion()==0);
	}
	
	@Test (expected = LimitePoblacionalAlcanzado.class )
	public void siFabricoUnGolliatCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion() throws Throwable{
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		jugador.construir(this.fabrica, new Coordenada(2,2));
		this.fabrica.fabricarGolliat();
		for (int i=0;i<74;i++){
			this.fabrica.haceLoTuyo();
		}
	}
	
	@Test
	public void siFabricoUnMarineCuandoEstaTerminadoAumentaLaPoblacion() throws Exception{
		this.fabrica = new Fabrica();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		jugador.construir(this.fabrica, new Coordenada(2,2));
		jugador.construir(new DepositoSuministro(),new Coordenada(6,6));
		this.fabrica.fabricarGolliat();
		for (int i=0;i<7;i++){
			this.fabrica.haceLoTuyo();
		}
		Assert.assertTrue(jugador.contarPoblacion()==2);
	}


}
