package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;

public class Scout extends UnidadProtoss {

	public Scout() {
		this.vida = new VidaConEscudo(150, 100);
		this.miDanio = new Danio(14, 8);
		this.tiempoDeConstruccion = 9;
		this.suministro = 3;
		this.costo = new Costo(300, 100);
		this.transporte = 0;
		this.rangoDeAtaque = new RangoDeAtaque(4, 4);

	}

	public void atacado(Danio danio) {
		this.vida.recibirDanio(danio.getDanioAire());
		this.notificarObservador();
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoAire();
	}
}
