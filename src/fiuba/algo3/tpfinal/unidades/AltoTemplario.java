package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class AltoTemplario extends UnidadesProtoss {
	public AltoTemplario(){
		this.vida.inicializarVida(40);
		this.escudo.inicializarEscudo(40);
		this.miDanio = new Danio(0,0);
	}
	
	
}