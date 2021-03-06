package fiuba.algo3.tpfinal.programa;


import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.modelo.construcciones.ConstruccionProtoss;
import fiuba.algo3.tpfinal.modelo.construcciones.Pilon;
import fiuba.algo3.tpfinal.modelo.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.modelo.excepciones.GasInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.MineralInsuficiente;
import fiuba.algo3.tpfinal.modelo.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.modelo.excepciones.TerrenoInapropiado;
import fiuba.algo3.tpfinal.modelo.programa.Coordenada;
import fiuba.algo3.tpfinal.modelo.programa.JugadorProtoss;
import fiuba.algo3.tpfinal.modelo.programa.Mapa;

public class ArquitectoTest {

	private JugadorProtoss jugador;
	private Mapa mapa;

	@Before
	public void arrange() throws Exception {

		// Las pruebas se hacen con el archivo mapaTierra.txt, el cual es un
		// mapa valido
		this.mapa = new Mapa("mapaTierra.txt");
		this.jugador = new JugadorProtoss("Damian", this.mapa);

	}

	// @Test(expected = ParcelaOcupada.class)
	// public void
	// intentarConstruirEnUnaParcelaOcupadaDeberiaRetornarUnaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// ConstruccionProtoss construccion1 = new Pilon();
	// ConstruccionProtoss construccion2 = new Pilon();
	// Coordenada posicion = new Coordenada(3, 3);
	// jugador.construir(construccion1, posicion);
	// jugador.construir(construccion2, posicion);
	// }

	// @Test(expected = TerrenoInapropiado.class)
	// public void siIntentoConstruirUnEdificioEnElAireRetornaUnaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// ConstruccionProtoss construccion = new Pilon();
	// Coordenada posicion = new Coordenada(1, 50);
	// jugador.construir(construccion, posicion);
	//
	// }

	// @Test(expected = TerrenoInapropiado.class)
	// public void
	// siIntentoConstruirUnRecolectorDeGasEnTierraRetornaUnaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// Coordenada posicion = new Coordenada(3, 3);
	// ConstruccionProtoss construccion = new Asimilador(posicion);
	// jugador.construir(construccion, posicion);
	//
	// }

	// @Test(expected = TerrenoInapropiado.class)
	// public void
	// siIntentoConstruirUnRecolectorDeMineralesEnTierraRetornaUnaExcepcion()
	// throws ConstruccionRequeridaInexistente {
	// Coordenada posicion = new Coordenada(3, 3);
	// ConstruccionProtoss construccion = new NexoMineral(posicion);
	// jugador.construir(construccion, posicion);
	//
	// }

	@Test
	public void siElArquitectoConstruyeUnEdificioApareceInmediatamenteEnElMapa()
			throws ConstruccionRequeridaInexistente, MineralInsuficiente, GasInsuficiente, TerrenoInapropiado, ParcelaOcupada {
		ConstruccionProtoss construccion = new Pilon();
		Coordenada posicion = new Coordenada(3, 3);
		jugador.construir(construccion, posicion);
		Assert.assertTrue(construccion.equals(this.mapa.getParcela(posicion).getOcupante()));
	}

}
