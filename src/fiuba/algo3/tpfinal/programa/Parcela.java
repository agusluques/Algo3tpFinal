package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.ParcelaVacia;

public class Parcela {

	private Superficie superficie;
	private Atacable ocupante;
	
	public Parcela(Superficie superficie){
		this.superficie = superficie;
	}
	
	public Superficie getSuperficie(){
		return this.superficie;
	}
	
	public void ocupar(Atacable ocupante) throws ParcelaOcupada{
		
		if (!this.estaVacia()){
			ParcelaOcupada e = new ParcelaOcupada();
			throw e;
		}else{
			this.ocupante = ocupante;
		}
	}
	
	
	public Atacable getOcupante() throws ParcelaVacia{
		
		if(this.estaVacia()){
			ParcelaVacia e = new ParcelaVacia();
			throw e;
		}else{
			return this.ocupante;
		}
		
	}
	
	public boolean estaVacia(){
		return this.ocupante == null;
	}

	
}
