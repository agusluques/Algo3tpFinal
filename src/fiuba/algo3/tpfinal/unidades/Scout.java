package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Scout extends UnidadesProtoss {

	public Scout(){
		this.vida.inicializarVida(150);
		this.escudo.inicializarEscudo(100);
		this.miDanio = new Danio(14,8);
	}
	
	public void atacado(Danio danio){
		this.escudo.bajarEscudo(danio.getDanioAire(), this.vida);
	}
}
