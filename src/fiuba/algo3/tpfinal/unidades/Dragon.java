package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.VidaConEscudo;

public class Dragon extends UnidadProtoss {
	public Dragon() {
		this.vida = new VidaConEscudo(100,80);
		this.miDanio = new Danio(20, 20);
		this.tiempoDeConstruccion = 6;
		this.suministro = 2;
		this.costo = new Costo(125, 50);
		this.transporte = 4;
		this.rangoDeAtaque = new RangoDeAtaque(4, 4);

	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}
}
