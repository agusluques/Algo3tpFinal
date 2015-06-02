package fiuba.algo3.tpfinal.programa;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.tpfinal.excepciones.RecursosAgotados;

public class DepositoDeGasTest {

	@Test
	public void losDepositosDeGasSeCreanCon3000Minerales(){
		
		DepositoDeGas deposito = new DepositoDeGas();
		Assert.assertTrue(deposito.getRecursos()==3000);
		
	}
	
	@Test(expected=RecursosAgotados.class)
	public void siIntentoExtraerGasDeUnDepositoAgotadoRetornaUnaExcepcion() throws RecursosAgotados{
		
		DepositoDeGas deposito = new DepositoDeGas(10);
		deposito.extraerRecursos(10);
		deposito.extraerRecursos(10);
		
		
	}
}
