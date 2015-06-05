package fiuba.algo3.tpfinal.construcciones;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.tpfinal.construcciones.Constructible;
import fiuba.algo3.tpfinal.construcciones.Refineria;
import fiuba.algo3.tpfinal.programa.Coordenada;

public class RefineriaTest {

	private Refineria refineria;

	@Before
	public void arrange(){
		this.refineria = new Refineria(new Coordenada(1, 90));
	}

	@Test
	public void debeTenerVidaIgualA750(){
		Assert.assertTrue(this.refineria.getVida() == 750);
	}
	
	@Test
	public void debeTardar6TurnosEnCrearse(){
		Assert.assertTrue(this.refineria.getTiempo() == 6);
	}
	
	@Test
	public void debeCostar100Minerales(){
		Assert.assertTrue(this.refineria.getCostoMineral() == 100);
	}
	
	@Test
	public void dosRefineriasDeberianSerIguales() {
		Constructible otraRefineria = new Refineria(new Coordenada(1, 90));
		Assert.assertTrue(this.refineria.equals(otraRefineria));
	}
}
