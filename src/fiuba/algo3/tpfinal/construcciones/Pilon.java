package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class Pilon extends ConstruccionProtoss {

	public Pilon() {
		this.vida.inicializarVida(300);
		this.escudo.inicializarEscudo(300);
		this.tiempoDeConstruccion = 5;
		this.costo = new Costo(100);
		this.superficieNecesaria = new Tierra();
	
	}



	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	@Override
	public int aumentoDePoblacion(){
		return 5;
	}
}
