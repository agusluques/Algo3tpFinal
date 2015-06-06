package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.construcciones.Atacable;
import fiuba.algo3.tpfinal.construcciones.Protoss;
import fiuba.algo3.tpfinal.programa.Danio;

public abstract class UnidadesProtoss extends Protoss implements Fabricable {
	
	protected Danio miDanio;
	protected int tiempoDeConstruccion;
	protected int suministro;
	
	public int getTiempoRestante(){
		return this.tiempoDeConstruccion;
	}
	
	public void avanzarFabricacion(){
		if (this.tiempoDeConstruccion > 0){
			this.tiempoDeConstruccion -= 1;
		}
	}
	
	//Es la cantidad que aumenta la poblacion cuando se construye uno
	public int getSuministro(){
		return this.suministro;
	}

	public void atacar(Atacable enemigo) {
		
		enemigo.atacado(miDanio);
		
	}
}
