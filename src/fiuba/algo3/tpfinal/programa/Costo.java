package fiuba.algo3.tpfinal.programa;

public class Costo {
	private int minerales;
	private int gas;
	
	public Costo(int minerales) {
		this.minerales = minerales;
		this.gas = 0;
	}
	
	public Costo(int minerales, int gas) {
		this.minerales = minerales;
		this.gas = gas;
	}
	
	public int getMinerales() {
		return minerales;
	}

	public int getGas() {
		return gas;
	}
}
