package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;

public class PuertoEstelarProtossTest {
	
	private PuertoEstelarProtoss puertoEstelar;
	
	

	@Test (expected = ConstruccionRequeridaInexistente.class)
	public void siNoTieneElAccesoDeberiaLazarExcepcionAlCreala() throws ConstruccionRequeridaInexistente {
		this.puertoEstelar = new PuertoEstelarProtoss();
	}

		
	@Test
	public void unPuertoEstelarDebeTener600DeVidaInicial() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getVida() == 600);
	}

	@Test
	public void unPuertoEstelarDebeTener600DeEscudoInicial() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getEscudo() == 600);
	}

	@Test
	public void unPuertoEstelarDebeCostar150Minerales() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCostoMineral() == 150);
	}
	
	@Test
	public void unPuertoEstelarDebeCostar150Gases() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getCostoGas() == 150);
	}

	@Test
	public void unPuertoEstelarDebeCrearseEn10Turnos() throws ConstruccionRequeridaInexistente {
		@SuppressWarnings("unused")//se usa para que no lance excepcion en pruebas
		Acceso acceso = new Acceso();
		this.puertoEstelar = new PuertoEstelarProtoss();
		Assert.assertTrue(this.puertoEstelar.getTiempo() == 10);
	}

}
