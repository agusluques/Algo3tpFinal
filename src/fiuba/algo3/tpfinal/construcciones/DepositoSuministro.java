package fiuba.algo3.tpfinal.construcciones;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Tierra;
import fiuba.algo3.tpfinal.programa.VidaSimple;
import fiuba.algo3.tpfinal.unidades.RangoDeAtaque;

public class DepositoSuministro extends ConstruccionTerran {

	public DepositoSuministro() {
		this.vida = new VidaSimple(500);
		this.costo = new Costo(100);
		this.tiempoDeConstruccion = 6;
		this.superficieNecesaria = new Tierra();

	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	@Override
	public int aumentoDePoblacion() {
		return 5;
	}

}
