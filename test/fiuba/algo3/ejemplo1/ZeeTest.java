package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;

public class ZeeTest {

	@Test
	public void doBarShouldReturnZee(){
        Zee zee = new Zee();
        String result = zee.doZee();
        Assert.assertEquals("Zee", result);
	}

}
