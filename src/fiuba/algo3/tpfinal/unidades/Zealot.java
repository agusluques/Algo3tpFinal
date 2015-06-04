package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Zealot extends UnidadesProtoss{
	
	public Zealot(){
		vida.inicializarVida(60);
		escudo.inicializarEscudo(60);
		miDanio = new Danio(8);
	}


}
