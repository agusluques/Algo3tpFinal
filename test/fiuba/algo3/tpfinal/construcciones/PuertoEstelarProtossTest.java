package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.PuertoEstelarProtoss;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.unidades.NaveTransporteProtoss;
import fiuba.algo3.tpfinal.unidades.Scout;


public class PuertoEstelarProtossTest {
	
	private PuertoEstelarProtoss puertoEstelar;

		
	@Test
	public void unPuertoEstelarDebeTener600DeVidaInicial() throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getVida() == 600);
	}

	@Test
	public void unPuertoEstelarDebeTener600DeEscudoInicial() throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getEscudo() == 600);
	}

	@Test
	public void unPuertoEstelarDebeCostar150Minerales() throws ConstruccionRequeridaInexistente {
		
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
	}
	
	@Test
	public void unPuertoEstelarDebeCostar150Gases() throws ConstruccionRequeridaInexistente {
		
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 150);
	}

	@Test
	public void unPuertoEstelarDebeCrearseEn10Turnos() throws ConstruccionRequeridaInexistente {
		
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getTiempo() == 10);
	}
	
	@Test
	public void dosPuertosEstelaresDeberianSerIguales() {
		this.puertoEstelar = new PuertoEstelarProtoss();
		Constructible otroPuerto = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.equals(otroPuerto));
	}

	@Test
	public void siFabricoUnScoutElMismoApareceEnLaListaDeUnidadesDelJugador() throws Exception{
		this.puertoEstelar = new PuertoEstelarProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Acceso(), new Coordenada(2,2));
		jugador.construir(this.puertoEstelar, new Coordenada(4,4));
		jugador.construir(new Pilon(), new Coordenada(6,6));
		this.puertoEstelar.fabricarScout();
		for (int i=0;i<9;i++){
			this.puertoEstelar.haceLoTuyo();
		}
		for(Atacable unidad : jugador.getUnidades()){
			Assert.assertTrue(unidad.getClass()==(new Scout()).getClass());
		}
		
	}
	
	@Test
	public void siFabricoUnaNaveDeTransporteProtossLaMismaApareceEnLaListaDeUnidadesDelJugador() throws Exception{
		this.puertoEstelar = new PuertoEstelarProtoss();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		
		jugador.getPresupuesto().agregarMineral(1000);
		jugador.getPresupuesto().agregarGas(1000);
		jugador.construir(new Acceso(), new Coordenada(2,2));
		jugador.construir(this.puertoEstelar, new Coordenada(4,4));
		jugador.construir(new Pilon(), new Coordenada(6,6));
		this.puertoEstelar.fabricarNaveDeTransporte();
		for (int i=0;i<8;i++){
			this.puertoEstelar.haceLoTuyo();
		}
		for(Atacable unidad : jugador.getUnidades()){
			Assert.assertTrue(unidad.getClass()==(new NaveTransporteProtoss()).getClass());
		}
		
	}

}
