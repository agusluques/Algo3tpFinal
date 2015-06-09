package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Zealot extends UnidadesProtoss{
	
	public Zealot(){
		vida.inicializarVida(60);
		escudo.inicializarEscudo(60);
		miDanio = new Danio(0,8);
		this.tiempoDeConstruccion = 4;
		this.suministro = 2;
		this.costo = new Costo(100);
		this.transporte = 2;
		this.rango = new Rango (1,0);
		
		//se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0,0);
		
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}


}
