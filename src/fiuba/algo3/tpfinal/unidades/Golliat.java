package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Golliat extends UnidadTerran {

	public Golliat() {
		this.vida.inicializarVida(125);
		this.miDanio = new Danio(10, 12);
		
		
		this.rangoDeAtaque = new RangoDeAtaque(6, 5);
		this.tiempoDeConstruccion = 6;
		this.suministro = 2;
		this.costo = new Costo(100, 50);
		this.transporte = 2;
		
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}
}
