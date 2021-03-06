package fiuba.algo3.tpfinal.modelo.unidades;

import fiuba.algo3.tpfinal.modelo.programa.Danio;
import fiuba.algo3.tpfinal.modelo.programa.Superficie;
import fiuba.algo3.tpfinal.modelo.programa.VidaConEscudo;

public class Alucinacion extends UnidadProtoss {

	private UnidadProtoss unidadCopiada;

	public Alucinacion(UnidadProtoss unidad) {
		this.vida = new VidaConEscudo(0, unidad.getCantidadDeEscudo());
		this.miDanio = new Danio(0, 0);
		this.rangoDeAtaque = unidad.getRangoCompleto();
		this.suministro = 0;
		this.unidadCopiada = unidad;
		this.transporte = unidadCopiada.transporte;
	}

	public int rangoDeAtaqueCorrespondiente(RangoDeAtaque rango) {
		return rango.getRangoTierra();
	}

	public UnidadProtoss getUnidadCopiada(){
		return unidadCopiada;
	}
	
	@Override
	public boolean sePuedeMoverA(Superficie superficie) {
		return unidadCopiada.sePuedeMoverA(superficie);
	}
}
