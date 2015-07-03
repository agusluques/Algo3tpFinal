package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;

public class Marine extends UnidadTerran {

	public Marine() {
		this.vida = new VidaSimple(40);
		this.miDanio = new Danio(6, 6);
		this.rangoDeAtaque = new RangoDeAtaque(4, 4);
		this.tiempoDeConstruccion = 3;
		this.suministro = 1;
		this.costo = new Costo(50);
		this.transporte = 1;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}
}
