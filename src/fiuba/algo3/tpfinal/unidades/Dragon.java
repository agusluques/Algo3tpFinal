package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Dragon extends UnidadesProtoss {
	public Dragon(){
		this.vida.inicializarVida(100);
		this.escudo.inicializarEscudo(80);
		this.miDanio = new Danio(20,20);
		this.tiempoDeConstruccion = 6;
		this.suministro = 2;
		this.costo = new Costo(125,50);
	}
}
