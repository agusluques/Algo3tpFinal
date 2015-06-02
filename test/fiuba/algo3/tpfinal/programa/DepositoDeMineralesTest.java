package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.tpfinal.excepciones.RecursosAgotados;

public class DepositoDeMineralesTest {

	@Test
	public void losDepositosDeMineralesSeCreanCon1000Minerales(){
		
		DepositoDeMinerales deposito = new DepositoDeMinerales();
		Assert.assertTrue(deposito.getRecursos()==1000);
		
	}
	
	@Test(expected=RecursosAgotados.class)
	public void siIntentoExtraerMineralesDeUnDepositoAgotadoRetornaUnaExcepcion() throws RecursosAgotados{
		
		DepositoDeMinerales deposito = new DepositoDeMinerales(10);
		deposito.extraerRecursos(10);
		deposito.extraerRecursos(10);
		
		
	}
}
