package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.excepciones.RecursosAgotados;

public class DepositoDeGas implements Superficie {
	
	private String nombre = "depositoDeGas";
	private int gasRestante;
	
	public DepositoDeGas(){
		gasRestante = 3000;
	}
	
	//Constructor creado solo para probar la excepcion
	public DepositoDeGas(int minerales){
		
		gasRestante = minerales;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	public void extraerRecursos(int cantidad) throws RecursosAgotados{
		
		if (this.gasRestante == 0) {
			
			RecursosAgotados e = new RecursosAgotados();
			throw e;
		
		}else{
			this.gasRestante -= cantidad;
		}
		
	}

	public int getRecursos(){
		return this.gasRestante;
	}

	@Override
	public boolean equals(Object o){
		Superficie sup = (Superficie) o;
		return (this.nombre == sup.getNombre());
	}
	
	@Override
	public int hashCode(){
		return nombre.hashCode();
		
	}
}
