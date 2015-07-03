package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

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
