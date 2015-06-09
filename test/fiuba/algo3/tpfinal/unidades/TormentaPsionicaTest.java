package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class TormentaPsionicaTest {

	@Test
	public void siPongoUnaTormentaPsionicaLaMismaHace100DeDanioPorTurno() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador otroJugador = new Jugador("Luciano", mapa);
		Atacable golliat = new Golliat();
				
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)golliat, new Coordenada(3,3));
		
		TormentaPsionica tormenta = new TormentaPsionica(otroJugador,mapa,new Coordenada(4,4));
		tormenta.pasarTurno();
		
		Assert.assertTrue(((Golliat)golliat).getVida()==25);
		
	}
	
	@Test
	public void siUnaUnidadConMenosDe200DeVidaPermaneceEnLaTormentaPorMasDe2TurnosLaMismaMuere() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador otroJugador = new Jugador("Luciano", mapa);
		Atacable golliat = new Golliat();
				
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)golliat, new Coordenada(3,3));
		
		TormentaPsionica tormenta = new TormentaPsionica(otroJugador,mapa,new Coordenada(4,4));
		tormenta.pasarTurno();
		tormenta.pasarTurno();
		
		Assert.assertTrue(golliat.estaMuerto());
	
	}
	
	@Test
	public void unaTormentaNoHaceMasDanioDespuesDe2Turnos() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador otroJugador = new Jugador("Luciano", mapa);
		Atacable scout = new Scout();
				
		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad((Fabricable)scout, new Coordenada(3,3));
		
		TormentaPsionica tormenta = new TormentaPsionica(otroJugador,mapa,new Coordenada(4,4));
		for (int i = 1; i<=3;i++){
			tormenta.pasarTurno();
		}
		
		Assert.assertTrue(((Scout)scout).getVida()==50);
	
	}
	
	@Test
	public void siUnaUnidadAliadaEstaEncimaDeUnaTormentaNoRecibeDanio() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Atacable golliat = new Golliat();
				
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)golliat, new Coordenada(3,3));
		
		TormentaPsionica tormenta = new TormentaPsionica(jugador,mapa,new Coordenada(4,4));
		tormenta.pasarTurno();
	
		Assert.assertTrue(((Golliat)golliat).getVida()==125);
	
	}
	
	

}
