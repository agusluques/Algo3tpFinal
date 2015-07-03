package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;

public class Zealot extends UnidadProtoss {

	public Zealot() {
		this.vida = new VidaConEscudo(100, 60);
		miDanio = new Danio(0, 8);
		this.tiempoDeConstruccion = 4;
		this.suministro = 2;
		this.costo = new Costo(100);
		this.transporte = 2;
		this.rangoDeAtaque = new RangoDeAtaque(1, 0);

	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

}
