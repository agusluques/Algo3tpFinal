package fiuba.algo3.tpfinal.modelo.construcciones;

import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Tierra;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;
import fiuba.algo3.tpfinal.modelo.unidades.RangoDeAtaque;

public class Pilon extends ConstruccionProtoss {

	public Pilon() {
		this.vida = new VidaConEscudo(300, 300);
		this.tiempoDeConstruccion = 5;
		this.costo = new Costo(100);
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
