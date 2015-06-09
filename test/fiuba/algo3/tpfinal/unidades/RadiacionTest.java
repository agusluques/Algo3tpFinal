package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class RadiacionTest {

	@Test
	public void siIrradioUnaUnidadLaMismaPierde30DeVidaPorTurno() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Atacable marine = new Marine();
				
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)marine, new Coordenada(3,3));
		Radiacion unaRadiacion = new Radiacion(marine);
		unaRadiacion.pasarTurno();
		
		Assert.assertTrue(((Marine)marine).getVida()==10);
		
	}
	
	
	@Test
	public void siIrradioUnaUnidadSusAliadasCercanasTambienSufranDanio() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Atacable marine = new Marine();
		Atacable marine2 = new Marine();
		Atacable marine3 = new Marine();
		
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)marine, new Coordenada(3,3));
		jugador.agregarUnidad((Fabricable)marine2, new Coordenada(2,3));
		jugador.agregarUnidad((Fabricable)marine3, new Coordenada(3,2));
		
		Radiacion unaRadiacion = new Radiacion(marine);
		unaRadiacion.pasarTurno();
		Assert.assertTrue(((Marine)marine2).getVida()==10);
		Assert.assertTrue(((Marine)marine3).getVida()==10);
		
		
	}
	
	@Test
	public void siUnaUnidadIrradiadaEstaCercaDeUnaUnidadHostilLaSegundaNoSufreDanio() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador unJugador = new Jugador("Damian", mapa);
		Jugador otroJugador = new Jugador("Luciano", mapa);
		Atacable unMarine = new Marine();
		Atacable otroMarine = new Marine();
	
		unJugador.getConstrucciones().add(new DepositoSuministro());
		otroJugador.getConstrucciones().add(new DepositoSuministro());
		
		unJugador.agregarUnidad((Fabricable)unMarine, new Coordenada(3,3));
		otroJugador.agregarUnidad((Fabricable)otroMarine, new Coordenada(2,3));
		
		Radiacion unaRadiacion = new Radiacion(unMarine);
		unaRadiacion.pasarTurno();
		
		Assert.assertTrue(((Marine)unMarine).getVida()==10);
		Assert.assertTrue(((Marine)otroMarine).getVida()==40);
		
		
	}
}
