package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;
import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;


public class ArchivosTemplariosTest extends ConstruccionesProtoss {
	
	private ArchivosTemplarios archivo;
	

	@Test(expected = ConstruccionRequeridaInexistente.class)
	public void siNoSeCreaPuertoEstelarPreviamenteDeberiaLanzarExcepcionAlCrearse() throws ConstruccionRequeridaInexistente {
		this.archivo = new ArchivosTemplarios();
	}

	@Test
	public void unArchivoTemplarioDebeTener500DeVidaInicial() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getVida() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeTener500DeEscudoInicial() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getEscudo() == 500);
	}

	@Test
	public void unArchivoTemplarioDebeCostar150Minerales() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getCostoMineral() == 150);
	}
	
	@Test
	public void unArchivoTemplarioDebeCostar200Gases() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getCostoGas() == 200);
	}

	@Test
	public void unArchivoTemplarioDebeCrearseEn9Turnos() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		PuertoEstelarProtoss puerto = new PuertoEstelarProtoss();
		this.archivo = new ArchivosTemplarios();
		Assert.assertTrue(this.archivo.getTiempo() == 9);
	}

}
