package pruebasDeIntegracion;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Barraca;
import fiuba.algo3.tpfinal.construcciones.CentroDeMineral;
import fiuba.algo3.tpfinal.construcciones.ConstruccionTerran;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Juego;
import fiuba.algo3.tpfinal.programa.JugadorTerran;
import fiuba.algo3.tpfinal.programa.Mapa;

public class JuegoTest {
	
	@Before
	public void arrange() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		JugadorTerran jugadorUno = new JugadorTerran("Pablo", mapa);
		JugadorTerran jugadorDos = new JugadorTerran("Nico", mapa);
		Juego juego = new Juego(jugadorUno, jugadorDos);
		
		juego.empezarTurno(jugadorUno);
		//LA COORDENADA DE CENTRODEMINERAL ESTA MAL, NO LA DEBERIA PEDIR
		ConstruccionTerran centroMineral = new CentroDeMineral(new Coordenada(1,91));
		ConstruccionTerran barraca = new Barraca();
		jugadorUno.construir(centroMineral, new Coordenada(1,91) );
		jugadorUno.construir(barraca, new Coordenada(20,92) );
		
		juego.pasarTurno(jugadorUno);
		juego.empezarTurno(jugadorDos);
		
		//LA COORDENADA DE CENTRODEMINERAL ESTA MAL, NO LA DEBERIA PEDIR
		ConstruccionTerran centroMineralDos = new CentroDeMineral(new Coordenada(1,91));
		ConstruccionTerran barracaDos = new Barraca();
		jugadorDos.construir(centroMineralDos, new Coordenada(75,23) );
		jugadorDos.construir(barracaDos, new Coordenada(67,27) );
		
		juego.pasarTurno(jugadorDos);
		juego.empezarTurno(jugadorUno);
		
		Assert.assertTrue(jugadorUno.getPresupuesto().cantidadDeMineral() == 0);
		Assert.assertTrue(jugadorDos.getPresupuesto().cantidadDeMineral() == 0);
		
		
		for (int i = 0; i<4; i++){
			juego.pasarTurno(jugadorUno);
			juego.pasarTurno(jugadorDos);
		}
		
		Assert.assertTrue(jugadorUno.getPresupuesto().cantidadDeMineral() == 10);
		Assert.assertTrue(jugadorDos.getPresupuesto().cantidadDeMineral() == 10);
		
		
		
		
	}

	@Test
	public void siElJugadorUnoDestruyeTodosLosEdificiosYUnidadesDelJugadorDosGanaJugadorUno(){
		System.out.print("PABLO CRACK");
	}

}
