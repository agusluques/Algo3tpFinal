package fiuba.algo3.tpfinal.programa;

import fiuba.algo3.tpfinal.excepciones.ParcelaOcupada;
import fiuba.algo3.tpfinal.excepciones.ParcelaVacia;
import fiuba.algo3.tpfinal.unidades.Atacable;

public class Parcela {

	private Superficie superficie;
	private Atacable ocupante;
	private boolean ocupada = false;
	
	public Parcela(Superficie superficie){
		this.superficie = superficie;
	}
	
	public Superficie getSuperficie(){
		return this.superficie;
	}
	
	public void ocupar(Atacable ocupante) throws ParcelaOcupada{
		
		if (ocupada){
			ParcelaOcupada e = new ParcelaOcupada();
			throw e;
		}else{
			this.ocupante = ocupante;
			ocupada = true;
		}
	}
	
	
	public Atacable getOcupante() throws ParcelaVacia{
		
		if(!ocupada){
			ParcelaVacia e = new ParcelaVacia();
			throw e;
		}else{
			return this.ocupante;
		}
		
	}
	
	public boolean estaVacia(){
		
		return !this.ocupada;
	}

	
}
