package fiuba.algo3.tpfinal.programa;
import fiuba.algo3.tpfinal.excepciones.RecursosAgotados;

public class DepositoDeMinerales implements Superficie {
	
	private String nombre = "depositoDeMinerales";
	private int mineralesRestantes;
	
	public DepositoDeMinerales(){
		mineralesRestantes = 1000;
	}
	
	//Constructor creado solo para probar la excepcion
	public DepositoDeMinerales(int minerales){
		
		mineralesRestantes = minerales;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	public void extraerRecursos(int cantidad) throws RecursosAgotados{
		
		if (this.mineralesRestantes == 0) {
			
			RecursosAgotados e = new RecursosAgotados();
			throw e;
		
		}else{
			this.mineralesRestantes -= cantidad;
		}
		
	}

	public int getRecursos(){
		return this.mineralesRestantes;
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
