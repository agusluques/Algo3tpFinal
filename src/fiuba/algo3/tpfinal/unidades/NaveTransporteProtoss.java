package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class NaveTransporteProtoss extends UnidadesProtoss {

	public NaveTransporteProtoss(){
		this.vida.inicializarVida(80);
		this.escudo.inicializarEscudo(60);
		this.miDanio = new Danio(0,0);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(200);
	}
	
	public void atacado(Danio danio){
		this.escudo.bajarEscudo(danio.getDanioAire(), this.vida);

	}
}
