package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.EnergiaInsuficiente;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.Jugador;
import fiuba.algo3.tpfinal.programa.Mapa;

public class AltoTemplarioTest {

	@Test
	public void siSeCreaUnAltoTemplarioDebeTener40DeVidaY40DeEscudo(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 40);
		
	}
	
	@Test
	public void siAUnAltoTemplarioLePegan50DebeTener30DeVida(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0,50);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 30);
	}
	
	@Test
	public void siAUnAltoTemplarioLePegan800DebeTener0(){
		AltoTemplario altoTemplario = new AltoTemplario();
		Danio danio = new Danio(0,800);
		altoTemplario.atacado(danio);
		Assert.assertTrue(altoTemplario.getVida() == 0);
	}
	
	@Test
	public void siUnDragonAtacaAUnAltoTemplarioAlSegundoLeBajaElEscudoA20YNoBajaVida() {
		
		Dragon unDragon = new Dragon();
		AltoTemplario altoTemplario = new AltoTemplario();
		unDragon.atacar(altoTemplario);
		Assert.assertTrue(altoTemplario.getVida() == 40);
		Assert.assertTrue(altoTemplario.getEscudo() == 20);
		
	}

	@Test (expected = EnergiaInsuficiente.class)
	public void siUnAltoTemplarioIntentaCrearAlucinacionesSinTenerEnergiaSuficienteLanzaUnaExcepcion() throws EnergiaInsuficiente {
		
		AltoTemplario altoTemplario = new AltoTemplario();
		altoTemplario.crearAlucinaciones();
		
	}

	@Test
	public void siUnAltoTemplarioCreaIlusionesLasMismasAparecenEnLasUnidadesDelJugador() throws Exception, EnergiaInsuficiente {
		
		AltoTemplario altoTemplario = new AltoTemplario();
		Mapa mapa = new Mapa("mapaTierra.txt");
		Jugador jugador = new Jugador("Damian", mapa);
		int cantidadDeAlucinaciones=0;
		
		jugador.getConstrucciones().add(new Pilon());
		jugador.agregarUnidad(altoTemplario, new Coordenada(3,3));
		for (int i=0;i<4;i++){
			altoTemplario.pasarTurno();
		}
		altoTemplario.crearAlucinaciones();
		for(Atacable unidad : jugador.getUnidades()){
			if(unidad.getClass()==(new Alucinacion(10)).getClass()){
				cantidadDeAlucinaciones++;
			}
		}
		
		Assert.assertTrue(cantidadDeAlucinaciones == 2);
				
	}

}
