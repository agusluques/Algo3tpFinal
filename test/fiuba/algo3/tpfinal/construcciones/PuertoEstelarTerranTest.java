package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarTerran;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.LimitePoblacionalAlcanzado;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class PuertoEstelarTerranTest {

	private PuertoEstelarTerran puertoEstelar;

	@Test
	public void debeTener1300DeVida() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getVida() == 1300);
		
	}
	
	@Test
	public void debeTardar10TurnosEnCrearse() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getTiempoRestante() == 10);
	}
	
	@Test
	public void debeCostar150MineralesY100DeGas() throws ConstruccionRequeridaInexistente{
		this.puertoEstelar = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 100);
	}
	
	@Test
	public void dosPuertosEstelaresDeberianSerIguales() {
		this.puertoEstelar = new PuertoEstelarTerran();
		Constructible otroPuerto = new PuertoEstelarTerran();
		Assert.assertTrue(this.puertoEstelar.equals(otroPuerto));
	}

	@Test
	public void siPongoAConstruirUnEspectroNoOcupaPoblacionHastaQueEstaTerminado() throws Exception{
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();
		
		Assert.assertTrue(jugador.contarPoblacion()==0);
	}
	
	@Test (expected = LimitePoblacionalAlcanzado.class )
	public void siFabricoUnEspectroCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion() throws Throwable{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();
		for (int i=0;i<8;i++){
			this.puertoEstelar.haceLoTuyo();
		}
	}
	
	@Test
	public void siFabricoUnEspectroCuandoEstaTerminadoAumentaLaPoblacion() throws Exception{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(),new Coordenada(6,6));
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarEspectro();
		for (int i=0;i<8;i++){
			this.puertoEstelar.haceLoTuyo();
		}
		Assert.assertTrue(jugador.contarPoblacion()==2);
	}


	@Test
	public void siPongoAConstruirUnaNaveDeCienciaNoOcupaPoblacionHastaQueEstaTerminado() throws Exception{
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();
		
		Assert.assertTrue(jugador.contarPoblacion()==0);
	}
	
	@Test (expected = LimitePoblacionalAlcanzado.class )
	public void siFabricoUnaNaveDeCienciaCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion() throws Throwable{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();
		for (int i=0;i<10;i++){
			this.puertoEstelar.haceLoTuyo();
		}
	}
	
	@Test
	public void siFabricoUnaNaveDeCienciaCuandoEstaTerminadoAumentaLaPoblacion() throws Exception{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(),new Coordenada(6,6));
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeCiencia();
		for (int i=0;i<10;i++){
			this.puertoEstelar.haceLoTuyo();
		}
		Assert.assertTrue(jugador.contarPoblacion()==2);
	}


	@Test
	public void siPongoAConstruirUnaNaveDeTransporteNoOcupaPoblacionHastaQueEstaTerminado() throws Exception{
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		
		Assert.assertTrue(jugador.contarPoblacion()==0);
	}
	
	@Test (expected = LimitePoblacionalAlcanzado.class )
	public void siFabricoUnaNaveDeTransporteCuandoEstoyAlMaximoDePoblacionRetornaUnaExcepcion() throws Throwable{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i=0;i<10;i++){
			this.puertoEstelar.haceLoTuyo();
		}
	}
	
	@Test
	public void siFabricoUnaNaveDeTransporteCuandoEstaTerminadoAumentaLaPoblacion() throws Exception{
		
		this.puertoEstelar = new PuertoEstelarTerran();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Barraca(), new Coordenada(4,4));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new Fabrica(), new Coordenada(2,2));
		for(int i = 0; i < 12; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(this.puertoEstelar, new Coordenada(1,1));
		for(int i = 0; i < 10; i++) {
			jugador.pasarTurno();
		}
		jugador.construir(new DepositoSuministro(),new Coordenada(6,6));
		for(int i = 0; i < 6; i++) {
			jugador.pasarTurno();
		}
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i=0;i<7;i++){
			this.puertoEstelar.haceLoTuyo();
		}
		Assert.assertTrue(jugador.contarPoblacion()==2);
	
	
	}
}

