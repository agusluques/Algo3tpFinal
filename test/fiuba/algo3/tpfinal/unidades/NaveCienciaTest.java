package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.DepositoSuministro;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.construcciones.Protoss;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.excepciones.MovimientoInvalido;
import fiuba.algo3.tpfinal.excepciones.UnidadInvalida;
import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.DepositoDeGas;
import fiuba.algo3.tpfinal.programa.DepositoDeMinerales;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;
import fiuba.algo3.tpfinal.programa.Superficie;
import fiuba.algo3.tpfinal.programa.Tierra;

public class NaveCienciaTest {

	@Test
	public void siSeCreaUnaNaveCienciaDebeTener200DeVida(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Assert.assertTrue(naveCiencia.getVida() == 200);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan100DebeTener100(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(100,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 100);
	}
	
	@Test
	public void siAUnaNaveCienciaLePegan800DebeTener0(){
		NaveCiencia naveCiencia = new NaveCiencia();
		Danio danio = new Danio(800,0);
		naveCiencia.atacado(danio);
		Assert.assertTrue(naveCiencia.getVida() == 0);
	}
	
	@Test
	public void siUnEspectroAtacaAUnaNaveCienciaAlSegundoLeBajaLaVidaA180() {
		
		Espectro unEspectro = new Espectro();
		NaveCiencia unaNaveCiencia = new NaveCiencia();
		unEspectro.atacar(unaNaveCiencia);
		Assert.assertTrue(unaNaveCiencia.getVida() == 180);
	}
	
	@Test
	public void unaNaveCienciaSePuedeMoverEnLaTierraYEnElAirePeroNoEnMineralYGas() {
		NaveCiencia unidad = new NaveCiencia();
		
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Aire()));
		Assert.assertTrue(unidad.sePuedeMoverA((Superficie) new Tierra()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeGas()));
		Assert.assertFalse(unidad.sePuedeMoverA((Superficie) new DepositoDeMinerales()));
	}
	
	@Test
	public void unNaveCienciaSePuedeMoverAUnaCeldaVecinaSiHayTierra() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test
	public void unNaveCienciaSePuedeMoverAOtraCeldaSiHayAire() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,50);
		unidad.trasladarA(destino, mapa);
		
		Assert.assertEquals(destino, unidad.getCoordenada());
		Assert.assertEquals(unidad, mapa.getParcela(destino).getOcupante());
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiHayMineral() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,100);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiHayGas() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,51), unidad);
		Coordenada destino = new Coordenada(1,90);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void unNaveCienciaNoSePuedeMoverAOtraCeldaSiEstaOcupada() throws Exception {
		NaveCiencia unidad = new NaveCiencia();
		Zealot zealot = new Zealot();
		Mapa mapa = new Mapa("mapaTierra.txt");
		
		mapa.insertarUnidad(new Coordenada(1,1), unidad);
		Coordenada destino = new Coordenada(1,2);
		mapa.insertarUnidad(destino, zealot);
		unidad.trasladarA(destino, mapa);
	}
	
	@Test (expected = UnidadInvalida.class)
	public void siIntentoIrradiarUnaUnidadAliadaRetornaUnaExcepcion() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable marine = new Marine();
		for (int i=1;i<5;i++){
			nave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)nave, new Coordenada(3,3));
		jugador.agregarUnidad((Fabricable)marine, new Coordenada(2,3));
			
		nave.irradiar(marine);
	
	}
	
	@Test
	public void devuelveElRangoDeAtaqueCorrespondiente() {
		NaveCiencia unidad = new NaveCiencia();
		Rango rango = new Rango(1,2);
		
		Assert.assertEquals(2, unidad.rangoDeAtaqueCorrespondiente(rango));
	}

	@Test 
	public void siIntentoIrradiarUnaUnidadCuandoNoTengoEnergiaRetornaUnaExcepcion() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador jugador2 = new Jugador("Luciano", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable marine = new Marine();
		for (int i=1;i<5;i++){
			nave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)nave, new Coordenada(3,3));
		jugador2.agregarUnidad((Fabricable)marine, new Coordenada(3,3));
	
		nave.irradiar(marine);
	
	}

	@Test (expected = EnergiaInsuficiente.class)
	public void siIntentoLanzarUnEMPCuandoNoTengoEnergiaRetormaUnaExcepcion() throws Exception{
	
		NaveCiencia nave = new NaveCiencia();
		
		nave.lanzarEMP(new Coordenada(3,3));
	
	}

	@Test
	public void siLeTiroUnEMPAUnaUnidadProtossLaMismaPierdeElEscudo() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador jugador2 = new Jugador("Luciano", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable zealot = new Zealot();
		for (int i=1;i<6;i++){
			nave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad((Fabricable)nave, new Coordenada(2,2));
		jugador2.agregarUnidad((Fabricable)zealot, new Coordenada(5,5));
	
		nave.lanzarEMP(new Coordenada(4,4));
		Assert.assertTrue(((Protoss)zealot).getEscudo()==0);
	
	}
	
	@Test
	public void siLeTiroUnEMPAUnaUnidadConEnergiaLaPierdeToda() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		Jugador jugador2 = new Jugador("Luciano", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable templar = new AltoTemplario();
		for (int i=1;i<6;i++){
			nave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador2.getConstrucciones().add(new Pilon());
		
		jugador.agregarUnidad((Fabricable)nave, new Coordenada(2,2));
		jugador2.agregarUnidad((Fabricable)templar, new Coordenada(5,5));
	
		nave.lanzarEMP(new Coordenada(4,4));
		Assert.assertTrue(((Protoss)templar).getEscudo()==0);
		Assert.assertTrue( ((AltoTemplario)templar).getEnergia()==0  );
	
	}
	
	@Test
	public void siLeLanzoUnEMPAUnaUnidadAliadaNoLeAfecta() throws Exception{
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		NaveCiencia nave = new NaveCiencia();
		Atacable templar = new AltoTemplario();
		for (int i=1;i<6;i++){
			nave.pasarTurno();
		}
		jugador.getConstrucciones().add(new DepositoSuministro());
		jugador.agregarUnidad((Fabricable)nave, new Coordenada(2,2));
		jugador.agregarUnidad((Fabricable)templar, new Coordenada(5,5));
	
		nave.lanzarEMP(new Coordenada(4,4));
		Assert.assertTrue(((Protoss)templar).getEscudo()==40);
		Assert.assertTrue( ((AltoTemplario)templar).getEnergia()==50  );
	
	}

	
}
