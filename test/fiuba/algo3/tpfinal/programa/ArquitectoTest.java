package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Asimilador;
import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.NexoMineral;
import fiuba.algo3.tpfinal.construcciones.Pilon;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.TerrenoInapropiado;

public class ArquitectoTest {

	private Jugador jugador;
	private Mapa mapa;

	

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un mapa valido
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugador = new Jugador("Damian", this.mapa);

	}

	@Test(expected = ParcelaOcupada.class)
	public void intentarConstruirEnUnaParcelaOcupadaDeberiaRetornarUnaExcepcion() throws ConstruccionRequeridaInexistente{
		Constructible construccion1 = new Pilon();
		Constructible construccion2 = new Pilon();
		Coordenada posicion = new Coordenada(3,3);
		jugador.construir(construccion1, posicion);
		jugador.construir(construccion2, posicion);
	}


	@Test (expected = TerrenoInapropiado.class)
	public void siIntentoConstruirUnEdificioEnElAireRetornaUnaExcepcion() throws ConstruccionRequeridaInexistente{
		Constructible construccion = new Pilon();
		Coordenada posicion = new Coordenada(1,50);
		jugador.construir(construccion, posicion);
				
	}
	
	@Test (expected = TerrenoInapropiado.class)
	public void siIntentoConstruirUnRecolectorDeGasEnTierraRetornaUnaExcepcion() throws ConstruccionRequeridaInexistente{
		Coordenada posicion = new Coordenada(3,3);
		Constructible construccion = new Asimilador(posicion);		
		jugador.construir(construccion, posicion);
				
	}
	
	@Test (expected = TerrenoInapropiado.class)
	public void siIntentoConstruirUnRecolectorDeMineralesEnTierraRetornaUnaExcepcion() throws ConstruccionRequeridaInexistente{
		Coordenada posicion = new Coordenada(3,3);
		Constructible construccion = new NexoMineral(posicion);		
		jugador.construir(construccion, posicion);
				
	}
	
	@Test
	public void siElArquitectoConstruyeUnEdificioElMismoApareceEnElMapa() throws ConstruccionRequeridaInexistente{
		Constructible construccion = new Pilon();
		Coordenada posicion = new Coordenada(3,3);
		jugador.construir(construccion, posicion);
		Assert.assertTrue(construccion.equals(this.mapa.getParcela(posicion).getOcupante()));
	}
	

}
