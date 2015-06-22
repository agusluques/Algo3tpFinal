package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;
import fiuba.algo3.tpfinal.programa.VidaConEscudo;

public class Alucinacion extends UnidadProtoss {

	@SuppressWarnings("unused")
	private UnidadProtoss unidadCopiada;

	public Alucinacion(UnidadProtoss unidad) {
		this.vida = new VidaConEscudo(0, unidad.getEscudo());
		this.miDanio = new Danio(0, 0);
		this.rangoDeAtaque = unidad.getRangoCompleto();
		this.suministro = 0;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

}
