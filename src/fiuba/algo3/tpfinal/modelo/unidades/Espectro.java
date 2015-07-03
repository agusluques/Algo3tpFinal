package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Aire;
import fiuba.algo3.tpfinal.modelo.programa.Costo;
import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.VidaSimple;

public class Espectro extends UnidadTerran {

	public Espectro() {
		this.vida = new VidaSimple(120);
		this.miDanio = new Danio(20, 8);
		this.rangoDeAtaque = new RangoDeAtaque(5, 5);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(150, 100);
		this.transporte = 0;

	}

	@Override
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
