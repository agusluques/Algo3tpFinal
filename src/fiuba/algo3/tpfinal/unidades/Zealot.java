package fiuba.algo3.tpfinal.unidades;

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
		
	}


}
