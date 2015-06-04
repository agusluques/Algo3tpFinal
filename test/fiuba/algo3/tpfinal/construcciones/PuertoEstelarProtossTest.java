package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.tpfinal.excepciones.ConstruccionRequeridaInexistente;
import fiuba.algo3.tpfinal.unidades.Constructible;
import fiuba.algo3.tpfinal.unidades.PuertoEstelarProtoss;

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

}
