package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Danio;

public class Marine extends UnidadesTerran implements Fabricable{
	
	protected int tiempoDeConstruccion = 3;
	protected int suministro = 1;
	
	
	
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
	
	public Marine(){
		this.vida.inicializarVida(40);
		this.miDanio = new Danio(6,6);
		this.rango = new Rango(4,0);
		
		//ACA HAY QUE PEDIR EN EL CONSTRUCTOR QUE SE INDIQUE LA COORDENADA DE ARRANQUE
		this.posicion = new Coordenada(0,0);

		
	}
	
	
}
