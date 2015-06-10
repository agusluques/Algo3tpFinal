package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Aire;
import fiuba.algo3.tpfinal.programa.Coordenada;
import fiuba.algo3.tpfinal.programa.Costo;
import fiuba.algo3.tpfinal.programa.Danio;

public class Espectro extends UnidadTerran {

	public Espectro() {
		this.vida.inicializarVida(120);
		this.miDanio = new Danio(20, 8);
		this.rango = new Rango(5, 5);
		this.tiempoDeConstruccion = 8;
		this.suministro = 2;
		this.costo = new Costo(150, 100);
		this.transporte = 0;

		// se inicializa en (0,0) solo para los tests
		this.posicion = new Coordenada(0, 0);
	}

	@Override
	public void atacado(Danio danio) {
		this.vida.bajarVida(danio.getDanioAire());
	}

	@Override
	public boolean sePuedeMoverA(Aire superficie) {
		return true;
	}

	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoAire();
	}
}
