package fiuba.algo3.tpfinal.unidades;

import fiuba.algo3.tpfinal.programa.Danio;

public class Alucinacion extends UnidadesProtoss{
	
	
	@SuppressWarnings("unused")
	private UnidadesProtoss unidadCopiada;
	
	public Alucinacion(UnidadesProtoss unidad){
		this.vida.inicializarVida(0);
		this.escudo.inicializarEscudo(unidad.getEscudo());
		this.miDanio = new Danio(0,0);
		this.rango=unidad.getRangoCompleto();
		this.suministro = 0;
		this.unidadCopiada = unidad;
	}
	
	public int rangoDeAtaqueCorrespondiente(Rango rango) {
		return rango.getRangoTierra();
	}
	
	@Override
	public boolean estaMuerto() {
		return this.escudo.getEscudo()==0;
	}
	

}
