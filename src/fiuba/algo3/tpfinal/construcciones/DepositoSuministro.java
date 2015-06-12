package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.unidades.Rango;

public class DepositoSuministro extends ConstruccionTerran {

	public DepositoSuministro() {
		this.vida.inicializarVida(500);
		this.costo = new Costo(100);
		this.tiempoDeConstruccion = 6;
		this.superficieNecesaria = new Tierra();
	
	}



	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}
	
	@Override
	public int aumentoDePoblacion(){
		return 5;
	}

}
