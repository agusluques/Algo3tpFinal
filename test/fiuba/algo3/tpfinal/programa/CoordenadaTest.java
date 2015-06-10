package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;

import org.junit.Test;

public class CoordenadaTest {

	@Test
	public void siCreoDosInstanciasDeCoordenadasConLaMismaFilaYColumnaSonIguales() {

		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 3);
		Assert.assertTrue(coord1.equals(coord2));
	}

	@Test
	public void siCreoDosInstanciasDeCoordenadasConLaMismaFilaYColumnaTienenElMismoHashcode() {

		Coordenada coord1 = new Coordenada(3, 3);
		Coordenada coord2 = new Coordenada(3, 3);
		Assert.assertEquals(coord1.hashCode(), coord2.hashCode());
	}

	@Test
	public void siMuevoLaCoordenadaALaFila5Columna6SeDebeMover() {
		Coordenada coordenada = new Coordenada(0, 0);
		coordenada.mover(5, 5);
		Assert.assertTrue(coordenada.getFila() == 5);
		Assert.assertTrue(coordenada.getColumna() == 5);

	}
}
