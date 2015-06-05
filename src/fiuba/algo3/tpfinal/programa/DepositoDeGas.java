package fiuba.algo3.tpfinal.programa;


public class DepositoDeGas extends Superficie {
	
	private int gasRestante;
	
	public DepositoDeGas(){
		gasRestante = 3000;
		nombre = "depositoDeGas";
	}
	

	public int extraerRecursos() {
		if (this.gasRestante > 0) {
			this.gasRestante -= 10;
			return 10;
		}
		return 0;
	}

	public int getRecursos(){
		return this.gasRestante;
	}
	

}
