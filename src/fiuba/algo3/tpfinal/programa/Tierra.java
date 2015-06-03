package fiuba.algo3.tpfinal.programa;

public class Tierra implements Superficie {
	
	private String nombre = "tierra";
	
	@Override
	public String getNombre() {
		return nombre;
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
