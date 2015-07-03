package fiuba.algo3.tpfinal.modelo.unidades;

public class RangoDeAtaque {

	private int rangoTierra;
	private int rangoAire;

	public RangoDeAtaque(int tierra, int aire) {
		this.rangoTierra = tierra;
		this.rangoAire = aire;
	}

	public int getRangoTierra() {
		return rangoTierra;
	}

	public int getRangoAire() {
		return rangoAire;
	}

}
