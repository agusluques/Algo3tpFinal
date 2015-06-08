package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Alucinacion extends UnidadesProtoss{
	public Alucinacion(int escudo){
		this.vida.inicializarVida(0);
		this.escudo.inicializarEscudo(escudo);
		this.miDanio = new Danio(0,0);
		this.suministro = 0;
	}
}
