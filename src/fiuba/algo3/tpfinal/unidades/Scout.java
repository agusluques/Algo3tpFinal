package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Scout extends UnidadProtoss {

	public Scout() {
		this.vida.inicializarVida(150);
		this.escudo.inicializarEscudo(100);
		this.miDanio = new Danio(14, 8);
		this.tiempoDeConstruccion = 9;
		this.suministro = 3;
		this.costo = new Costo(300, 100);
		this.transporte = 0;
		this.rangoDeAtaque = new RangoDeAtaque(4, 4);

	}

	public void atacado(Danio danio) {
		this.escudo.bajarEscudo(danio.getDanioAire(), this.vida);
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoAire();
	}
}
