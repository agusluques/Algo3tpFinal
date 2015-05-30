package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ArchivosTemplariosTest extends ConstruccionesProtoss {
	
	private ArchivosTemplarios archivo;

	@Before
	public void arrange() {
		this.archivo = new ArchivosTemplarios();
	}

	@Test
	public void unArchivoTemplarioDebeTener500DeVidaInicial() {
		Assert.assertTrue(this.archivo.getVida() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeTener500DeEscudoInicial() {
		Assert.assertTrue(this.archivo.getEscudo() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeCostar150Minerales() {
		Assert.assertTrue(this.archivo.getCostoMineral() == 150);
	}
	
	@Test
	public void unArchivoTemplarioDebeCostar200Gases() {
		Assert.assertTrue(this.archivo.getCostoGas() == 200);
	}

	@Test
	public void unArchivoTemplarioDebeCrearseEn9Turnos() {
		Assert.assertTrue(this.archivo.getTiempo() == 9);
	}

}
