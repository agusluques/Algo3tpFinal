package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Dragon extends UnidadProtoss {
	public Dragon(){
		this.vida.inicializarVida(100);
		this.escudo.inicializarEscudo(80);
		this.miDanio = new Danio(20,20);
		this.tiempoDeConstruccion = 6;
		this.suministro = 2;
		this.costo = new Costo(125,50);
		this.transporte = 4;
		this.rango = new Rango(4,4);
		
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}
}
