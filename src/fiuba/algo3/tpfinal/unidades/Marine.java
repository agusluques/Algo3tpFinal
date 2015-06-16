package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Marine extends UnidadTerran {

	public Marine() {
		this.vida.inicializarVida(40);
		this.miDanio = new Danio(6, 6);
		this.rangoDeAtaque = new RangoDeAtaque(4, 4);
		this.tiempoDeConstruccion = 3;
		this.suministro = 1;
		this.costo = new Costo(50);
		this.transporte = 1;

		// se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0, 0);

	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}
}
