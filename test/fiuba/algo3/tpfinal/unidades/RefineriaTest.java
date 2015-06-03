package fiuba.algo3.tpfinal.unidades;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RefineriaTest {

	private Refineria refineria;

	@Before
	public void arrange(){
		this.refineria = new Refineria();
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
		Constructible otraRefineria = new Refineria();
		Assert.assertTrue(this.refineria.equals(otraRefineria));
	}
}
